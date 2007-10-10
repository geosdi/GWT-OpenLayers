package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.control.Control;
import com.eg.gwt.openLayers.client.layer.Layer;
import com.eg.gwt.openLayers.client.popup.Popup;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *  	   Amr Alam - Refractions Research
 *
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
			jsObjects[i] = layers[i].getJSObject();
		
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
	
	/**
	 * This is not an openLayers native function. Will remove all overlays
	 * from the this Map.
	 */
	public void removeOverlayLayers() {
	    	Layer[] layers = getLayers();
	    	for (int i = 0; i < layers.length; i++ ) {
	    	    if( ((Layer)layers[i]).isBaseLayer() == false ) {
	    		removeLayer(layers[i]);
	    	    }
	    	}
	}
}
