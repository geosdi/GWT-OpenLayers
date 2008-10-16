package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JObjectArray;
import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Polygon extends Collection {

    protected Polygon(JSObject element){
        super(element);
    }

    public static Polygon narrowToPolygon(JSObject polygon){
        return (polygon == null)?null: new Polygon(polygon);
    }
    
    public Polygon(LinearRing[] rings){
        this(PolygonImpl.create((new JObjectArray(rings)).getJSObject()));
    }
}
