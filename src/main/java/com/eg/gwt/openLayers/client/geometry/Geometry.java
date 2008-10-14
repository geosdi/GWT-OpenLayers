package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 */
public abstract class Geometry extends OpenLayersWidget{
    
    public final static String LINEARRING_CLASS_NAME = "OpenLayers.Geometry.LinearRing";
    public final static String LINESTRING_CLASS_NAME = "OpenLayers.Geometry.LineString";
    public final static String POINT_CLASS_NAME = "OpenLayers.Geometry.Point";
    public final static String POLYGON_CLASS_NAME = "OpenLayers.Geometry.Polygon";
    
    
    protected Geometry(JSObject element){
        super(element);
    }
    
    public void destroy(){
        GeometryImpl.destroy(getJSObject());
    }
    
    
}
