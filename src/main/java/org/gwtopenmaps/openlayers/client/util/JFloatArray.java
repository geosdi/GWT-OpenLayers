package org.gwtopenmaps.openlayers.client.util;


public class JFloatArray extends JArrayBase {

	protected JFloatArray(JSObject array) {
		super(array);
	}

	public static JFloatArray narrowToJDoubleArray(JSObject array){
		return new JFloatArray(array);
	}

	public float get(int index){
		return JFloatArrayImpl.get(getJSObject(), index);
	}

}
