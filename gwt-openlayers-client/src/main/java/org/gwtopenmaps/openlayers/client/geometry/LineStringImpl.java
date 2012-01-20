/**
 *
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineStringImpl
{

    public static native JSObject create(JSObject points)
    /*-{
            return new $wnd.OpenLayers.Geometry.LineString($wnd.gwt_openlayers_util.convertToArray(points));
    }-*/;
}
