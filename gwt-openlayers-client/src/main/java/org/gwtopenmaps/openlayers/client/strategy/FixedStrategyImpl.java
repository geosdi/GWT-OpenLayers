package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * TODO ahhughes, which 'create' method should we keep?
 * @author HughesA
 *
 */
public class FixedStrategyImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Strategy.Fixed();
    }-*/;

    /**
     * @author lorenzo
     * @param options
     * @return
     */
    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Strategy.Fixed();
    }-*/;

    public static native void preload(JSObject self, boolean load) /*-{
        self.preload(load);
    }-*/;

    public static native void destroy(JSObject self) /*-{
        self.destroy();
    }-*/;

}
