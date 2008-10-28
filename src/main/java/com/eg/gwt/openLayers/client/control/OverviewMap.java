package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMap extends Control {

    protected OverviewMap(JSObject element) {
        super(element);
    }

    public OverviewMap() {
        this(OverviewMapImpl.create());
    }
    
    public OverviewMap(Options params) {
        this(OverviewMapImpl.create(params.getJSObject()));
    }
}
