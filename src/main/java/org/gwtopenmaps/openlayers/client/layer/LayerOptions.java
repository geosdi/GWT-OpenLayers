package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * Find out about OpenLayers: Why doesn't Layer have a setOptions method like Map?
 * Is the addOptions method comparable?
 */
public class LayerOptions extends JSObjectWrapper {

	//TODO: support ... (shared by all layers)
	// -displayOutsideMaxExtent
	// -minResolution
	// -maxResolution
	// -minScale
	// -maxScale
	// -resolutions
	// -scales

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
	 * By default isBaseLayer is true for WMS layers, ... .
	 *
	 * Since OL 2.8 it is possible to specify on the map that only overlays should be
	 * used (will this overrule isBaseLayer property of layer?).
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
	 * @param visible - Visibility of the layer on the map. Default is true.
	 */
	public void setVisibility(boolean visible){
		getJSObject().setProperty("visible", visible);
	}

	public void setNumZoomLevels(int numZoomLevels){
		getJSObject().setProperty("numZoomLevels", numZoomLevels);
	}

	/**
	 *
	 * @param displayOutsideMaxExtent - Set true to request map tiles outside
	 *  the maxExtent of the Layer, default is false.
	 */
	public void setDisplayOutsideMaxExtent(boolean displayOutsideMaxExtent){
		getJSObject().setProperty("displayOutsideMaxExtent", displayOutsideMaxExtent);
	}

	/**
	 *
	 * @param alpha - Set true to enable IE6 alpha hack for transparent PNGs.
	 *  Default is false, because of performance overhead.
	 */
	public void setApplyAlphaHack(boolean applyAlphaHack){
		getJSObject().setProperty("alpha", applyAlphaHack);
	}

	/**
	 *
	 */
	public void setAlwaysInRange(boolean alwaysInRange){
		getJSObject().setProperty("alwaysInRange", alwaysInRange);
	}

	/**
	 *
	 * @param gutter - The width in pixels of the gutter around the image. The gutter
	 *  is ignored.
	 *  <br/>
	 *  From OpenLayers API: "By setting this property to a non-zero value,
	 *  images will be requested that are wider and taller than the tile
	 *  size by a value of 2 x gutter.  This allows artifacts of rendering
	 *  at tile edges to be ignored.  Set a gutter value that is equal to
	 *  half the size of the widest symbol that needs to be displayed.
	 *  Defaults to zero.  Non-tiled layers always have zero gutter."
	 */
	public void setGutter(float gutter){
		getJSObject().setProperty("alwaysInRange", gutter);
	}

	/**
	 *
	 * @param projection - {@link see org.gwtopenmaps.openlayers.client.MapOptions}
	 */
	public void setProjection(String projection){
		getJSObject().setProperty("projection", projection);
	};

	/**
	 *
	 * @param units - {@link see org.gwtopenmaps.openlayers.client.MapOptions}
	 */
	public void setUnits(String units){
		getJSObject().setProperty("units", units);
	}

	/**
	 *
	 * @param maxExtent - {@link see org.gwtopenmaps.openlayers.client.MapOptions#setMaxExtent(Bounds)}
	 */
	public void setMaxExtent(Bounds maxExtent) {
		getJSObject().setProperty("maxExtent", maxExtent.getJSObject());
	}

	/**
	 *
	 * @param minExtent - {@link see org.gwtopenmaps.openlayers.client.MapOptions#setMinExtent(Bounds)}
	 */
	public void setMinExtent(Bounds minExtent) {
		getJSObject().setProperty("minExtent", minExtent.getJSObject());
	}

	/**
	 *
	 * @param maxResolution - {@link see org.gwtopenmaps.openlayers.client.MapOptions#setMaxResolution(float)}
	 */
	public void setMaxResolution(float maxResolution){
		getJSObject().setProperty("maxResolution", maxResolution);
	}

	/**
	 *
	 * @param minResolution - {@link see org.gwtopenmaps.openlayers.client.MapOptions#setMinResolution(float)}
	 */
	public void setMinResolution(float minResolution){
		getJSObject().setProperty("minResolution", minResolution);
	}

	/**
	 *
	 * @param transition - document supported transition effects here
	 */
	public void setTransitionEffect(String transition){
		getJSObject().setProperty("transitionEffect", transition);
	}

	public void setTransitionEffect(TransitionEffect transition){
		switch(transition){
			case RESIZE:
				getJSObject().setProperty("transitionEffect", "resize");
				break;
		}
	}
}
