package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class MousePositionImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.MousePosition();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.MousePosition(options);
	}-*/;

	//TODO: the way typesafety is achieved here for MousePositionOutput.format function
	// can be applied elsewhere
	public static native JSObject formatOutput(MousePositionOutput output)/*-{
		var outputFn = function(lonLat){
			var out = ""
			var lonLatObj = @com.eg.gwt.openLayers.client.LonLat::narrowToLonLat(Lcom/eg/gwt/openLayers/client/util/JSObject;)(lonLat);
			var mapObj = @com.eg.gwt.openLayers.client.Map::narrowToMap(Lcom/eg/gwt/openLayers/client/util/JSObject;)(this.map);

			out = output.@com.eg.gwt.openLayers.client.control.MousePositionOutput::format(Lcom/eg/gwt/openLayers/client/LonLat;Lcom/eg/gwt/openLayers/client/Map;)(lonLatObj,mapObj);

			return $wnd.gwt_openlayers_util.sanitize(out);
		}
		return outputFn;
	}-*/;

}
