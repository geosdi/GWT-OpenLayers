/**
 * 
 */
package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.Style;
import com.eg.gwt.openLayers.client.geometry.Geometry;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 * Class name deviates intentionally from OpenLayers class name.
 * Both vector layers and vector features are called Vector in OpenLayers. 
 *
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
    
    /**
     * Provided together with getGeometry method, so geometry subclass can be 
     * instantiated from geometry, for example:
     *   Point p = Point.narrowToPoint(vf.getGeometry)
     * Where vf is a VectorFeature of which the geometry is determined by user input,
     * for example by drawing a feature.  
     */
    public String getGeometryClassName(){
        return VectorFeatureImpl.getGeometryClassName(getJSObject());
    }
    

    public JSObject getGeometry(){
        return VectorFeatureImpl.getGeometry(getJSObject());
    }

    //TODO provide getAttributes method 
    //if a VectorFeature has attributes, you want to access them...
    
}
