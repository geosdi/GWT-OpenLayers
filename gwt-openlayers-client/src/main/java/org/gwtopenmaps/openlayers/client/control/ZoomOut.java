package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 * requires OpenLayers 2.7 or higher
 */
public class ZoomOut extends Control
{

    protected ZoomOut(JSObject zoomOut)
    {
        super(zoomOut);
    }

    public ZoomOut()
    {
        this(ZoomOutImpl.create());
    }
}
