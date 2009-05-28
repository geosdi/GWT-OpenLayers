package com.eg.gwt.openLayers.client.layer;


/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class GoogleOptions extends LayerOptions {

	public void setType(GMapType type) {
		getJSObject().setProperty("type", type.getJSObject());
	}

	public void setSphericalMercator(boolean value) {
		getJSObject().setProperty("sphericalMercator", value);
	}
}
