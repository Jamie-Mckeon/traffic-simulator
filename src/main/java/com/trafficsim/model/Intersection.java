package com.trafficsim.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A junction in the road network. Connects two or more {@link Road}s.
 *
 * TODO: once an intersection has 2+ incoming roads, it should own a traffic light /
 * light-controller of some kind governing which approach has right of way. Decide how you
 * want to represent that (a separate TrafficLightController class? a field on this class?).
 */
public class Intersection {

    private final int id;
    private double x;
    private double y;
    private final List<Road> incomingRoads = new ArrayList<>();
    private final List<Road> outgoingRoads = new ArrayList<>();

    public Intersection(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Road> getIncomingRoads() {
        return incomingRoads;
    }

    public List<Road> getOutgoingRoads() {
        return outgoingRoads;
    }

    // TODO: package-private hooks for Road to call when it connects/disconnects from this
    // intersection (e.g. registerIncoming / registerOutgoing / unregisterRoad).

    // TODO: hasTrafficLight() / getLightController() once you've designed the light model.
}
