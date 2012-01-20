package org.gwtopenmaps.openlayers.client.control;

import com.google.gwt.user.client.Element;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
class ScaleImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Scale();
    }-*/;

    public static native JSObject create(Element div) /*-{
        return new $wnd.OpenLayers.Control.Scale(div);
    }-*/;
}
