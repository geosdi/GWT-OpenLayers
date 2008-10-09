/**
 * 
 */
package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.Style;
import com.eg.gwt.openLayers.client.geometry.Geometry;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 * Name deviates intentionally from name OpenLayers.
 * Both vector layers and vector features are called Vector in OpenLayers. 
 *  
 */
public class VectorFeature extends Feature {

    public VectorFeature (Geometry g){
        super(VectorFeatureImpl.create(g.getJSObject()));
    }
    
    public VectorFeature (Geometry g, Style s){
        super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
    }
}
