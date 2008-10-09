/**
 * 
 */
package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineStringImpl {

    public static native JSObject create(JSObject points)
    /*-{
       return new $wnd.gwt.openlayers.relay.createLineString(points);
    }-*/;
}
