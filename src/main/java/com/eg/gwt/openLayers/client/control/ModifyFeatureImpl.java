package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ModifyFeatureImpl {

    public static native JSObject create(JSObject vectorLayer)/*-{
        return new $wnd.OpenLayers.Control.ModifyFeature(vectorLayer);
    }-*/;    
}
