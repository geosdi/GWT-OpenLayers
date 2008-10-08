package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.Style;

/**
 * 
 * @author Edwin commandeur - Atlis EJS
 * Convenience class exposing options that are valid for a vector layer.
 *  
 */
public class VectorParams extends Options {

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
    
    public void vectorStyle(Style style){
        
    }
    
}

