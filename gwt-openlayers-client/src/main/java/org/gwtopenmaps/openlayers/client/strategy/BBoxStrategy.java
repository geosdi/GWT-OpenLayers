package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class BBoxStrategy extends Strategy
{

    protected BBoxStrategy(JSObject strategy)
    {
        super(strategy);
    }

    public BBoxStrategy()
    {
        this(BBoxStrategyImpl.create());
    }
}
