package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JObjectArray;
import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LinearRing extends LineString {

    protected LinearRing(JSObject element){
        super(element);
    }
    
    public LinearRing(Point[] pts){
        this(LinearRingImpl.create((new JObjectArray(pts).getJSObject())));
    }
}
