package com.eg.gwt.openLayers.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

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

	public final void setProperty(String name, Boolean value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final Boolean getPropertyAsBoolean(String name){
		return JSObjectHelper.getPropertyAsBoolean(this, name);
	}

	public final void setProperty(String name, Float value){
		JSObjectHelper.setProperty(this, name, value);
	}

	public final float getPropertyAsFloat(String name){
		return JSObjectHelper.getPropertyAsFloat(this, name);
	}

	public final void setProperty(String name, Double value){
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



}
