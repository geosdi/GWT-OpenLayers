package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

public class HandlerLayerOptions extends JSObjectWrapper {

	protected HandlerLayerOptions(JSObject jsObject) {
		super(jsObject);
	}

	/**
	 *
	 * @param styleMap - {@link org.gwtopenmaps.openlayers.client.StyleMap}
	 */
	public void setStyleMap(StyleMap styleMap){
		getJSObject().setProperty("styleMap", styleMap.getJSObject());
	}



}
