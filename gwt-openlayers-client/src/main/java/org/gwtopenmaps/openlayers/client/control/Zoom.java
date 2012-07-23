package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Jon Britton
 */
public class Zoom extends Control
{

    protected Zoom(JSObject zoom)
    {
        super(zoom);
    }

    public Zoom()
    {
        this(ZoomImpl.create());
    }
}
