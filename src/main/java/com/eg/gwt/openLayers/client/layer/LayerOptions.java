/**
 *
 */
package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LayerOptions extends JSObjectWrapper {

	//TODO: support ... (shared by all layers)
	// -alpha -> setHasAlphaChannel ; false by default/true if image
	// -alwaysInRange -> setAlwaysInRange ; ...
	// -visible -> setVisibility

	//supported isBaseLayer, displayInLayerSwitcher

	protected LayerOptions(JSObject jsObject) {
		super(jsObject);
	}

	public LayerOptions(){
		this(JSObject.createJSObject());
	}

	/**
	 * Display or hide the name of a Layer in the LayerSwitcher Control.
	 * By default a Layer is displayed in the LayerSwitcher Control.
	 *
	 * @param display - true to display the layer in the LayerSwitcher control,
	 *                  false to hide the layer
	 */
	public void setDisplayInLayerSwitcher(boolean display){
		getJSObject().setProperty("displayInLayerSwitcher", display);
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
		getJSObject().setProperty("isBaseLayer", isBaseLayer);
	}


}
