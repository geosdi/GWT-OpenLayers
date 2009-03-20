package com.eg.gwt.openLayers.client.util;

import com.eg.gwt.openLayers.client.OpenLayersObjectWrapper;
import com.google.gwt.user.client.Element;

public class ElementHelper
{
	public static native JSObject getAttributes(JSObject elem) /*-{
    	var ret = elem.attributes;
    	return (ret === undefined) ? null : ret;
	}-*/;
	
	public static native String getAttributeName(JSObject elem) /*-{
		var ret = elem.name;
		return (ret === undefined) ? null : ret;
	}-*/;
	
	public static native JSObject getElementFromArray(JSObject elem, int i) /*-{
		if (elem.length > i) return null;
		
		var ret = elem[i];
		return (ret === undefined) ? null : ret;
	}-*/;
	
	public static native String getAttribute(JSObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : String(ret);
	}-*/;
	
	public static native void setAttribute(JSObject elem, String attr, String value) /*-{
	    elem[attr] = value;
	}-*/;
	
	public static native JSObject getAttributeAsJSObject(JSObject elem, String attr) /*-{
    var ret = elem[attr];
    return (ret === undefined) ? null : ret;
    }-*/;
	
	public static native Element getAttributeAsElement(JSObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : ret;
    }-*/;
	
	public static native void setAttribute(JSObject elem, String attr, Element value) /*-{
		elem[attr] = value;
	}-*/;
	
	public static native void setAttribute(JSObject elem, String attr, JSObject value) /*-{
    	elem[attr] = value;
    }-*/;

	public static native void setAttribute(JSObject elem, String attr, JSObject[] value) /*-{
		elem[attr] = value;
	}-*/;
	
	public static native void setAttribute(JSObject elem, String attr, double value) /*-{
	   elem[attr] = value;
   }-*/;
	
	public static native void setAttribute(JSObject elem, String attr, int value) /*-{
    	elem[attr] = value;
    }-*/;
	
	public static native void setAttribute(JSObject elem, String attr, boolean value) /*-{
		elem[attr] = value;
	}-*/;

	public static native int getAttributeAsInt(JSObject elem, String attr) /*-{
    	var ret = elem[attr];
    	return (ret === undefined) ? 0 : ret;
    }-*/;

	public static native double getAttributeAsDouble(JSObject elem, String attr) /*-{
		var ret = elem[attr];
		return (ret === undefined) ? 0 : ret;
	}-*/;
	
	public static int[] getAttributeAsIntArray(JSObject elem, String attr)
	{
		int[] rtn = null;
		JSObject hold = getAttributeAsJSObject(elem, attr);
		if (hold != null)
		{
			rtn = new int[getArraySize(hold)];
			
			for(int i = 0; i < rtn.length; i++)
			{
				rtn[i] = getIntValueFromArray(hold, i);
			}
		}
		
		return rtn;
	}
	
	public static native int getArraySize(JSObject elem) /*-{
		if (elem) return elem.length;
		return 0;
	}-*/;
	
	public static native int getIntValueFromArray(JSObject elem, int i) /*-{
		return elem[i];
	}-*/;
	
	public static native void setAttributeAsIntArray(JSObject elem, String attr, int[] value) /*-{
    	elem[attr] = value;
    }-*/;
	
	public static native boolean getAttributeAsBoolean(JSObject elem, String attr) /*-{
    	var ret = elem[attr];
    	return (ret === undefined) ? null : ret;
    }-*/;
	
	public static JSObject arrayConvert(OpenLayersObjectWrapper[] array) 
	{ 
	        JSObject result = newJSArray(array.length); 
	        for (int i = 0; i < array.length; i++) 
	        { 
	                arraySet(result, i, array[i].getJSObject()); 
	        } 
	        return result; 
	}
		
	private static native JSObject newJSArray(int length) /*-{ 
	    if (length < 0) 
	    { 
	            return new Array(); 
	    } 
	    else 
	    { 
	            return new Array(length); 
	    } 
	}-*/;

	public static native int arrayLength(JSObject array) /*-{ 
	        return array.length;
	}-*/; 


	public static native Object arrayGetObject(JSObject array, int index) /*-{ 
	        return array[index]; 
	}-*/; 

	public static native JSObject arrayGetElement(JSObject array, int index) /*-{ 
    	return array[index]; 
	}-*/; 
	
	public static native void arraySet(JSObject array, int index, Object value) /*-{ 
    	array[index] = value; 
    
	}-*/; 

	public static native void arraySet(JSObject array, int index, JSObject value) /*-{ 
	        array[index] = value; 

	}-*/; 
	
    public static native Element getHead() /*-{
		return $wnd.top.document.getElementsByTagName("head")[0];
	}-*/;
	
	public static native Element getTopDocument() /*-{
		return $wnd.top.document;
	}-*/;
	
	public static native JSObject getElementsByTagName(Element parent, String tagName) /*-{
		return parent.getElementsByTagName(tagName);
	}-*/;
}
