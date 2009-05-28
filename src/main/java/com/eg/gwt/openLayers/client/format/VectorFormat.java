package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.util.JObjectArray;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Format objects provide support for reading and writing formats for
 * representing ...
 *
 * There are different standard formats for representing vector features.
 * For example, WKT GML, and KML.
 *
 * A format object can read and write vector features in a specific format
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class VectorFormat extends Format {

	protected VectorFormat(JSObject element) {
		super(element);
	}

	/**
	 * Write an array of {@link com.eg.gwt.openLayers.client.feature.VectorFeature} objects
	 * in a particular format that depends on the specific format object.
	 *
	 * For example, a WKT format object writes the features in Well Known Text format:
	 * <code>
	 *   WKT wktFormat = new WKT();
	 *   String wkt = wktFormat.write(vectorFeatures);
	 * </code>
	 *
	 * @param vectorFeatures - an array of vector features
	 * @return a String containing the vector features written in a particular format.
	 */
	public String write(VectorFeature[] vectorFeatures){
		JObjectArray objectArray = new JObjectArray(vectorFeatures);
		return FormatImpl.writeArray(getJSObject(), objectArray.getJSObject());
	};

	/**
	 * Write a {@link com.eg.gwt.openLayers.client.feature.VectorFeature} in a
	 * particular format that depends on the specific format object.
	 *
	 * For example, a WKT format object writes the features in Well Known Text format:
	 * <code>
	 *   WKT wktFormat = new WKT();
	 *   String wkt = wktFormat.write(vectorFeatures);
	 * </code>
	 *
	 * @param vectorFeature - a vector feature
	 * @return a String containing the vector feature written in a particular format.
	 */
	public String write(VectorFeature vectorFeature){
		return FormatImpl.write(getJSObject(), vectorFeature.getJSObject());
	};

	/**
	 * TODO: implement
	 *
	 * @param input - the vector features in a particular vector format
	 * @return null
	 */
	public VectorFeature[] read(String input){
		//VectorFeature.narrowToVectorFeature(FormatImpl.read(getJSObject(), input)) ;
		return null;
	}

}
