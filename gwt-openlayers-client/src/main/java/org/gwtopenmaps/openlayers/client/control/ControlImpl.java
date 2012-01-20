package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
class ControlImpl
{

    public static native boolean activate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native boolean deactivate(JSObject self) /*-{
        return self.deactivate();
    }-*/;

    public static native String getControlId(JSObject self) /*-{
        return self.id;
    }-*/;

    public static native boolean isActive(JSObject self)/*-{
        return (self.active === null) ? false : self.active;
    }-*/;

    public static native String getZIndex(JSObject self) /*-{
        return self.div.style.zIndex;
    }-*/;

    public static native void enable(JSObject control) /*-{
        control.active = true;
        control.handler.activate();
    }-*/;

    public static native void disable(JSObject control) /*-{
        control.active = false;
        control.handler.deactivate();
    }-*/;

    public static native JSObject getLayer(JSObject self) /*-{
        return self.handler.layer;
    }-*/;

}
