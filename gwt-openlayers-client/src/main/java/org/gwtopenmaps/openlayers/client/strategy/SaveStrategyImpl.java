package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SaveStrategyImpl
{

    public static native boolean activate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native boolean deactivate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native void setAuto(JSObject self, boolean enable) /*-{
        self.auto = enable;
    }-*/;

    public static native void setAuto(JSObject self, int interval) /*-{
        self.auto = interval;
    }-*/;

    public static native void save(JSObject self) /*-{
        self.save();
    }-*/;

    public static native void save(JSObject self, JSObject array) /*-{
        self.save(array);
    }-*/;

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Strategy.Save();
    }-*/;
}
