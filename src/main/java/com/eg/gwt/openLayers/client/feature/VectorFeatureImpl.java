/**
 * 
 */
package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class VectorFeatureImpl {

    public native static JSObject create(JSObject geometry)/*-{
        return new $wnd.OpenLayers.Feature.Vector(geometry, null, null);
    }-*/;
}
