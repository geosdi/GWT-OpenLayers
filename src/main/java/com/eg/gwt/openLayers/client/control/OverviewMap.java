package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMap extends Control {

	protected OverviewMap(JSObject element) {
		super(element);
	}

	public OverviewMap() {
		this(OverviewMapImpl.create());
	}

	public OverviewMap(OverviewMapOptions options) {
		this(OverviewMapImpl.create(options.getJSObject()));
	}

	//
	// legacy
	//

	/*
	public OverviewMap(Options params) {
		this(OverviewMapImpl.create(params.getJSObject()));
	}
	*/
}
