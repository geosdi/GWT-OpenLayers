package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SnappingImpl
{

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Snapping(options);
    }-*/;

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Snapping();
    }-*/;

    public static native boolean activate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native boolean deactivate(JSObject self) /*-{
        return self.deactivate();
    }-*/;

    public static native void setLayer(JSObject self, JSObject vector) /*-{
        self.setLayer(vector);
    }-*/;

    public static native void addTargetLayer(JSObject self, JSObject vector) /*-{
        self.addTargetLayer(vector);
    }-*/;

    public static native void removeTargetLayer(JSObject self, JSObject vector) /*-{
        self.removeTargetLayer(vector);
    }-*/;

    public static native void addTarget(JSObject self, JSObject target) /*-{
        self.addTarget(target);
    }-*/;

    public static native void removeTarget(JSObject self, JSObject target) /*-{
        self.removeTarget(target);
    }-*/;

}
