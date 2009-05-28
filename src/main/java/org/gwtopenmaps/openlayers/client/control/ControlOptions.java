package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Options specific to Control widgets.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ControlOptions extends JSObjectWrapper {

	protected ControlOptions(JSObject jsObject) {
		super(jsObject);
	}

	public ControlOptions(){
		this(JSObject.createJSObject());
	}

}
