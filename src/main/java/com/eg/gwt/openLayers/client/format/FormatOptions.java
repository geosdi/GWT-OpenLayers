package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.Projection;
import com.eg.gwt.openLayers.client.util.OptionsBase;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatOptions extends OptionsBase {

	/**
	 *
	 * @param projection
	 */
	public void setInternalProjection(Projection projection){
		setAttribute("internalProjection", projection.getJSObject());
	};

	/**
	 *
	 * @param projection
	 */
	public void setExternalProjection(Projection projection){
		setAttribute("externalProjection", projection.getJSObject());
	};

}
