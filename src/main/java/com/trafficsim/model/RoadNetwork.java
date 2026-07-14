package com.trafficsim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Owns every {@link Intersection} and {@link Road} in the simulated network.
 *
 * TODO: this is the natural home for graph algorithms the rest of the app needs:
 * - hit-testing (which intersection/road is near a given canvas point, for the editor)
 * - routing (shortest/fastest path between two intersections, for vehicle spawning)
 * - reachability (which intersections can a vehicle actually get to from here)
 */
public class RoadNetwork
{

    private final AtomicInteger nextIntersectionId = new AtomicInteger(1);
    private final AtomicInteger nextRoadId = new AtomicInteger(1);

    private final List<Intersection> intersections = new ArrayList<>();
    private final List<Road> roads = new ArrayList<>();

    public Intersection addIntersection(double x, double y)
    {
        Intersection intersection = new Intersection(nextIntersectionId.getAndIncrement(), x, y);
        intersections.add(intersection);
        return intersection;
    }

    public Road addRoad(Intersection start, Intersection end)
    {
        Road road = new Road(nextRoadId.getAndIncrement(), start, end);
        roads.add(road);
        return road;
    }

    public void removeRoad(Road road)
    {
        roads.remove(road);
        // TODO: also unregister the road from its start/end Intersection.
    }

    public void removeIntersection(Intersection intersection)
    {
        intersections.remove(intersection);
        // TODO: also remove/clean up any roads connected to this intersection.
    }

    public List<Intersection> getIntersections()
    {
        return intersections;
    }

    public List<Road> getRoads()
    {
        return roads;
    }

    /** TODO: find the intersection within {@code radius} pixels of (x, y), if any. */
    public Optional<Intersection> intersectionNear(double x, double y, double radius)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: find the road whose segment passes within {@code tolerance} pixels of (x, y). */
    public Optional<Road> roadNear(double x, double y, double tolerance)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: shortest/fastest path from startRoad's end to destination. Consider Dijkstra,
     *  weighting edges by estimated travel time (length / speed limit). */
    public List<Road> findRoute(Road startRoad, Intersection destination)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: every intersection reachable from {@code from} by following outgoing roads. */
    public Set<Intersection> reachableFrom(Intersection from)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
