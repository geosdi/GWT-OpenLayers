package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

import com.google.gwt.user.client.Element;

/**
 *
 * @author Erdem Gunay
 * @author Amr Alam - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 * @author Edwin Commandeur - Atlis Information Systems
 * @author Curtis Jensen - Integrity Applications Inc.
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

	public static native JSObject getCenter(JSObject map)/*-{
		return map.getCenter();
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

	public static native void removeControl(JSObject map, JSObject control)/*-{
		map.removeControl(control);
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

	public static native int getZoom(JSObject map)/*-{
		return map.getZoom();
	}-*/;

	public static native JSObject getLonLatFromPixel(JSObject map, JSObject pixel)/*-{
		return map.getLonLatFromPixel(pixel);
	}-*/;

	public static native JSObject getPixelFromLonLat(JSObject map, JSObject lonlat)/*-{
		return map.getPixelFromLonLat(lonlat);
	}-*/;
	public static native String getProjection(JSObject map)/*-{
		return map.getProjection();
	}-*/;

	public static native String getUnits(JSObject map)/*-{
		return map.getUnits();
	}-*/;

	public static native JSObject getExtent(JSObject map)/*-{
		return map.getExtent();
	}-*/;

	public static native JSObject getMaxExtent(JSObject map)/*-{
		return map.getMaxExtent();
	}-*/;

	public static native double getResolution(JSObject map)/*-{
		return map.getResolution();
	}-*/;

	public static native double getMaxResolution(JSObject map)/*-{
		return map.getMaxResolution();
	}-*/;

	public static native double getScale(JSObject map)/*-{
		return map.getScale();
	}-*/;


	public static native void raiseLayer(JSObject map, JSObject layer, int delta)/*-{
		map.raiseLayer(layer, delta);
	}-*/;

	public static native void zoomTo(JSObject map, int zoomLevel)/*-{
		map.zoomTo(zoomLevel);
	}-*/;

	public static native void zoomToMaxExtent(JSObject map)/*-{
		map.zoomToMaxExtent();
	}-*/;

	public static native void setOptions(JSObject map, JSObject mapOptions)/*-{
		map.setOptions(mapOptions);
	}-*/;

	public static native void panTo(JSObject map, JSObject lonlat)/*-{
		map.panTo(lonlat);
	}-*/;

	public static native JSObject getTileSize(JSObject map)/*-{
		map.getTileSize();
	}-*/;

	public static native JSObject getSize(JSObject map)/*-{
		map.getSize();
	}-*/;

	public static native void destroy(JSObject map)/*-{
		map.destroy();
	}-*/;

	public static native void getZIndexBase(JSObject map)/*-{

	}-*/;

}
