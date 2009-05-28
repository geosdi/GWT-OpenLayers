package org.gwtopenmaps.openlayers.client.util;


import com.google.gwt.user.client.Element;


/**
 * Static methods for working with {@link JSObject} objects.
 *
 * These are convenience methods for reducing the amount of JSNI code for
 * creating JSObject wrappers.
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

	public static native void setProperty(JSObject object, String name, String value) /*-{
		object[name] = value;
	}-*/;

	public static native String getPropertyAsString(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

	public static native void setProperty(JSObject object, String name, boolean value) /*-{
		object[name] = value;
	}-*/;

	public static native boolean getPropertyAsBoolean(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

	public static native void setProperty(JSObject object, String name, float value) /*-{
		object[name] = value;
	}-*/;

	public static native float getPropertyAsFloat(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

	public static native void setProperty(JSObject object, String name, double value) /*-{
		object[name] = value;
	}-*/;

	public static native double getPropertyAsDouble(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

	public static native void setProperty(JSObject object, String name, JSObject value) /*-{
		object[name] = value;
	}-*/;

	public static native JSObject getProperty(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

	public static native void setProperty(JSObject object, String name, Element value) /*-{
		object[name] = value;
	}-*/;

	public static native Element getPropertyAsDomElement(JSObject object, String name) /*-{
		var ret = object[name];
		return (ret === undefined) ? 0 : ret;
	}-*/;

	public static native String getPropertyNames(JSObject object) /*-{
		var ret = "";
		for (var i in object){
			if(ret == ""){
				ret = ret + i
			} else {
				ret = ret + "," + i;
			}
		}
		return ret;
	}-*/;

	public static native boolean hasProperty(JSObject object, String name) /*-{
		if(object[name] != undefined){return true}else{return false};
	}-*/;

}
