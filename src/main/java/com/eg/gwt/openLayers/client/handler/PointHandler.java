package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PointHandler extends Handler {

	protected PointHandler(JSObject element) {
		super(element);
	}

	public PointHandler(){
		this(PointHandlerImpl.create());
	}
}
