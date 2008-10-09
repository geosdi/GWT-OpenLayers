/**
 * 
 */
package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PolygonImpl {

    public static native JSObject create(JSObject rings)/*-{
        return new $wnd.gwt.openlayers.relay.createPolygon(rings);
    }-*/;
    
}
