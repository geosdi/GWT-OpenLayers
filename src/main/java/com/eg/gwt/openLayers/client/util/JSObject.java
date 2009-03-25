package com.eg.gwt.openLayers.client.util;

import com.google.gwt.core.client.JavaScriptObject;

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
}
