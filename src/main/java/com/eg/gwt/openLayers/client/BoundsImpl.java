package com.eg.gwt.openLayers.client;

/**
 * 
 * @author Erdem Gunay
 *
 */
class BoundsImpl {

	public static native JSObject create(double lllon, double lllat, double urlon, double urlat)/*-{
    	return new $wnd.OpenLayers.Bounds(lllon, lllat, urlon, urlat);
    }-*/;
	
}
