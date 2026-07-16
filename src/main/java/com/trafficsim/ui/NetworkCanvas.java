package com.trafficsim.ui;

import com.trafficsim.editor.RoadNetworkEditor;
import com.trafficsim.model.RoadNetwork;
import com.trafficsim.simulation.SimulationEngine;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * TODO: render the road network, traffic lights and vehicles onto a canvas each frame, and
 * forward mouse clicks to the {@link RoadNetworkEditor}.
 *
 * Some things worth thinking about:
 * - Roads as lines (thickness could reflect lane count), with a direction arrow and a speed
 *   limit label.
 * - Junctions as circles; if one has a traffic light, indicate each approach's colour.
 * - Vehicles as small shapes positioned by interpolating along their current road, coloured by
 *   how close to their desired speed they are.
 * - Highlighting whatever's currently selected in the editor.
 */
public class NetworkCanvas extends Pane
{

    private final Canvas canvas = new Canvas();
    private final RoadNetworkEditor editor;
    private final SimulationEngine engine;

    public NetworkCanvas(RoadNetworkEditor editor, SimulationEngine engine)
    {
        this.editor = editor;
        this.engine = engine;
        getChildren().add(canvas);
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());
        canvas.widthProperty().addListener((obs, oldValue, newValue) -> render());
        canvas.heightProperty().addListener((obs, oldValue, newValue) -> render());

        setOnMouseClicked(e ->
        {
            editor.handleClick(e.getX(), e.getY());
            render();
        });
    }

    /** TODO: clear the canvas and redraw roads, junctions, lights and vehicles. */
    public void render()
    {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        RoadNetwork network = editor.getNetwork();

        graphicsContext.setStroke(Color.DARKGREY);
        graphicsContext.setFill(Color.DARKGREY);
        graphicsContext.setLineWidth(3);

        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (var road : network.getRoads())
        {
            graphicsContext.strokeLine(road.getStart().getX(), road.getStart().getY(), road.getEnd().getX(), road.getEnd().getY());
        }

        for (var junction : network.getJunctions())
        {
            graphicsContext.fillOval(junction.getX() - 5, junction.getY() - 5, 10, 10);
        }
    }
}
