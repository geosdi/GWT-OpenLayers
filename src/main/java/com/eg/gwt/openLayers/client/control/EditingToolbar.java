package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.layer.Vector;

public class EditingToolbar extends Control{

    protected EditingToolbar(JSObject element){
        super(element);
    }
    
    public EditingToolbar(Vector vectorLayer){
        this(EditingToolbarImpl.create(vectorLayer.getJSObject()));
    }
}
