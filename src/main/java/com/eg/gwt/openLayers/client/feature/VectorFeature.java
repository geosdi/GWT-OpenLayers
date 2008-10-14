/**
 * 
 */
package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Style;
import com.eg.gwt.openLayers.client.geometry.Geometry;
import com.eg.gwt.openLayers.client.geometry.LineString;
import com.eg.gwt.openLayers.client.geometry.LinearRing;
import com.eg.gwt.openLayers.client.geometry.Point;
import com.eg.gwt.openLayers.client.geometry.Polygon;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 * Name deviates intentionally from name OpenLayers class name.
 * Both vector layers and vector features are called Vector in OpenLayers. 
 *  
 */
public class VectorFeature extends Feature {

    public VectorFeature (JSObject vectorFeature){
        super(vectorFeature);
    }
    
    public VectorFeature (Geometry g){
        super(VectorFeatureImpl.create(g.getJSObject()));
    }
    
    public VectorFeature (Geometry g, Style s){
        super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
    }
    
    //TODO better to make this private?
    public String getGeometryClassName(){
        return VectorFeatureImpl.getGeometryClassName(getJSObject());
    }
    
    /**
     * Retrieve the coordinates of the geometry as an array of arrays of two doubles.
     * The first double represents an x and the second an y coordinate.
     * 
     * This method is only valid for MultiPoint geometries.
     */
    //TODO should this method return a double[][] or a Point[]
    // Points have a getX & getY method, but come with more stuff attached (more costly to instantiate 
    public double[][] getCoordinateArray(){
                
        if(getGeometryClassName().equals(Geometry.POINT_CLASS_NAME)){
            Point p = new Point(VectorFeatureImpl.getGeometry(getJSObject()));
            double[] coordinates = { p.getX(), p.getY() };
            double[][] coordinateArray = {coordinates};
            return coordinateArray;
        }else if(getGeometryClassName().equals(Geometry.LINESTRING_CLASS_NAME)){
            LineString l = new LineString(VectorFeatureImpl.getGeometry(getJSObject()));
            return null;
        }else if(getGeometryClassName().equals(Geometry.LINEARRING_CLASS_NAME)){
            LinearRing r = new LinearRing(VectorFeatureImpl.getGeometry(getJSObject()));
            return null;            
        }else if(getGeometryClassName().equals(Geometry.POLYGON_CLASS_NAME)){
            //TODO polygon is not a Multipoint geometry
            // it consists of Multipoint geometries!!!
            Polygon p = new Polygon(VectorFeatureImpl.getGeometry(getJSObject()));
            return null;
        }else{
            return null;
        }
    }
    
}
