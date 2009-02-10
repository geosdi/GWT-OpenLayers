package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.google.gwt.user.client.Element;

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

	public Scale(Element div) {
		this(ScaleImpl.create(div));
	}
}
