package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *         Amr Alam - Refractions Research
 *         Edwin Commandeur - Atlis EJS
 *
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group - @email nazzareno.sileno@geosdi.org
 */
class LayerImpl
{

    public static native JSObject clone(JSObject obj) /*-{
        return obj.clone();
    }-*/;
    
    public static native boolean redraw(JSObject layer, boolean force) /*-{
        return layer.redraw(force);
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

    public static native float getOpacity(JSObject layer) /*-{
        if(layer.opacity){ return layer.opacity }else{ return 1.0 };
    }-*/;

    public static native void setOpacity(float opacity, JSObject layer) /*-{
        layer.setOpacity(opacity);
    }-*/;

    public static native boolean displayInLayerSwitcher(JSObject layer) /*-{
        return layer.displayInLayerSwitcher;
    }-*/;

    public static native void setDisplayInLayerSwitcher(boolean display, JSObject layer) /*-{
        layer.displayInLayerSwitcher = display;
    }-*/;

    public static native String getName(JSObject layer) /*-{
        if(layer.name){ return layer.name }else{ return "" };
    }-*/;

    public static native void setName(String name, JSObject layer) /*-{
        layer.setName(name);
    }-*/;

    public static native boolean isVisible(JSObject layer) /*-{
        return layer.getVisibility();
    }-*/;

    public static native void setIsVisible(boolean isVisible, JSObject layer) /*-{
        layer.setVisibility(isVisible);
    }-*/;

    public static native void setZIndex(JSObject layer, int zIndex) /*-{
        layer.setZIndex(zIndex);
    }-*/;

    public static native Object getZIndex(JSObject layer) /*-{
        return layer.getZIndex();
    }-*/;

    public static native String getUnits(JSObject layer) /*-{
        if(layer.units){ return layer.units }else{ return ""};
    }-*/;

    public static native void addOptions(JSObject layer, JSObject layerOptions) /*-{
        layer.addOptions(layerOptions);
    }-*/;

    public static native void destroy(JSObject layer, boolean setNewBaseLayer) /*-{
        layer.destroy(setNewBaseLayer);
    }-*/;
    
    public static native double getResolutionForZoom(JSObject layer, double zoom) /*-{
        return layer.getResolutionForZoom(zoom);
    }-*/;
    
    public static native JSObject getProjection(JSObject layer) /*-{
       return layer.projection;
    }-*/;
    
    public static native JSObject getOptions(JSObject layer) /*-{
       if( layer.options ) 		
            return layer.options;
       else 
            return {};
    }-*/;
}
