package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class PanZoomBar extends Control {

	protected PanZoomBar(JSObject element) {
		super(element);
	}

	public PanZoomBar() {
		this(PanZoomBarImpl.create());
	}
}
