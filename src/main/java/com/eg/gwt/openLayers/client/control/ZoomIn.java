/**
 * 
 */
package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 * requires OpenLayers 2.7 or higher
 */
public class ZoomIn extends Control{

    protected ZoomIn(JSObject zoomIn){
        super(zoomIn);
    }
    
    public ZoomIn(){
        this(ZoomInImpl.create());
    }
    
}
