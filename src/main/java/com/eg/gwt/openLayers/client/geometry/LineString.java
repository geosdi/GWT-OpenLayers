/**
 * 
 */
package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.util.JObjectArray;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineString extends Curve{

    protected LineString(JSObject element){
        super(element);
    }

    public static LineString narrowToLineString(JSObject lineString){
        return (lineString == null)?null: new LineString(lineString);
    }
    
    public LineString(Point[] pts){
        this(LineStringImpl.create((new JObjectArray(pts)).getJSObject()));
    }

}
