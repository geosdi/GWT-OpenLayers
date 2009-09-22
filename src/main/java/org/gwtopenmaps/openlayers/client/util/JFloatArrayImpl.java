package org.gwtopenmaps.openlayers.client.util;


public class JFloatArrayImpl {

	public static native float get(JSObject array, int index)/*-{
		return array[index];
	}-*/;
}
