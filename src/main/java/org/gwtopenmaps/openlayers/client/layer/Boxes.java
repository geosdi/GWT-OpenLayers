package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class Boxes extends Markers {

	protected Boxes(JSObject element) {
		super(element);
	}

	public Boxes(String name, BoxesMarkersOptions options) {
		this(BoxesImpl.create(name, options.getJSObject()));
	}

	public Boxes(String name) {
		this(BoxesImpl.create(name));
	}

}
