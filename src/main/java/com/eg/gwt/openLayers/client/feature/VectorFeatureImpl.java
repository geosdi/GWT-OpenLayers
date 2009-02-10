/**
 * 
 */
package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class VectorFeatureImpl {

    public native static JSObject create(JSObject geometry)/*-{
        return new $wnd.OpenLayers.Feature.Vector(geometry, null, null);
    }-*/;
    
    public native static JSObject create(JSObject geometry, JSObject style)/*-{
    return new $wnd.OpenLayers.Feature.Vector(geometry, null, style);
    }-*/;
    
    public native static String getGeometryClassName(JSObject self)/*-{
        return self.geometry.CLASS_NAME;
    }-*/;
    
    public native static JSObject getGeometry(JSObject self) /*-{
        return self.geometry;
    }-*/;
    
}
