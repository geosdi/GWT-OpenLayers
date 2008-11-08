package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.control.Control;
import com.eg.gwt.openLayers.client.layer.Layer;
import com.eg.gwt.openLayers.client.popup.Popup;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 * @author Amr Alam - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 * @author Edwin Commandeur - Atlis Information Systems
 */
public class Map extends OpenLayersWidget {

	public Map(Element e)
	{
		super(MapImpl.create(e));
	}
	
	public Map(Element e, MapOptions options)
	{
		super(MapImpl.create(e, options.getJSObject()));
	}
	
	protected Map(JSObject e)
	{
		super(e);
	}
	
	public static Map narrowToMap(JSObject element)
	{
		return (element == null)? null: new Map(element);
	}

	/**
	 * Returns current center of map object.
	 * @return current center
	 */
	public String getCenter(){
		return MapImpl.getCenter(getJSObject());
	}
	
	public void setCenter(LonLat lonlat) {
		MapImpl.setCenter(getJSObject(), lonlat.getJSObject());
	}
	
	public void setCenter(LonLat lonlat, int zoom) {
		MapImpl.setCenter(getJSObject(), lonlat.getJSObject(), zoom);
	}
	
	public void addControl(Control control) {
		MapImpl.addControl(getJSObject(), control.getJSObject());
	}
	
	public void addLayer(Layer layer) {
		MapImpl.addLayer(getJSObject(), layer.getJSObject());
	}

	public void addLayers(Layer[] layers) {
		JSObject[] jsObjects = new JSObject[layers.length];
		for (int i = 0; i < layers.length; i++)
      {
         jsObjects[i] = layers[i].getJSObject();
      }
		
		JObjectArray array = new JObjectArray(jsObjects);
		MapImpl.addLayers(getJSObject(), array.getJSObject());
	}
	
	public void addPopup(Popup popup) {
		MapImpl.addPopup(getJSObject(), popup.getJSObject());
	}

	public void removePopup(Popup popup) {
		MapImpl.removePopup(getJSObject(), popup.getJSObject());
	}
	
	public Integer getNumLayers() {
	    	return MapImpl.getNumLayers(getJSObject());
	}
	
	public Layer getLayer(String id) {
	    JSObject jsObject = MapImpl.getLayer(id, getJSObject());
	    Layer layer = new Layer(jsObject);
	    return layer;
	}
	
	public Layer[] getLayers() {
	    	JSObject jsObjects = MapImpl.getLayers(getJSObject());
	    	JObjectArray jObjectArray = new JObjectArray(jsObjects);
	    	Layer[] layers = new Layer[jObjectArray.length()];
	    	for(int i = 0; i < jObjectArray.length(); i++) {
	    	    layers[i] = new Layer(jObjectArray.get(i));
	    	}
	    	return layers;
	}

	public void removeLayer(Layer layer) {
	    	MapImpl.removeLayer(getJSObject(), layer.getJSObject());
	}

	public int getLayerIndex(Layer layer) {
		return MapImpl.getLayerIndex(getJSObject(), layer.getJSObject());
	}

	public void setLayerIndex(Layer layer, int index) {
		MapImpl.setLayerIndex(getJSObject(), layer.getJSObject(), index);
	}
	
	/**
	 * This is not an openLayers native function. Will remove all overlays
	 * from the this Map.
	 */
	public void removeOverlayLayers() {
	    	Layer[] layers = getLayers();
	    	for (int i = 0; i < layers.length; i++ ) {
	    	    if(layers[i].isBaseLayer() == false ) {
	    		removeLayer(layers[i]);
	    	    }
	    	}
	}
	
	public void zoomToExtent(Bounds bounds) {
	   MapImpl.zoomToExtent(getJSObject(), bounds.getJSObject());
	}
	
	public int getZoomForExtent(Bounds bounds, boolean closest) {
			return MapImpl.getZoomForExtent(getJSObject(), bounds.getJSObject(), closest);
	}

	/**
	 * Returns current zoom level of map object.
	 * @return current zoom level
	 */
	public String getZoom(){
		return MapImpl.getZoom(getJSObject());
	}

	public LonLat getLonLatFromPixel(Pixel pixel) {
		return new LonLat( MapImpl.getLonLatFromPixel(getJSObject(), pixel.getJSObject()) );
	}
	
	public String getProjection() {
	    return MapImpl.getProjection(getJSObject());
	}
	
	public void destroy(){
	    MapImpl.destroy(getJSObject());
	}
	
	/**
	 * Returns the Layer as a JSObject that has to be narrowed down
	 * to the appropriate type of Layer.
	 * 
	 * TO DO replace by method that returns Layer
	 * If you can query the type of the layer, then you cast it.
	 * 
	 * @param name - the name of the Layer
	 * @return the
	 */
/*	public JSObject getLayerByName(String name){
	    return MapImpl.getLayerByName(getJSObject(), name);
	}*/
	
	public Layer getLayerByName(String name){
	    Layer layer = new Layer(MapImpl.getLayerByName(getJSObject(), name));
	    return layer;
	}
	
	public void removeLayerByName(String name){
	    //TODO implement
	}	
}
