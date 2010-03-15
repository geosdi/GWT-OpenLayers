package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class MultiPolygonImpl {
	
    public static native JSObject create(JSObject polygons)/*-{
    	return new $wnd.gwt_openlayers_util.relay.createMultiPolygon(polygons);	
	}-*/;

}
