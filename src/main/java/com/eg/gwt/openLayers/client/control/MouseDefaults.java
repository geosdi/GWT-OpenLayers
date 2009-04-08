package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.Options;

/**
 * 
 * @author Curtis Jensen
 *
 */
public class MouseDefaults extends Control {

	protected MouseDefaults(JSObject element) {
		super(element);
	}

	public MouseDefaults() {
		this(MouseToolbarImpl.create());
	}

	public MouseDefaults(Options options) {
		this(MouseDefaultsImpl.create(options.getJSObject()));
	}

	public MouseDefaults(MouseDefaultsOptions options) {
		this(MouseDefaultsImpl.create(options.getJSObject()));
	}
}
