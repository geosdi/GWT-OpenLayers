package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ZoomBox extends Control {

    protected ZoomBox(JSObject element) {
        super(element);
    }
    
    public ZoomBox(){
        this(ZoomBoxImpl.create());
    }

}
