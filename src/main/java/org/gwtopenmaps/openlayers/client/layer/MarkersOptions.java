package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class MarkersOptions extends JSObjectWrapper {

	protected MarkersOptions(JSObject jsObject) {
		super(jsObject);
	}

	public MarkersOptions(){
		this(JSObject.createJSObject());
	}

	// What kind of options has Markers?
}
