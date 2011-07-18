package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class Handler extends OpenLayersObjectWrapper {

    public final static int MOD_NONE = 0;
    public final static int MOD_SHIFT = 1;
    public final static int MOD_CTRL = 2;
    public final static int MOD_ALT = 4;
    
    public final static String POINT_HANDLER_CLASS_NAME = "OpenLayers.Handler.Point";
	public final static String PATH_HANDLER_CLASS_NAME = "OpenLayers.Handler.Path";
	public final static String POLYGON_HANDLER_CLASS_NAME = "OpenLayers.Handler.Polygon";
	public final static String REGULAR_POLYGON_HANDLER_CLASS_NAME = "OpenLayers.Handler.RegularPolygon";

	protected Handler(JSObject element) {
		super(element);
	}
	
	public static Handler narrowToHandler(JSObject element) {
		return (element == null) ? null : new Handler(element);
	}

}
