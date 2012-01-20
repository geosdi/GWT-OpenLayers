/**
 *
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LinearRingImpl
{

    public static native JSObject create(JSObject points) /*-{
        return new $wnd.OpenLayers.Geometry.LinearRing($wnd.gwt_openlayers_util.convertToArray(points));
    }-*/;
}
