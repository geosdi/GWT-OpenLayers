/**
 * 
 */
package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.OptionsBase;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LayerOptions extends OptionsBase {

    /**
     * Display or hide the name of a Layer in the LayerSwitcher Control.
     * By default a Layer is displayed in the LayerSwitcher Control.
     * 
     * @param display - true to display the layer in the LayerSwitcher control,
     *                  false to hide the layer  
     */
    public void setDisplayInLayerSwitcher(boolean display){
        setAttribute("displayInLayerSwitcher", display);
    }
}
