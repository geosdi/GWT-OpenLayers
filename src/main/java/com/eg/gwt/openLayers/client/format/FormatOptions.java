package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.Projection;
import com.eg.gwt.openLayers.client.util.Options;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatOptions extends Options {

	/**
	 *
	 * @param projection
	 */
	public void setInternalProjection(Projection projection){
		getJSObject().setProperty("internalProjection", projection.getJSObject());
	};

	/**
	 *
	 * @param projection
	 */
	public void setExternalProjection(Projection projection){
		getJSObject().setProperty("externalProjection", projection.getJSObject());
	};

}
