package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

public abstract class Params extends JSObjectWrapper {

	protected Params(JSObject jsObject) {
		super(jsObject);
	}

	/**
	 * For setting parameters that are not standard. E.g. parameters that can be added
	 * to a WMS request that are not part of the WMS standard, but that are supported by
	 * a specific product.
	 *
	 * @param name
	 * @param value
	 */
	public void setCustomParameter(String name, String value){
		getJSObject().setProperty(name, value);
	}
}
