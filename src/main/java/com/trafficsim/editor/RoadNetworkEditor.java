package com.trafficsim.editor;

import com.trafficsim.model.RoadNetwork;
import com.trafficsim.util.Observable;
import com.trafficsim.model.Junction;
import com.trafficsim.model.Road;
import java.util.Optional;

/**
 * Translates canvas clicks into edits on a {@link RoadNetwork}: placing junctions, drawing
 * roads between existing ones (a two-click flow — click a start junction, then an end
 * junction), selecting elements for a properties panel, and deleting elements.
 * <p>
 * Kept independent of JavaFX rendering (it only depends on the model package) so the
 * click-handling logic can be unit tested without a display.
 */
public class RoadNetworkEditor
{

    private final RoadNetwork network;
    private final Observable<EditorMode> mode = new Observable<>(EditorMode.SELECT);
    private final Observable<Selection> selection = new Observable<>(Selection.NONE);
    private Junction pendingRoadStart = null;

    public RoadNetworkEditor(RoadNetwork network)
    {
        this.network = network;
    }

    public RoadNetwork getNetwork()
    {
        return network;
    }

    public Observable<EditorMode> modeProperty()
    {
        return mode;
    }

    public Observable<Selection> selectionProperty()
    {
        return selection;
    }

    public Selection getSelection()
    {
        return selection.get();
    }

    /**
     * Handles a click on the canvas at (x, y). Behaviour depends on the current
     * {@link EditorMode}: selects whatever's under the click, places a new junction, starts
     * or completes drawing a road between two existing junctions (needs two clicks — the
     * first is stashed in {@link #pendingRoadStart} until the second arrives), or deletes
     * whatever's under the click.
     */
    public void handleClick(double x, double y)
    {
        switch (mode.get())
        {
            case SELECT ->
            {
                Optional<Junction> junctionHit = network.junctionNear(x, y, 12);
                if (junctionHit.isPresent())
                {
                    selection.set(Selection.ofJunction(junctionHit.get()));
                }
                else
                {
                    Optional<Road> roadHit = network.roadNear(x, y, 12);
                    if (roadHit.isPresent())
                    {
                        selection.set(Selection.ofRoad(roadHit.get()));
                    }
                    else
                    {
                        selection.set(Selection.NONE);
                    }
                }
            }

            case ADD_JUNCTION ->
            {
                network.addJunction(x, y);
            }

            case ADD_ROAD ->
            {
                Optional<Junction> junctionHit = network.junctionNear(x, y, 12);

                if (pendingRoadStart == null)
                {
                    if (junctionHit.isPresent())
                    {
                        pendingRoadStart = junctionHit.get();
                    }
                }
                else
                {
                    if (junctionHit.isPresent())
                    {
                        network.addRoad(pendingRoadStart, junctionHit.get());
                    }
                    pendingRoadStart = null;
                }
            }

            case DELETE ->
            {
                Optional<Junction> junctionHit = network.junctionNear(x, y, 12);
                if (junctionHit.isPresent())
                {
                    selection.set(Selection.ofJunction(junctionHit.get()));
                    deleteSelection();
                }
                else
                {
                    Optional<Road> roadHit = network.roadNear(x, y, 12);
                    if (roadHit.isPresent())
                    {
                        selection.set(Selection.ofRoad(roadHit.get()));
                        deleteSelection();
                    }
                    else
                    {
                        selection.set(Selection.NONE);
                    }
                }
            }
        }
    }

    /** Deletes whatever's currently selected from the network, if anything is. */
    public void deleteSelection()
    {
        Selection current = selection.get();

        if (!current.isEmpty())
        {
            if (current.road() != null)
            {
                network.removeRoad(current.road());
            }
            else if (current.junction() != null)
            {
                network.removeJunction(current.junction());
            }

            selection.set(Selection.NONE);
        }
    }
}
