package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Erdem Gunay
 *         Amr Alam - Refractions Research
 *         Edwin Commandeur - Atlis EJS
 *
 */
public class Layer extends OpenLayersWidget {

    public Layer(JSObject element) {
        super(element);
    }

    public static Layer narrowToLayer(JSObject layer){
        return new Layer(layer);
    }
    
    public void redraw() {
        LayerImpl.redraw(getJSObject());
    }

    public void setIsBaseLayer(boolean isBaseLayer) {
        LayerImpl.setIsBaseLayer(isBaseLayer, getJSObject());
    }

    /**
     * Indicates if Layer is a BaseLayer.
     * 
     * @return true if the layer is a BaseLayer
     *         false if the layer is not a BaseLayer
     */
    public boolean isBaseLayer() {
        return LayerImpl.isBaseLayer(getJSObject());
    }
    
    public String getId() {
        return LayerImpl.getId(getJSObject());
    }

    public float getOpacity(){ 
        return LayerImpl.getOpacity(getJSObject());
    }

    public void setOpacity(float opacity){ 
        LayerImpl.setOpacity(opacity, getJSObject());
    }

    /**
     * Indicates if the Layer should be displayed in the LayerSwitcher Control.
     * 
     * @return true if the layer should be displayed in the LayerSwitcher Control, 
     *         false if the layer should be hidden
     */
    public boolean displayInLayerSwitcher(){
        return LayerImpl.displayInLayerSwitcher(getJSObject());
    }
    
    public void setDisplayInLayerSwitcher(boolean display){
        LayerImpl.setDisplayInLayerSwitcher(display, getJSObject());
    }
    
    /**
     * @return The name of the Layer, or an empty string if no name was found.
     */
    public String getName(){
        return LayerImpl.getName(getJSObject());
    }
    
    public boolean isVisible(){
        return LayerImpl.isVisible(getJSObject());
    }
    
    public void setIsVisible(boolean isVisible){
        LayerImpl.setIsVisible(isVisible, getJSObject());
    }
    
}
