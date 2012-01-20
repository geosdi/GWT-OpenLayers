package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author davek<at>komacke<dot>com
 *
 */

public class GetFeatureImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.GetFeature();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.GetFeature(options);
    }-*/;

    public static native void unselectAll(JSObject self) /*-{
        self.unselectAll();
    }-*/;

    public static native void selectBox(JSObject self, JSObject bounds) /*-{
        self.selectBox(bounds);
    }-*/;

    public static native JSObject getBounds(JSObject self) /*-{
        return self.bounds;
    }-*/;

}
