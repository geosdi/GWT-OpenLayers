package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PathHandler extends PointHandler {

	protected PathHandler(JSObject element) {
		super(element);
	}

	public PathHandler(){
		this(PathHandlerImpl.create());
	}
}
