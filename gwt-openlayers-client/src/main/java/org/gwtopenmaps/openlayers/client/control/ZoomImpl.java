package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Jon Britton
 */
public class ZoomImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Zoom();
    }-*/;

}
