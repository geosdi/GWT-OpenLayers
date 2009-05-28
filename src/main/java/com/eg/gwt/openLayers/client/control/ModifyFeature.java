/**
 * 
 */
package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ModifyFeature extends Control {
    
    protected ModifyFeature(JSObject modifyFeature){
        super(modifyFeature);
    }
    
    public ModifyFeature(Vector vectorLayer){
        this(ModifyFeatureImpl.create(vectorLayer.getJSObject()));
    }

}
