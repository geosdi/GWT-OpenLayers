package org.gwtopenmaps.openlayers.client.util;

/**
 * For incoming Arrays it is also possible to
 * use JsArrayNumber that is default in GWT.
 *
 */
public class JFloatArray extends JArrayBase {

	protected JFloatArray(JSObject array) {
		super(array);
	}

	public static JFloatArray narrowToJFloatArray(JSObject array){
		return new JFloatArray(array);
	}

	public float get(int index){
		return JFloatArrayImpl.get(getJSObject(), index);
	}

}
