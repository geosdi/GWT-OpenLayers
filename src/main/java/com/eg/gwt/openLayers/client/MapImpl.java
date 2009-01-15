package com.eg.gwt.openLayers.client;

import com.google.gwt.user.client.Element;

/**
 *
 * @author Erdem Gunay
 * @author Amr Alam - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 * @author Edwin Commandeur - Atlis Information Systems
 */
class MapImpl {

	public static native JSObject create(Element div)/*-{
		return new $wnd.OpenLayers.Map(div);
	}-*/;

	public static native JSObject create(Element div, JSObject options)/*-{
		return new $wnd.OpenLayers.Map(div, options);
	}-*/;

	public static native void setCenter(JSObject map, JSObject lonlat)/*-{
		map.setCenter(lonlat);
	}-*/;

	public static native void setCenter(JSObject map, JSObject lonlat, int zoom)/*-{
		map.setCenter(lonlat, zoom);
	}-*/;

	public static native String getCenter(JSObject map)/*-{
		return map.getCenter().toShortString();
	}-*/;

	public static native void addControl(JSObject map, JSObject control)/*-{
		map.addControl(control);
	}-*/;

	public static native void addLayer(JSObject map, JSObject layer)/*-{
		map.addLayer(layer);
	}-*/;

	public static native void addLayers(JSObject map, JSObject layers)/*-{
		map.addLayers(layers);
	}-*/;

	public static native void addPopup(JSObject map, JSObject popup)/*-{
		map.addPopup(popup);
	}-*/;

	public static native void removePopup(JSObject map, JSObject popup)/*-{
		map.removePopup(popup);
	}-*/;

	public static native int getNumLayers(JSObject map)/*-{
		return map.getNumLayers();
	}-*/;

	public static native JSObject getLayer(String id, JSObject map)/*-{
		var layer = map.getLayer(id);
		return (layer === undefined) ? null : layer;
	}-*/;

	public static native JSObject getLayers(JSObject map)/*-{
		return (map.layers === undefined) ? null : map.layers;
	}-*/;

	public static native void removeLayer(JSObject map, JSObject layer)/*-{
		map.removeLayer(layer);
	}-*/;

	public static native int getLayerIndex(JSObject map, JSObject layer)/*-{
		return map.getLayerIndex(layer);
	}-*/;

	public static native void setLayerIndex(JSObject map, JSObject layer, int index)/*-{
		map.setLayerIndex(layer, index);
	}-*/;

	public static native void zoomToExtent(JSObject map, JSObject bounds)/*-{
		map.zoomToExtent(bounds);
	}-*/;

	public static native int getZoomForExtent(JSObject map, JSObject bounds, boolean closest)/*-{
		return map.getZoomForExtent(bounds, closest);
	}-*/;

	public static native String getZoom(JSObject map)/*-{
		return map.getZoom()+'';
	}-*/;

	public static native JSObject getLonLatFromPixel(JSObject map, JSObject pixel)/*-{
		return map.getLonLatFromPixel(pixel);
	}-*/;

	public static native String getProjection(JSObject map)/*-{
		return map.getProjection();
	}-*/;

	public static native void destroy(JSObject map)/*-{
		map.destroy();
	}-*/;


}
