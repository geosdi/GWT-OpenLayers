/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

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
