package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.feature.Feature;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 */
class VectorImpl {

    public static native JSObject create(String name) /*-{
         return new $wnd.OpenLayers.Layer.Vector(name); 
    }-*/;

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Vector(name, options);
    }-*/;
    
    public static native void addFeature(JSObject self, JSObject feature) /*-{
        self.addFeatures(feature);
    }-*/;
    
    public static native void addFeatures(JSObject self, JSObject features) /*-{
         $wnd.gwt.openlayers.relay.vectorAddFeatures(self, features);
    }-*/;

}
