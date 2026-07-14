package com.trafficsim.model;

import java.util.List;

/**
 * A single simulated car.
 *
 * TODO: pick a car-following model (e.g. the Intelligent Driver Model — look it up) to decide
 * how a vehicle accelerates/brakes based on whatever is ahead of it (another vehicle, or a red
 * light). That physics probably belongs in the simulation package, not here — this class should
 * mostly just hold state (position, speed, route) and know how to integrate one step given an
 * acceleration value handed to it.
 */
public class Vehicle
{

    private final int id;
    private final List<Road> route;
    private int routeIndex = 0;
    private Road currentRoad;
    private double positionMeters = 0;
    private double speedMps = 0;

    private final double spawnTimeSeconds;

    public Vehicle(int id, List<Road> route, double spawnTimeSeconds)
    {
        this.id = id;
        this.route = route;
        this.currentRoad = route.get(0);
        this.spawnTimeSeconds = spawnTimeSeconds;
        // TODO: decide per-vehicle physical parameters (length, desired speed, max
        // acceleration/deceleration, following gap/headway) — fixed, random, or configurable?
    }

    public int getId()
    {
        return id;
    }

    public Road getCurrentRoad()
    {
        return currentRoad;
    }

    public double getPositionMeters()
    {
        return positionMeters;
    }

    public double getSpeedMps()
    {
        return speedMps;
    }

    public double getSpawnTimeSeconds()
    {
        return spawnTimeSeconds;
    }

    public boolean hasNextRoad()
    {
        return routeIndex + 1 < route.size();
    }

    public Road peekNextRoad()
    {
        return hasNextRoad() ? route.get(routeIndex + 1) : null;
    }

    /** TODO: update speedMps/positionMeters given one timestep of the given acceleration. */
    public void integrate(double accelerationMps2, double dtSeconds)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: move this vehicle onto route.get(++routeIndex), carrying over overshoot distance. */
    public void advanceToNextRoad(double overshootMeters)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
