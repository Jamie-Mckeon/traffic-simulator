package com.trafficsim.ui;

import com.trafficsim.editor.RoadNetworkEditor;
import com.trafficsim.simulation.SimulationEngine;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 * TODO: render the road network, traffic lights and vehicles onto a canvas each frame, and
 * forward mouse clicks to the {@link RoadNetworkEditor}.
 *
 * Some things worth thinking about:
 * - Roads as lines (thickness could reflect lane count), with a direction arrow and a speed
 *   limit label.
 * - Intersections as circles; if one has a traffic light, indicate each approach's colour.
 * - Vehicles as small shapes positioned by interpolating along their current road, coloured by
 *   how close to their desired speed they are.
 * - Highlighting whatever's currently selected in the editor.
 */
public class NetworkCanvas extends Pane {

    private final Canvas canvas = new Canvas();
    private final RoadNetworkEditor editor;
    private final SimulationEngine engine;

    public NetworkCanvas(RoadNetworkEditor editor, SimulationEngine engine) {
        this.editor = editor;
        this.engine = engine;
        getChildren().add(canvas);
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        setOnMouseClicked(e -> {
            editor.handleClick(e.getX(), e.getY());
            render();
        });
    }

    /** TODO: clear the canvas and redraw roads, intersections, lights and vehicles. */
    public void render() {
        // no-op for now — nothing to draw yet.
    }
}
