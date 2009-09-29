package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;
/**
 * 
 * @author rhs - Roland.Schweitzer@noaa.gov
 *
 */
public class RegularPolygonHandler extends Handler {
	public RegularPolygonHandler(JSObject element) {
		super(element);
	}
	public RegularPolygonHandler() {
		this(RegularPolygonHandlerImpl.create());
	}
}
