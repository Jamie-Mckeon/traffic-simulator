package com.trafficsim.ui;

import com.trafficsim.simulation.SimulationStats;
import javafx.scene.layout.VBox;

/**
 * TODO: live analytics overlay — active vehicle count, average speed, throughput, etc. A
 * JavaFX {@code LineChart} could show throughput over time so the effect of light-timing or
 * speed-limit changes on flow is visible rather than just implied.
 */
public class StatsPanel extends VBox {

    public void update(SimulationStats stats) {
        // TODO: refresh labels/chart from the latest stats.
    }

    public void reset() {
        // TODO: clear any accumulated chart history.
    }
}
