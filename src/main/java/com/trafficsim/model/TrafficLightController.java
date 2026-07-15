package com.trafficsim.model;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: design the state machine for right-of-way at a junction with 2+ incoming roads.
 *
 * Some questions to work through:
 * - How many approaches can be green at once (just one, generalising to any junction shape;
 *   or fixed phase pairs like a real 4-way crossroads)?
 * - What clearance intervals do you need between one approach going red and the next going
 *   green (amber time, all-red time) so vehicles don't collide?
 * - How is per-approach green duration configured/edited from the UI?
 */
public class TrafficLightController
{

    public enum LightState
    {
        RED, AMBER, GREEN
    }

    public class ApproachLight
    {
        private final Road road;
        private double greenDurationSeconds = 10.0;

        private ApproachLight(Road road)
        {
            this.road = road;
        }

        public Road getRoad()
        {
            return road;
        }

        public double getGreenDurationSeconds()
        {
            return greenDurationSeconds;
        }

        public void setGreenDurationSeconds(double seconds)
        {
            this.greenDurationSeconds = seconds;
        }

        /** TODO: derive from the controller's current phase/timer state. */
        public LightState getState()
        {
            throw new UnsupportedOperationException("TODO: implement");
        }
    }

    private final Junction junction;
    private final List<ApproachLight> approaches = new ArrayList<>();

    public TrafficLightController(Junction junction, List<Road> incomingRoads)
    {
        this.junction = junction;
        for (Road road : incomingRoads)
        {
            approaches.add(new ApproachLight(road));
        }
    }

    public Junction getJunction()
    {
        return junction;
    }

    public List<ApproachLight> getApproaches()
    {
        return approaches;
    }

    public ApproachLight approachFor(Road road)
    {
        for (ApproachLight a : approaches)
        {
            if (a.getRoad() == road)
            {
                return a;
            }
        }
        return null;
    }

    /** TODO: advance whatever phase/timer model you design by dtSeconds of simulated time. */
    public void update(double dtSeconds)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
