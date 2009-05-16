package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

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

	public PanZoomBar(PanZoomBarOptions options){
		this(PanZoomBarImpl.create(options.getJSObject()));
	}

	/*
	public PanZoomBar(Options options) {
		this(PanZoomBarImpl.create(options.getJSObject()));
	}
	*/
}
