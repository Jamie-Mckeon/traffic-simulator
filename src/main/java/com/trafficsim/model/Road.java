package com.trafficsim.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A directed road segment between two intersections.
 *
 * TODO: decide whether a bidirectional street is one Road or two (probably two, one per
 * direction, sharing the same pair of intersections).
 */
public class Road {

    public static final double DEFAULT_SPEED_LIMIT_KPH = 50;
    public static final int DEFAULT_LANES = 1;

    private final int id;
    private final Intersection start;
    private final Intersection end;

    private double speedLimitKph = DEFAULT_SPEED_LIMIT_KPH;
    private int lanes = DEFAULT_LANES;

    private final List<Vehicle> vehicles = new ArrayList<>();

    public Road(int id, Intersection start, Intersection end) {
        this.id = id;
        this.start = start;
        this.end = end;
        // TODO: register this road with start/end Intersection (see Intersection TODOs).
    }

    public int getId() {
        return id;
    }

    public Intersection getStart() {
        return start;
    }

    public Intersection getEnd() {
        return end;
    }

    public double getSpeedLimitKph() {
        return speedLimitKph;
    }

    public void setSpeedLimitKph(double speedLimitKph) {
        this.speedLimitKph = speedLimitKph;
    }

    public int getLanes() {
        return lanes;
    }

    public void setLanes(int lanes) {
        this.lanes = lanes;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /** TODO: compute from the distance between start and end intersections. */
    public double getLengthMeters() {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: return the vehicle immediately ahead of {@code position} on this road, or null. */
    public Vehicle findLeader(double positionMeters) {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: expose whatever light/phase state governs entry into {@code end}, or null if none. */
    public Object getApproachLight() {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
