package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
public class LayerSwitcher extends Control {

	protected LayerSwitcher(JSObject element) {
		super(element);
	}

	public LayerSwitcher() {
		this(LayerSwitcherImpl.create());
	}

	public LayerSwitcher(LayerSwitcherOptions options) {
		this(LayerSwitcherImpl.create(options.getJSObject()));
	}
}
