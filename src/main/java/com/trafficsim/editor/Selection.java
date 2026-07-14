package com.trafficsim.editor;

import com.trafficsim.model.Intersection;
import com.trafficsim.model.Road;

/** The single currently-selected network element, if any. Exactly one of {@link #road()} /
 *  {@link #intersection()} is non-null, or both are null for "nothing selected". */
public final class Selection
{

    public static final Selection NONE = new Selection(null, null);

    private final Road road;
    private final Intersection intersection;

    private Selection(Road road, Intersection intersection)
    {
        this.road = road;
        this.intersection = intersection;
    }

    public static Selection ofRoad(Road road)
    {
        return new Selection(road, null);
    }

    public static Selection ofIntersection(Intersection intersection)
    {
        return new Selection(null, intersection);
    }

    public boolean isEmpty()
    {
        return road == null && intersection == null;
    }

    public Road road()
    {
        return road;
    }

    public Intersection intersection()
    {
        return intersection;
    }
}
