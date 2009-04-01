package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.Projection;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatOptions extends JSObjectWrapper {

	protected FormatOptions(JSObject jsObject) {
		super(jsObject);
	}

	public FormatOptions(){
		this(JSObject.createJSObject());
	}

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
