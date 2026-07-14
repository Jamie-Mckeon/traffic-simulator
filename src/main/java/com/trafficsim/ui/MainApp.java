package com.trafficsim.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Application entry point. Currently just opens a blank window — proves the Maven/JavaFX setup
 * works end to end.
 *
 * TODO: this is where everything gets wired together. Roughly:
 * - a {@code com.trafficsim.model.RoadNetwork} holding the roads/intersections
 * - a {@code com.trafficsim.editor.RoadNetworkEditor} wrapping it for click-to-edit
 * - a {@code com.trafficsim.simulation.SimulationEngine} driving vehicles forward
 * - a {@link NetworkCanvas} in the centre, an {@link EditorToolbar} on top, and a
 *   {@link PropertiesPanel} / {@link StatsPanel} on the side
 * - a JavaFX {@code AnimationTimer} calling the engine's step method and re-rendering the
 *   canvas once per frame
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setCenter(new Label("Traffic Simulator"));

        Scene scene = new Scene(root, 1200, 800);
        stage.setTitle("Traffic Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
