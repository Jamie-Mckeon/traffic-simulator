package com.trafficsim.model;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class RoadNetworkTest
{
    @Test
    void junctionNearFindsAJunctionWithinRadius()
    {
        RoadNetwork network = new RoadNetwork();
        Junction junction = network.addJunction(10, 10);

        Optional<Junction> result = network.junctionNear(8, 7, 4);

        assertTrue(result.isPresent());
        assertEquals(junction, result.get());
    }

    @Test
    void junctionNearReturnsEmptyWhenNothingIsClose()
    {
        RoadNetwork network = new RoadNetwork();
        Junction junction = network.addJunction(10, 10);

        Optional<Junction> result = network.junctionNear(8, 7, 2);

        assertTrue(result.isEmpty());
    }

    @Test
    void junctionNearReturnsTheClosestOfTwoCandidates()
    {
        RoadNetwork network = new RoadNetwork();

        Junction junction1 = network.addJunction(10, 10);
        Junction junction2 = network.addJunction(12, 12);

        Optional<Junction> result = network.junctionNear(8, 7, 4);

        assertTrue(result.isPresent());
        assertEquals(junction1, result.get());
    }

    @Test
    void roadNearFindsARoadNearItsMiddle()
    {
        RoadNetwork network = new RoadNetwork();
        Junction start = network.addJunction(0, 0);
        Junction end = network.addJunction(300, 0);
        Road road = network.addRoad(start, end);

        Optional<Road> result = network.roadNear(140, 0, 15);

        assertTrue(result.isPresent());
        assertEquals(road, result.get());
    }

    @Test
    void roadNearClampsToNearestEndpointBeyondTheSegment()
    {
        RoadNetwork network = new RoadNetwork();
        Junction start = network.addJunction(0, 0);
        Junction end = network.addJunction(300, 0);
        Road road = network.addRoad(start, end);

        Optional<Road> result = network.roadNear(316, 0, 15);

        assertTrue(result.isEmpty());
    }

    @Test
    void roadNearReturnsEmptyWhenNothingIsClose()
    {
        RoadNetwork network = new RoadNetwork();
        Junction start = network.addJunction(0, 0);
        Junction end = network.addJunction(300, 0);
        Road road = network.addRoad(start, end);

        Optional<Road> result = network.roadNear(1000, 1000, 15);

        assertTrue(result.isEmpty());
    }
}
