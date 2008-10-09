package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JObjectArray;
import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Polygon extends Geometry {

    protected Polygon(JSObject element){
        super(element);
    }
    
    public Polygon(LinearRing[] rings){
        this(PolygonImpl.create((new JObjectArray(rings)).getJSObject()));
    }
}
