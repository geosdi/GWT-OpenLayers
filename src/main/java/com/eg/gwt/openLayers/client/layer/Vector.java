package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JObjectArray;
import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.feature.VectorFeature;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Vector extends Layer {

    protected Vector(JSObject element) {
        super(element);
    }

    public Vector(String name) {
        this(VectorImpl.create(name));
    }
    
    public static Vector narrowToVector(JSObject vectorLayer){
        return (vectorLayer == null)?null:new Vector(vectorLayer);
    }
    
    //maintain for backwards compatibility
    public Vector(String name, Options options) {
        this(VectorImpl.create(name, options.getJSObject()));
    }
    
    public Vector(String name, VectorParams options) {
        this(VectorImpl.create(name, options.getJSObject()));
    }

    public void addFeatures(VectorFeature[] features){
        JObjectArray a = new JObjectArray(features);
        VectorImpl.addFeatures(getJSObject(), a.getJSObject());
        
        /* Solution without relay (see VectorImpl):
        for(int i = 0, max = features.length; i < max; i++){
            addFeature(features[i]);
        }*/
    }
    
    public void addFeature(VectorFeature f){
        VectorImpl.addFeature(getJSObject(), f.getJSObject());
    }
    
    
    public int getNumberOfFeatures(){
        return VectorImpl.getNumberOfFeatures(getJSObject());
    }
    
    /**
     * @return Array of VectorFeature objects or null if layer does not contain any features
     */
    public VectorFeature[] getFeatures(){
        int nr = getNumberOfFeatures();
        if(nr < 1 ){
            return null;
        } else {
            VectorFeature[] vfs = new VectorFeature[nr];
            for(int i = 0; i < nr; i++){
                VectorFeature vf = VectorFeature.narrowToVectorFeature(
                        VectorImpl.getFeature(getJSObject(), i));
                vfs[i] = vf;
            }
            return vfs;
        }
    };
    
    /**
     * Destroy all features in the vector layer
     */
    public void destroyFeatures(){
        VectorImpl.destroyFeatures(getJSObject());
    }
    
    public VectorFeature getFeatureById(String id){
        return VectorFeature.narrowToVectorFeature(
                VectorImpl.getFeatureById(getJSObject(), id));
    }

    //TODO add method for getting selected features
    public VectorFeature[] getSelectedFeatures(){
        return null;
    }
    

}
