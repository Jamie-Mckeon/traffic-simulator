package com.trafficsim.ui;

import com.trafficsim.editor.RoadNetworkEditor;
import com.trafficsim.model.Junction;
import com.trafficsim.model.RoadNetwork;
import com.trafficsim.simulation.SimulationEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Application entry point. Currently just opens a blank window — proves the Maven/JavaFX setup
 * works end to end.
 *
 * TODO: this is where everything gets wired together. Roughly:
 * - a {@code com.trafficsim.model.RoadNetwork} holding the roads/junctions
 * - a {@code com.trafficsim.editor.RoadNetworkEditor} wrapping it for click-to-edit
 * - a {@code com.trafficsim.simulation.SimulationEngine} driving vehicles forward
 * - a {@link NetworkCanvas} in the centre, an {@link EditorToolbar} on top, and a
 *   {@link PropertiesPanel} / {@link StatsPanel} on the side
 * - a JavaFX {@code AnimationTimer} calling the engine's step method and re-rendering the
 *   canvas once per frame
 */
public class MainApp extends Application
{

    @Override
    public void start(Stage stage)
    {
        BorderPane root = new BorderPane();

        RoadNetwork network = new RoadNetwork();
        seedDemoNetwork(network);
        RoadNetworkEditor roadNetworkEditor = new RoadNetworkEditor(network);
        SimulationEngine simulationEngine = new SimulationEngine(network);
        NetworkCanvas networkCanvas = new NetworkCanvas(roadNetworkEditor, simulationEngine);
        EditorToolbar editorToolbar = new EditorToolbar(roadNetworkEditor, simulationEngine, () -> simulationEngine.reset());

        root.setCenter(networkCanvas);
        networkCanvas.render();
        editorToolbar.setPrefWidth(200);
        root.setTop(editorToolbar);

        Scene scene = new Scene(root, 1200, 800);
        stage.setTitle("Traffic Simulator");
        stage.setScene(scene);
        stage.show();


    }

    /**
     * Places a small four-way crossroads so the app opens with something to look at, rather
     * than an empty canvas.
     */
    private void seedDemoNetwork(RoadNetwork network)
    {
        var centre = network.addJunction(600, 400);
        var north = network.addJunction(600, 150);
        var south = network.addJunction(600, 650);
        var east = network.addJunction(950, 400);
        var west = network.addJunction(250, 400);

        for (Junction outer : new Junction[]{north, south, east, west})
        {
            network.addRoad(outer, centre);
            network.addRoad(centre, outer);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
