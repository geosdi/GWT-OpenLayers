package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.Style;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Edwin commandeur - Atlis EJS
 * 
 * Convenience class exposing options that are valid for a vector layer.
 * There's also a Vector constructor that can take an Options object directly. 
 * 
 */
public class VectorParams extends LayerOptions {

    public VectorParams(){
    }
    
    public void setIsBaseLayer(boolean b){
        setAttribute("isBaseLayer", b);
    }
    
    public String getIsBaseLayer(){
        return getAttribute("isBaseLayer");
    }

    //limit geometry type to a specific geometry type
    public void setGeometryType(String gtype){
        setAttribute("geometryType", gtype);
    }
    
    public String getGeometryType(){
        return getAttribute("geometryType");
    }
    
    public void setStyle(Style style){
        setAttribute("style", style.getJSObject());
    }
    
    public JSObject getStyle(Style style){
        return getAttributeAsJSObject("style");
    }

}

