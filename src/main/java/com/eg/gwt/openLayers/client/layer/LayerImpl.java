package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *         Amr Alam - Refractions Research
 *         Edwin Commandeur - Atlis EJS
 *
 */
class LayerImpl {
    public static native void redraw(JSObject layer, boolean force) /*-{
        layer.redraw(force);
    }-*/;

    public static native void setIsBaseLayer(boolean isBaseLayer, JSObject layer) /*-{
        layer.setIsBaseLayer(isBaseLayer);
    }-*/;

    public static native boolean isBaseLayer(JSObject layer) /*-{
        return layer.isBaseLayer;
    }-*/;

    public static native String getId(JSObject layer) /*-{
        return layer.id;
    }-*/;

    public static native float getOpacity(JSObject layer)/*-{
        if(layer.opacity){ return layer.opacity }else{ return 1.0 };
    }-*/;

    public static native void setOpacity(float opacity, JSObject layer) /*-{
        layer.setOpacity(opacity);
    }-*/;

    public static native boolean displayInLayerSwitcher(JSObject layer) /*-{
       return layer.displayInLayerSwitcher;
    }-*/;

    public static native void setDisplayInLayerSwitcher(boolean display, JSObject layer)/*-{
       layer.displayInLayerSwitcher = display;
    }-*/;

    public static native String getName(JSObject layer)/*-{
        if(layer.name){ return layer.name }else{ return "" };
    }-*/;

    public static native void setName(String name, JSObject layer)/*-{
        layer.setName(name);
    }-*/;

    public static native boolean isVisible(JSObject layer)/*-{
        return layer.getVisibility();
    }-*/;
    public static native void setIsVisible(boolean isVisible, JSObject layer)/*-{
        layer.setVisibility(isVisible);
    }-*/;

    public static native String getUnits(JSObject layer)/*-{
        if(layer.units){ return layer.units }else{ return ""};
    }-*/;



}
