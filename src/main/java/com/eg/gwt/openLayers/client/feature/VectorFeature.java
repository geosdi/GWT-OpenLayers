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
 * Class name deviates intentionally from OpenLayers class name.
 * Both vector layers and vector features are called Vector in OpenLayers. 
 *  
 */
public class VectorFeature extends Feature {

    protected VectorFeature (JSObject vectorFeature){
        super(vectorFeature);
    }
    
    public VectorFeature (Geometry g){
        super(VectorFeatureImpl.create(g.getJSObject()));
    }
    
    public VectorFeature (Geometry g, Style s){
        super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
    }
    
    //static factory method
    // naming convention strokes with narrowToOpenLayersWidget
    public static VectorFeature narrowToVectorFeature(JSObject vectorFeature){
        return (vectorFeature == null)?null:new VectorFeature(vectorFeature);
    }
    
    //TODO better to make this private?
    public String getGeometryClassName(){
        return VectorFeatureImpl.getGeometryClassName(getJSObject());
    }
    
    //TODO better to make this private?
    public JSObject getGeometry(){
        return VectorFeatureImpl.getGeometry(getJSObject());
    }
    
    /**
     * Retrieve the coordinates of the geometry as an array of arrays of two doubles.
     * The first double represents an x and the second an y coordinate.
     * 
     * This method is only valid for MultiPoint geometries.
     */
    //TODO this method should return a method that can easily be questioned for
    // a point, an array of points, or even an array with arrays of points
    // think about return object
    
    //TODO now geometries are instantiated from a JSObject with a constructor
    // that would normally be protected => alternative add static factory method:
    // wrapperOf() or better fromJSObject()
    public double[][] getCoordinateArray(){
                
        if(getGeometryClassName().equals(Geometry.POINT_CLASS_NAME)){
            Point p = new Point(getGeometry());
            double[] coordinates = p.getXY();
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
