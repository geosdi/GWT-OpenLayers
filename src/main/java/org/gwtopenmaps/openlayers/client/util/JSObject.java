package org.gwtopenmaps.openlayers.client.util;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * <p>
 * A JSObject is an opaque handle to a javascript object. Like it's parent it
 * cannot be created directly,  but has to be created via JSNI or via the
 * static factory method createJSObject.
 *
 * It expands upon it's parent by offering setter and getter methods to set properties
 * on the JSObject. A property can a number, boolean or string, but also another JSObject
 * or a DOM Element. To set a function on a JSObject, it can be created via JSNI,
 * returned as a JSObject and set as property.
 * </p>
 * <p>
 * The purpose of the setter and getter methods is to reduce the amount of JSNI code
 * necessary for working with javascript objects.
 * </p>
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class JSObject extends JavaScriptObject {

	protected JSObject(){
		super();
	}

	public static JSObject createJSObject(){
		return JSObjectHelper.createObject();
	}

	public static JSObject createJSFunction(){
		return JSObjectHelper.createFunction();
	}

	public static JSObject createJSArray(){
		return JSObjectHelper.createArray();
	}

	//TODO: implement setProperty and getProperty methods here

	public final void setProperty(String name, int value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final int getPropertyAsInt(String name){
		return JSObjectHelper.getPropertyAsInt(this, name);
	}

	public final void setProperty(String name, String value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final String getPropertyAsString(String name){
		return JSObjectHelper.getPropertyAsString(this, name);
	}

	public final void setProperty(String name, boolean value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final boolean getPropertyAsBoolean(String name){
		return JSObjectHelper.getPropertyAsBoolean(this, name);
	}

	public final void setProperty(String name, float value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final float getPropertyAsFloat(String name){
		return JSObjectHelper.getPropertyAsFloat(this, name);
	}

	public final void setProperty(String name, double value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final double getPropertyAsDouble(String name){
		return JSObjectHelper.getPropertyAsDouble(this, name);
	}

	public final void setProperty(String name, Element value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final Element getPropertyAsDomElement(String name){
		return JSObjectHelper.getPropertyAsDomElement(this, name);
	}

	public final void setProperty(String name, JSObject value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final JSObject getProperty(String name){
		return JSObjectHelper.getProperty(this, name);
	}

	/**
	 * Let's you inspect the names of properties of a javascript object.
	 *
	 * @return property names - A String with the names of all the properties
	 *   of the object, separated by a comma. For example: prop1,prop2,prop3.
	 */
	public final String getPropertyNames(){
		return JSObjectHelper.getPropertyNames(this);
	}

	public final boolean hasProperty(String name){
		return JSObjectHelper.hasProperty(this, name);
	}

}
