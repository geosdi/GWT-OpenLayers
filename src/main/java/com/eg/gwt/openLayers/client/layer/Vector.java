package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JObjectArray;
import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.feature.Feature;
import com.eg.gwt.openLayers.client.geometry.Point;

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

    public void addFeatures(Feature[] features){
        for(int i = 0, max = features.length; i < max; i++){
            addFeature(features[i]);
        }
    }
    
    public void addFeature(Feature f){
        VectorImpl.addFeature(getJSObject(), f.getJSObject());
    }
    
	//TODO add methods for getting and selecting features
}
