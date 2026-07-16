package com.trafficsim.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A directed road segment between two junctions.
 *
 * TODO: decide whether a bidirectional street is one Road or two (probably two, one per
 * direction, sharing the same pair of junctions).
 */
public class Road
{

    public static final double DEFAULT_SPEED_LIMIT_KPH = 50;
    public static final int DEFAULT_LANES = 1;

    private final int id;
    private final Junction start;
    private final Junction end;

    private double speedLimitKph = DEFAULT_SPEED_LIMIT_KPH;
    private int lanes = DEFAULT_LANES;

    private final List<Vehicle> vehicles = new ArrayList<>();

    public Road(int id, Junction start, Junction end)
    {
        this.id = id;
        this.start = start;
        this.end = end;
        // TODO: register this road with start/end Junction (see Junction TODOs).
    }

    public int getId()
    {
        return id;
    }

    public Junction getStart()
    {
        return start;
    }

    public Junction getEnd()
    {
        return end;
    }

    public double getSpeedLimitKph()
    {
        return speedLimitKph;
    }

    public void setSpeedLimitKph(double speedLimitKph)
    {
        this.speedLimitKph = speedLimitKph;
    }

    public int getLanes()
    {
        return lanes;
    }

    public void setLanes(int lanes)
    {
        this.lanes = lanes;
    }

    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }

    /** Straight-line distance between this road's start and end junctions, in metres. */
    public double getLengthMeters()
    {
        double xDifference = this.start.getX() - this.end.getX();
        double yDifference = this.start.getY() - this.end.getY();

        return Math.sqrt(xDifference * xDifference + yDifference * yDifference);
    }

    /** TODO: return the vehicle immediately ahead of {@code position} on this road, or null. */
    public Vehicle findLeader(double positionMeters)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: expose whaqtever light/phase state governs entry into {@code end}, or null if none. */
    public Object getApproachLight()
    {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
