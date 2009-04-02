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
	// -alwaysInRange -> setAlwaysInRange ; true/false
	// -gutter
	// -projection
	// -units
	// -minExtent
	// -maxExtent
	// -minResolution
	// -maxResolution
	// -minScale
	// -maxScale
	// -scales => does not seem sensible

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
	 *
	 * IS THIS TRUE?: if a BaseLayer is active it cannot be made invisible {link @Layer}.
	 *
	 * If there is more than one BaseLayer then it is possible to choose between BaseLayers in the LayerSwitcher.
	 *
	 * The default value for isBaseLayer depends on the type of layer.
	 * By default isBaseLayer is set to true for WMS layers, ... .
	 */
	public void setIsBaseLayer(boolean isBaseLayer){
		getJSObject().setProperty("isBaseLayer", isBaseLayer);
	}

	/**
	 * Sets an attribution block on the map. For example:
	 * "This map is provided by <a href="url">company X</a>."
	 *
	 * @param attribution - the attribution text
	 */
	public void setAttribution(String attribution){
		//FIXME sanitize String before setting it!
		// solution - wrap js sanitize function, so it can be used in java and js
		getJSObject().setProperty("attribution", attribution);
	}

	/**
	 * A floating point number between 1.0 and 0.0 that specifies
	 * the opacity of a Layer.
	 *
	 * @param opacity - 1.0 = completely opaque, 0.0 = completely non-opaque
	 */
	public void setLayerOpacity(double opacity){
		getJSObject().setProperty("opacity", opacity);
	}

	/**
	 * see {@Layer}.
	 *
	 * Default is true.
	 */
	public void setVisibility(boolean visible){
		getJSObject().setProperty("visible", visible);
	}

	public void setNumZoomLevels(int numZoomLevels){
		getJSObject().setProperty("numZoomLevels", numZoomLevels);
	}

	/**
	 *
	 * @param displayOutsideMaxExtent - true to request map tiles outside
	 *  the maxExtent of the Layer, defaults to false.
	 */
	public void setDisplayOutsideMaxExtent(boolean displayOutsideMaxExtent){
		getJSObject().setProperty("displayOutsideMaxExtent", displayOutsideMaxExtent);
	}

}
