package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * Brief explanation of WKT vector format here.
 *
 * Reference to WKT specification.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class WKT extends VectorFormat {

	protected WKT(JSObject wktFormat){
		super(wktFormat);
	}

	public WKT(){
		this(WKTImpl.create());
	}

	public void read(WKT wkt){
		//todo implement
	}
}
