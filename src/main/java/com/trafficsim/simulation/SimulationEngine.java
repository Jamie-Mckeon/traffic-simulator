package com.trafficsim.simulation;

import com.trafficsim.model.RoadNetwork;
import com.trafficsim.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: this is the heart of the simulation. Each call to {@link #step} should, for one small
 * fixed timestep:
 * 1. advance every junction's traffic light state
 * 2. work out an acceleration for every vehicle (checking the vehicle/light ahead of it)
 * 3. integrate every vehicle's position/speed by that acceleration
 * 4. hand vehicles off onto their next road when they reach the end of the current one
 *    (respecting red/amber lights), or remove them once they reach their destination
 * 5. spawn new vehicles onto the network at some rate
 * 6. update {@link SimulationStats}
 *
 * Intended to be called once per frame (e.g. from a JavaFX AnimationTimer) with the elapsed time.
 */
public class SimulationEngine
{

    private final RoadNetwork network;
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final SimulationStats stats = new SimulationStats();
    private boolean running = false;

    public SimulationEngine(RoadNetwork network)
    {
        this.network = network;
    }

    public RoadNetwork getNetwork()
    {
        return network;
    }

    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }

    public SimulationStats getStats()
    {
        return stats;
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public void reset()
    {
        vehicles.clear();
    }

    /** TODO: advance the simulation by dtSeconds — see class doc for the steps involved. */
    public void step(double dtSeconds)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
