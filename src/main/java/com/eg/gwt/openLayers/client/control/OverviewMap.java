package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.util.JSObject;

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
    
    /** 
     * @param params non-default options: In the OpenLayers example for the overviewmap
     *      mapOptions are copied to overviewmap
     */
    public OverviewMap(Options params) {
        this(OverviewMapImpl.create(params.getJSObject()));
    }
}
