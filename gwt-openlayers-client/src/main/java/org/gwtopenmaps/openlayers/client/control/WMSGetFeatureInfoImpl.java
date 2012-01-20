package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Dave Potts
 */
public class WMSGetFeatureInfoImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.WMSGetFeatureInfo();
    }-*/;

    public static native JSObject create(JSObject o) /*-{
        return new $wnd.OpenLayers.Control.WMSGetFeatureInfo(o);
    }-*/;

}
