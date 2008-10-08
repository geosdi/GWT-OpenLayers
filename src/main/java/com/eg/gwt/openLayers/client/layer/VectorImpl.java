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
    
    //Add per feature. Reason: putting Features in JObjectArray 
    // and passing Array returned from getJSObject doesn't work.
    // Array turns into Object somewhere and addFeatures does instanceof Array check.
    public static native void addFeature(JSObject self, JSObject feature) /*-{
        self.addFeatures(feature);
    }-*/;

}
