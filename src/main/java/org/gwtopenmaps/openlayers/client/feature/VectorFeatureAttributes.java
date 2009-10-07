package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Class to holds arbitrary properties that describe the feature.
 *
 * @author Rafael Ceravolo - LOGANN
 */
public class VectorFeatureAttributes extends JSObjectWrapper {

	public VectorFeatureAttributes() {
	this(JSObject.createJSObject());
	}

	protected VectorFeatureAttributes(JSObject jsObject) {
		super(jsObject);
	}

	public static VectorFeatureAttributes narrowToVectorFeatureAttributes(JSObject attributes){
		return (attributes == null) ? null : new VectorFeatureAttributes(attributes);
	}

	/**
	 * Sets an value to the arbitrary attribute.
	 *
	 * @param name
	 *            Name of the attribute
	 * @param value
	 *            Value of the attribute
	 */
	public void setAttribute(String name, String value) {
	this.getJSObject().setProperty(name, value);
	}

	/**
	 * Sets an value to the arbitrary attribute.
	 *
	 * @param name
	 *            Name of the attribute
	 * @param value
	 *            Value of the attribute
	 */
	public final void setAttribute(String name, int value) {
	this.getJSObject().setProperty(name, value);
	}

	/**
	 * Sets an value to the arbitrary attribute.
	 *
	 * @param name
	 *            Name of the attribute
	 * @param value
	 *            Value of the attribute
	 */
	public final void setAttribute(String name, boolean value) {
	this.getJSObject().setProperty(name, value);
	}

	/**
	 * Sets an value to the arbitrary attribute.
	 *
	 * @param name
	 *            Name of the attribute
	 * @param value
	 *            Value of the attribute
	 */
	public final void setAttribute(String name, float value) {
	this.getJSObject().setProperty(name, value);
	}

	/**
	 * Sets an value to the arbitrary attribute.
	 *
	 * @param name
	 *            Name of the attribute
	 * @param value
	 *            Value of the attribute
	 */
	public final void setAttribute(String name, double value) {
	this.getJSObject().setProperty(name, value);
	}

}
