package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS 
 *
 */
public class ZoomBox extends Control {

    //TODO is this protected method necessary???
    protected ZoomBox(JSObject element) {
        super(element);
    }
    
    public ZoomBox(){
        this(ZoomBoxImpl.create());
    }

}
