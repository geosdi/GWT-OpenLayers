package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PolygonHandler extends PointHandler {

	protected PolygonHandler(JSObject element) {
		super(element);
	}

	public PolygonHandler(){
		this(PolygonHandlerImpl.create());
	}

}
