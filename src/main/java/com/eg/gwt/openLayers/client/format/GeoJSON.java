package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Brief explanation of GeoJSON vector format here.
 *
 * Reference to GeoJSON specification.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class GeoJSON extends VectorFormat {

	protected GeoJSON(JSObject geoJSONFormat){
		super(geoJSONFormat);
	}

	public GeoJSON(){
		this(GeoJSONImpl.create());
	}

}
