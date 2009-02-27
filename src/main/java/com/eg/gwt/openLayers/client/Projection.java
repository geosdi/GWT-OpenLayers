package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

public class Projection extends OpenLayersWidget {

	protected Projection(JSObject element) {
		super(element);
	}

	public Projection(String projection){
		this (ProjectionImpl.create(projection));
	}


	/**
	 *
	 * @param code -
	 */
	public void setProjectionCode(String code){

	}

}
