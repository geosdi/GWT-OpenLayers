package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.event.FeatureAddedListener;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class DrawFeatureImpl {

    public static native JSObject create(JSObject layer, JSObject handler)/*-{
        return new $wnd.OpenLayers.Control.DrawFeature(layer, handler);
    }-*/;

    public static native JSObject create(JSObject layer, JSObject handler, JSObject options)/*-{
        return new $wnd.OpenLayers.Control.DrawFeature(layer, handler, options);
    }-*/;

    public static native JSObject create(JSObject layer, JSObject handler, FeatureAddedListener listener)/*-{
        var callback = function(obj){
            listener.@com.eg.gwt.openLayers.client.event.FeatureAddedListener::onFeatureAdded(Lcom/eg/gwt/openLayers/client/JSObject;)(obj);
        }
        return new $wnd.OpenLayers.Control.DrawFeature(layer, handler, {featureAdded:callback});
    }-*/;
    
    
    //TODO test if this works
    public static native JSObject create(JSObject layer, JSObject handler, FeatureAddedListener listener, JSObject options)/*-{
        var callback = function(obj){
            listener.@com.eg.gwt.openLayers.client.event.FeatureAddedListener::onFeatureAdded(Lcom/eg/gwt/openLayers/client/JSObject;)(obj);
        }
        options.featureAdded = callback;
        return new $wnd.OpenLayers.Control.DrawFeature(layer, handler, options);
    }-*/;    

}
