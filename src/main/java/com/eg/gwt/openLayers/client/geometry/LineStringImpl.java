/**
 * 
 */
package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineStringImpl {

    public static native JSObject create(JSObject points)
    /*-{
        return new $wnd.gwt_openlayers_util.relay.createLineString(points);
    }-*/;
}
