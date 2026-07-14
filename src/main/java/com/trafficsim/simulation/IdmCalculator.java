package com.trafficsim.simulation;

import com.trafficsim.model.Vehicle;

/**
 * TODO: implement a car-following model here. The Intelligent Driver Model (Treiber, Hennig &amp;
 * Helbing, 2000) is a well-known, well-documented choice: each vehicle's acceleration is a
 * function of its own speed, desired speed, and the gap/closing-speed to whatever is directly
 * ahead of it (a slower vehicle, or a stationary "virtual vehicle" representing a red light).
 * Worth reading up on before implementing — the formula alone won't make sense without the
 * intuition behind it.
 */
public final class IdmCalculator {

    private IdmCalculator() {
    }

    /**
     * @param gapMeters distance to whatever is ahead, or {@link Double#POSITIVE_INFINITY} if clear
     * @param obstacleSpeedMps speed of whatever is ahead (0 for a red light); ignored if gap is infinite
     */
    public static double computeAcceleration(Vehicle vehicle, double gapMeters, double obstacleSpeedMps) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
