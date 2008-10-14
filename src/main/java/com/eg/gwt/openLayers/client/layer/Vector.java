package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JObjectArray;
import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.feature.VectorFeature;

public class Vector extends Layer {

    protected Vector(JSObject element) {
        super(element);
    }

    public Vector(String name) {
        this(VectorImpl.create(name));
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
    
	//TODO add methods for getting all and selected features
    
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
                VectorFeature vf = new VectorFeature(VectorImpl.getFeature(getJSObject(), i));
                vfs[i] = vf;
            }
            return vfs;
        }
    };
}
