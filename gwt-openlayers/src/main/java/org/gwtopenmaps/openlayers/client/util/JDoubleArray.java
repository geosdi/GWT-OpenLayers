package org.gwtopenmaps.openlayers.client.util;


public class JDoubleArray extends JArrayBase {

	protected JDoubleArray(JSObject array) {
		super(array);
	}

	public static JDoubleArray narrowToJDoubleArray(JSObject array){
		return new JDoubleArray(array);
	}

	public double get(int index){
		return JDoubleArrayImpl.get(getJSObject(), index);
	}

	public static JDoubleArray create(double[] doubles){
		JDoubleArray array = JDoubleArray.narrowToJDoubleArray(JSObject.createJSArray());
		for(int i=0, max = doubles.length; i < max;i++){
			array.push(doubles[i]);
		}
		return array;
	}

	public void push(double d){
		JDoubleArrayImpl.push(getJSObject(), d);
	}

}
