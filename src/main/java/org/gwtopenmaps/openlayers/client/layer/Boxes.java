package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.marker.Box;
import org.gwtopenmaps.openlayers.client.util.JSObject;
/**
* @author Michel Vitor A Rodrigues
*/
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
	public void drawMarker(Box marker){
		BoxesImpl.drawMarker(getJSObject(), marker);	
	}
	public void removeMarker(Box marker){
		BoxesImpl.removeMarker(getJSObject(), marker);	
	}

}
