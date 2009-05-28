package com.eg.gwt.openLayers.client.util;

public class JDoubleArrayImpl {

	public static native double get(JSObject array, int index)/*-{
		return array[index];
	}-*/;
}
