package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.Options;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class GoogleOptions extends Options {

	public void setType(GMapType type) {
		getJSObject().setProperty("type", type.getJSObject());
	}

	public void setSphericalMercator(boolean value) {
		getJSObject().setProperty("sphericalMercator", value);
	}
}
