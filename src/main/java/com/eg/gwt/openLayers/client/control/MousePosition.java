package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class MousePosition extends Control {

	protected MousePosition(JSObject element) {
		super(element);
	}

	public MousePosition() {
		this(MousePositionImpl.create());
	}
	
	public MousePosition(Element div) {
		super((JSObject)null);
		Options options = new Options();
		options.setAttribute("element", div);
		setJSObject(MousePositionImpl.create(options.getJSObject()));
	}

	public MousePosition(Options options) {
		this(MousePositionImpl.create(options.getJSObject()));
	}
	
}
