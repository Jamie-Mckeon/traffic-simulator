package com.trafficsim.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoadTest
{
    @Test
    void horizontalRoadHasCorrectLength()
    {
        RoadNetwork network = new RoadNetwork();
        Junction start = network.addJunction(0, 0);
        Junction end = network.addJunction(300, 0);

        Road road = network.addRoad(start, end);

        assertEquals(300.0, road.getLengthMeters(), 0.001);
    }

    @Test
    void verticalRoadHasCorrectLength()
    {
        RoadNetwork network = new RoadNetwork();
        Junction start = network.addJunction(0, 0);
        Junction end = network.addJunction(0, 300);

        Road road = network.addRoad(start, end);

        assertEquals(300.0, road.getLengthMeters(), 0.001);
    }

    @Test
    void diagonalRoadHasCorrectLength()
    {
        RoadNetwork network = new RoadNetwork();
        Junction start = network.addJunction(0, 0);
        Junction end = network.addJunction(300, 300);

        Road road = network.addRoad(start, end);

        assertEquals(424.264, road.getLengthMeters(), 0.001);
    }
}
