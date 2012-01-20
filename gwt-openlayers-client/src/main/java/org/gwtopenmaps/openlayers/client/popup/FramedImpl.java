package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen?
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class FramedImpl
{

    /*
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     * Added by Digpro.
     */
    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html,
        JSObject anchor, boolean closeBox, CloseListener closeBoxCallback) /*-{
        
        function callback(evt) {
        closeBoxCallback.@org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener::onPopupClose(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(evt);
        }
        
        return new $wnd.OpenLayers.Popup.Framed(id, lonlat, size, html, anchor, closeBox, callback);
    }-*/;

    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor,
        boolean closeBox) /*-{
        var framed = new $wnd.OpenLayers.Popup.Framed(id, lonlat, size, html, anchor, closeBox);
        
        if (size == null)
        anchored.autoSize = true;
        
        return framed;
    }-*/;
}
