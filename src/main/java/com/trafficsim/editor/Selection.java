package com.trafficsim.editor;

import com.trafficsim.model.Junction;
import com.trafficsim.model.Road;

/** The single currently-selected network element, if any. Exactly one of {@link #road()} /
 *  {@link #junction()} is non-null, or both are null for "nothing selected". */
public final class Selection
{

    public static final Selection NONE = new Selection(null, null);

    private final Road road;
    private final Junction junction;

    private Selection(Road road, Junction junction)
    {
        this.road = road;
        this.junction = junction;
    }

    public static Selection ofRoad(Road road)
    {
        return new Selection(road, null);
    }

    public static Selection ofJunction(Junction junction)
    {
        return new Selection(null, junction);
    }

    public boolean isEmpty()
    {
        return road == null && junction == null;
    }

    public Road road()
    {
        return road;
    }

    public Junction junction()
    {
        return junction;
    }
}
