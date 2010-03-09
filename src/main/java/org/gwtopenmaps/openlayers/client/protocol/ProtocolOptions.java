package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * ProtocolOptions base class
 * 
 * @author davek<at>komacke<dot>com
 */
public class ProtocolOptions extends JSObjectWrapper {

	protected ProtocolOptions(JSObject jsObject) {
		super(jsObject);
	}

	public ProtocolOptions(){
		this(JSObject.createJSObject());
	}

}

