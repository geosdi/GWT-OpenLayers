package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

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
}
