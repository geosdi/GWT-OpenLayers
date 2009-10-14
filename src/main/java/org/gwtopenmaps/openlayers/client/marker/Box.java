package org.gwtopenmaps.openlayers.client.marker;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Marker;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class Box extends Marker {

	protected Box(JSObject element) {
		super(element);
	}

	public Box(Bounds bounds, String borderColor, int borderWidth) {
		this(BoxImpl.create(bounds.getJSObject(), borderColor, borderWidth));
	}

	public Box(Bounds bounds) {
		this(BoxImpl.create(bounds.getJSObject(), "red", 2));
	}
	public void setBorder(String borderColor, int borderWidth) {
		BoxImpl.setBorder(getJSObject(), borderColor, borderWidth);
	}

}
