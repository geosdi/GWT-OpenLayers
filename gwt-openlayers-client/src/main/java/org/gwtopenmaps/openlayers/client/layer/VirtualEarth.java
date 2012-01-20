package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class VirtualEarth extends Layer
{

    public VirtualEarth(JSObject element)
    {
        super(element);
        // TODO Auto-generated constructor stub
    }

    public VirtualEarth(String name)
    {
        this(VirtualEarthImpl.create(name));
    }

    public VirtualEarth(String name, VirtualEarthOption params)
    {
        this(VirtualEarthImpl.create(name, params.getJSObject()));
    }

}
