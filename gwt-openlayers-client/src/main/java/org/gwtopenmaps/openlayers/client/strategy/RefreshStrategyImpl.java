package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class RefreshStrategyImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Strategy.Refresh();
    }-*/;

    public static native boolean activate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native boolean deactivate(JSObject self) /*-{
        return self.deactivate();
    }-*/;

    public static native void refresh(JSObject self) /*-{
        self.refresh();
    }-*/;
}
