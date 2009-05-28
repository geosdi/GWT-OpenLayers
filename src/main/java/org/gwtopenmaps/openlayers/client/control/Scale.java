package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

import com.google.gwt.user.client.Element;

/**
 *
 * @author Erdem Gunay
 *
 */
public class Scale extends Control {

	protected Scale(JSObject element) {
		super(element);
	}

	public Scale() {
		this(ScaleImpl.create());
	}

	/*
	 * TODO: make options only constructor, see if element can be null
	public Scale(ScaleOptions options) {
		this(ScaleImpl.create(options.getJSObject()));
	}
	*/

	public Scale(Element div) {
		this(ScaleImpl.create(div));
	}
}
