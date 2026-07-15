package com.trafficsim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Owns every {@link Junction} and {@link Road} in the simulated network.
 * <p>
 * TODO: this is the natural home for graph algorithms the rest of the app needs:
 * - hit-testing (which junction/road is near a given canvas point, for the editor)
 * - routing (shortest/fastest path between two junctions, for vehicle spawning)
 * - reachability (which junctions can a vehicle actually get to from here)
 */
public class RoadNetwork
{

    private final AtomicInteger nextJunctionId = new AtomicInteger(1);
    private final AtomicInteger nextRoadId = new AtomicInteger(1);

    private final List<Junction> junctions = new ArrayList<>();
    private final List<Road> roads = new ArrayList<>();

    public Junction addJunction(double x, double y)
    {
        Junction junction = new Junction(nextJunctionId.getAndIncrement(), x, y);
        junctions.add(junction);
        return junction;
    }

    public Road addRoad(Junction start, Junction end)
    {
        Road road = new Road(nextRoadId.getAndIncrement(), start, end);
        roads.add(road);
        return road;
    }

    public void removeRoad(Road road)
    {
        roads.remove(road);
        // TODO: also unregister the road from its start/end Junction.
    }

    public void removeJunction(Junction junction)
    {
        junctions.remove(junction);
        // TODO: also remove/clean up any roads connected to this junction.
    }

    public List<Junction> getJunctions()
    {
        return junctions;
    }

    public List<Road> getRoads()
    {
        return roads;
    }

    /**
     * TODO: find the junction within {@code radius} pixels of (x, y), if any.
     */
    public Optional<Junction> junctionNear(double x, double y, double radius)
    {
        Junction closestJunction = null;
        double closestJunctionDistance = Double.MAX_VALUE;

        for (Junction junction : junctions)
        {
            double dx = junction.getX() - x;
            double dy = junction.getY() - y;
            double distanceBetweenJunctionAndClick = Math.sqrt(dx * dx + dy * dy);

            if (distanceBetweenJunctionAndClick <= radius && distanceBetweenJunctionAndClick < closestJunctionDistance)
            {
                closestJunction = junction;
                closestJunctionDistance = distanceBetweenJunctionAndClick;
            }
        }

        return Optional.ofNullable(closestJunction);
    }

    /**
     * TODO: find the road whose segment passes within {@code tolerance} pixels of (x, y).
     */
    public Optional<Road> roadNear(double x, double y, double tolerance)
    {
        Road closestRoad = null;
        double closestRoadDistance = Double.MAX_VALUE;

        for (Road road : roads)
        {
            double startX = road.getStart().getX();
            double startY = road.getStart().getY();
            double endX = road.getEnd().getX();
            double endY = road.getEnd().getY();

            // Vector along the road segment, from start to end.
            double segmentDx = endX - startX;
            double segmentDy = endY - startY;
            double segmentLengthSquared = segmentDx * segmentDx + segmentDy * segmentDy;

            // Where the click's projection onto the *infinite* line through start/end would
            // fall, as a fraction of the segment (0 = at start, 1 = at end). Clamp it into
            // [0, 1] so the closest point stays on the actual segment, not the infinite line.
            double t = segmentLengthSquared == 0
                    ? 0
                    : ((x - startX) * segmentDx + (y - startY) * segmentDy) / segmentLengthSquared;
            t = Math.max(0, Math.min(1, t));

            double closestPointX = startX + t * segmentDx;
            double closestPointY = startY + t * segmentDy;

            double dx = closestPointX - x;
            double dy = closestPointY - y;
            double distanceBetweenRoadAndClick = Math.sqrt(dx * dx + dy * dy);

            if (distanceBetweenRoadAndClick <= tolerance && distanceBetweenRoadAndClick < closestRoadDistance)
            {
                closestRoad = road;
                closestRoadDistance = distanceBetweenRoadAndClick;
            }
        }

        return Optional.ofNullable(closestRoad);
    }

    /**
     * TODO: shortest/fastest path from startRoad's end to destination. Consider Dijkstra,
     *  weighting edges by estimated travel time (length / speed limit).
     */
    public List<Road> findRoute(Road startRoad, Junction destination)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /**
     * TODO: every junction reachable from {@code from} by following outgoing roads.
     */
    public Set<Junction> reachableFrom(Junction from)
    {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
