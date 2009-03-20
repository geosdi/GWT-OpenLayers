/**
 *
 */
package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.OptionsBase;

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

	/**
	 * To specify if the layer is a BaseLayer. Only one BaseLayer can be active at a time,
	 * and if a BaseLayer is active it cannot be made invisible {link @Layer}.
	 *
	 * If there is more than one BaseLayer then it is possible to choose between BaseLayers in the LayerSwitcher.
	 *
	 * The default value for isBaseLayer depends on the type of layer.
	 * By default isBaseLayer is set to true for WMS layers, ... .
	 */
	public void setIsBaseLayer(boolean isBaseLayer){
		setAttribute("isBaseLayer", isBaseLayer);
	}


}
