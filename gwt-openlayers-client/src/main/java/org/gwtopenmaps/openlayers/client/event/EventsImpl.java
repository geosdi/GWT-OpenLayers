package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Edwin Commandeur - Atlis EJS
 *
 *
 */
class EventsImpl
{

    public static native JSObject register(JSObject self, String type, JSObject obj, JSObject handler) /*-{
        self.register(type, obj, handler);
    }-*/;

    public static native JSObject on(JSObject self, JSObject object) /*-{
        self.on(object);
    }-*/;

    public static native void unregister(JSObject self, String type, JSObject obj, JSObject handler) /*-{
        self.unregister(type, obj, handler);
    }-*/;

    public static native JSObject getMousePosition(JSObject self, JSObject evt) /*-{
        return self.getMousePosition(evt);
    }-*/;

    public static native JSObject stop(JSObject evt, boolean allowDefault) /*-{
        $wnd.OpenLayers.Event.stop(evt, allowDefault);
    }-*/;

}
