package com.eg.gwt.openLayers.client.util;

/**
 * Base class for Objects that wrap an opaque JavaScriptObject, to provide
 * (part of) the JavaScriptObject's functionality in GWT.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class JSObjectWrapper {

	private JSObject jsObject;

	protected JSObjectWrapper(JSObject jsObject)
	{
		setJSObject(jsObject);
	}

	public JSObject getJSObject() {
		return jsObject;
	}

	public void setJSObject(JSObject jsObject) {
		this.jsObject = jsObject;
	}

}
