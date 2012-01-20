package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
class CanvasImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Canvas(name);
    }-*/;

    public static native void drawLine(JSObject self, JSObject p1, JSObject p2) /*-{
        self.drawLine(p1, p2);
    }-*/;
}
