package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ScaleLine extends Control {

    protected ScaleLine(JSObject element) {
        super(element);
    }
    
    public ScaleLine(){
        this(ScaleLineImpl.create());
    }

}
