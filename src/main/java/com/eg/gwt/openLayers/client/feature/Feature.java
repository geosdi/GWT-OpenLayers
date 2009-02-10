package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.util.JSObject;

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
    
    public String getFeatureId(){
        return FeatureImpl.getFeatureId(getJSObject());
    }
}
