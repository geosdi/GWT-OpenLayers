package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.Options;
import com.google.gwt.user.client.Element;

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

	public PanZoomBar(Element div) {
		super((JSObject)null);
		Options options = new Options();
		options.setAttribute("div", div);
		setJSObject(PanZoomBarImpl.create(options.getJSObject()));
	}


	public PanZoomBar(Options options) {
		this(PanZoomBarImpl.create(options.getJSObject()));
	}
}
