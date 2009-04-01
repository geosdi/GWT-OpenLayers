package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;

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
