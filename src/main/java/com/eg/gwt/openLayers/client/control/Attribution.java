package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Must be activated on the map to show attributions that can be
 * set on layers. An example of an attribution is:
 *"This map is provided by <a href="url">company X</a>."
 *
 * Where the attribution must be specified depends on the layer.
 * For example, for WMS layers the attribution can be set as WMS layer
 * paramer, see {@link com.eg.gwt.openLayers.client.layer.WMSOptions}.
 *
 * This control is added to OpenLayers maps by default.
 *
 * Other controls that are added by default are the {@link PanZoom},
 * Navigation, and ArgParser.
 *
 * @author Edwin Commandeur
 * @since GWT-OL 0.4, OL ...
 */
public class Attribution extends Control {

	protected Attribution(JSObject element) {
		super(element);
	}

	public Attribution() {
		this(AttributionImpl.create());
	}

	public Attribution(AttributionOptions options){
		this(AttributionImpl.create(options.getJSObject()));
	}
}
