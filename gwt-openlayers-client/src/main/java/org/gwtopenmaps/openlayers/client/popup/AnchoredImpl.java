package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
class AnchoredImpl
{

    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html,
        JSObject anchor, boolean closeBox, CloseListener closeBoxCallback) /*-{
        function callback(evt) {
        closeBoxCallback.@org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener::onPopupClose(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(evt);
        }
        return new $wnd.OpenLayers.Popup.Anchored(id, lonlat, size, html, anchor, closeBox, callback);
    }-*/;

    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor,
        boolean closeBox) /*-{
        return new $wnd.OpenLayers.Popup.Anchored(id, lonlat, size, html, anchor, closeBox);
    }-*/;

}
