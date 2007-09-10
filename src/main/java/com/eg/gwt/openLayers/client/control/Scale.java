package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Scale extends Control {

	protected Scale(JSObject element) {
		super(element);
	}

	public Scale() {
		this(ScaleImpl.create());
	}
}
