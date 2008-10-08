package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 * 
 */
public abstract class Feature extends OpenLayersWidget {

    protected Feature(JSObject element){
        super(element);
    }
    
    public void destroy(){
        FeatureImpl.destroy(getJSObject());
    }
}
