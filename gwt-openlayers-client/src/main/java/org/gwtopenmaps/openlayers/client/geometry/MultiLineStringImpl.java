package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author giuseppe
 *
 */
public class MultiLineStringImpl
{

    public static native JSObject create(JSObject lines) /*-{
        return new $wnd.OpenLayers.Geometry.MultiLineString($wnd.gwt_openlayers_util.convertToArray(lines));
    }-*/;

}
