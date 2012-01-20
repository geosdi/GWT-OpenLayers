package org.gwtopenmaps.openlayers.client.popup;

import com.google.gwt.dom.client.Element;

import org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis Information Systems
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class FramedCloudImpl
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
        
        var framedCloud = new $wnd.OpenLayers.Popup.FramedCloud(id, lonlat, size, html, anchor, closeBox, callback);
        //if (size == null)
        //  anchored.autoSize = true;
        return framedCloud;
    }-*/;

    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor,
        boolean closeBox) /*-{
        var framedCloud = new $wnd.OpenLayers.Popup.FramedCloud(id, lonlat, size, html, anchor, closeBox);
        //if (size == null)
        //  anchored.autoSize = true;
        return framedCloud;
    }-*/;

    public static native Element getContentDiv(JSObject popup) /*-{
        return popup.contentDiv;
    }-*/;
}
