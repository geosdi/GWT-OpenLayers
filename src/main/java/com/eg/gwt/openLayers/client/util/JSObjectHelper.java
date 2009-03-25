package com.eg.gwt.openLayers.client.util;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class JSObjectHelper {

	public static native JSObject createObject() /*-{
		return new Object();
	}-*/;

	public static native JSObject createFunction() /*-{
		return new Function();
	}-*/;

	public static native JSObject createArray() /*-{
		return new Array();
	}-*/;

	//TODO: implement setProperty getProperty methods
	// and remove setAttribute methods from ElementHelper that actually set properies

	public static native void setProperty(JSObject object, String name, int value) /*-{
		object[name] = value;
	}-*/;

	public static native int getPropertyAsInt(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

}
