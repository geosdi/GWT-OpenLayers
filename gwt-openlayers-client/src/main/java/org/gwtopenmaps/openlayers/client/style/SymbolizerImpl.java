package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerImpl
{

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Symbolizer();
    }-*/;

    public static native void setZIndex(JSObject self, int zIndex) /*-{
        self.zIndex = zIndex;
    }-*/;

    public static native int getZIndex(JSObject self) /*-{
        return self.zIndex;
    }-*/;
}
