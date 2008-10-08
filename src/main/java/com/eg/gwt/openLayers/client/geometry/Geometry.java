package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Atlis EJS, Edwin Commandeur
 * 
 */
public abstract class Geometry extends OpenLayersWidget{

    protected Geometry(JSObject element){
        super(element);
    }
    
    public void destroy(){
        GeometryImpl.destroy(getJSObject());
    }
    
    
}
