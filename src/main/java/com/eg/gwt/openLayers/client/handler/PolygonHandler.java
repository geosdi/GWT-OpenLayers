package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Equal to Polygon handler, but avoids name conflicts with Polygon geometry
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PolygonHandler extends Polygon {

    protected PolygonHandler(JSObject element) {
        super(element);
    }
    
}
