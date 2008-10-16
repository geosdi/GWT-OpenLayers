package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.event.FeatureAddedListener;
import com.eg.gwt.openLayers.client.layer.Vector;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS 
 *
 */
public class DrawFeature extends Control {

    protected DrawFeature(JSObject element) {
        super(element);
    }

    public DrawFeature(Vector layer, JSObject handler) {
        this(DrawFeatureImpl.create(layer.getJSObject(), handler));
    }

    //TODO see if these constructors can be reduced to 1 with DrawFeatureParams object
    
    public DrawFeature(Vector layer, JSObject handler, Options options) {
        this(DrawFeatureImpl.create(layer.getJSObject(), handler, options.getJSObject()));
    }

    public DrawFeature(Vector layer, JSObject handler, FeatureAddedListener listener){
        this(DrawFeatureImpl.create(layer.getJSObject(), handler, listener));
    }

    //TODO test if this works
    public DrawFeature(Vector layer, JSObject handler, FeatureAddedListener listener, Options options){
        this(DrawFeatureImpl.create(layer.getJSObject(), handler, listener, options.getJSObject()));
    }
}
