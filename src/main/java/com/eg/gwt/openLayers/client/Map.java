package com.eg.gwt.openLayers.client;

import java.util.ArrayList;
import java.util.List;

import com.eg.gwt.openLayers.client.control.Control;
import com.eg.gwt.openLayers.client.event.EventHandler;
import com.eg.gwt.openLayers.client.event.EventListener;
import com.eg.gwt.openLayers.client.event.EventListenerCollection;
import com.eg.gwt.openLayers.client.event.EventType;
import com.eg.gwt.openLayers.client.event.MapBaseLayerChangedListener;
import com.eg.gwt.openLayers.client.event.MapClickListener;
import com.eg.gwt.openLayers.client.event.MapClickListener.MapClickEvent;
import com.eg.gwt.openLayers.client.event.MapLayerAddedListener;
import com.eg.gwt.openLayers.client.event.MapLayerChangedListener;
import com.eg.gwt.openLayers.client.event.MapLayerRemovedListener;
import com.eg.gwt.openLayers.client.event.MapMarkerAddedListener;
import com.eg.gwt.openLayers.client.event.MapMarkerRemovedListener;
import com.eg.gwt.openLayers.client.event.MapMoveListener;
import com.eg.gwt.openLayers.client.event.MapPopupClosedListener;
import com.eg.gwt.openLayers.client.event.MapPopupOpenedListener;
import com.eg.gwt.openLayers.client.event.MapBaseLayerChangedListener.MapBaseLayerChangedEvent;
import com.eg.gwt.openLayers.client.event.MapLayerAddedListener.MapLayerAddedEvent;
import com.eg.gwt.openLayers.client.event.MapLayerChangedListener.MapLayerChangedEvent;
import com.eg.gwt.openLayers.client.event.MapLayerRemovedListener.MapLayerRemovedEvent;
import com.eg.gwt.openLayers.client.event.MapMarkerAddedListener.MapMarkerAddedEvent;
import com.eg.gwt.openLayers.client.event.MapMarkerRemovedListener.MapMarkerRemovedEvent;
import com.eg.gwt.openLayers.client.event.MapMoveListener.MapMoveEvent;
import com.eg.gwt.openLayers.client.event.MapPopupClosedListener.MapPopupClosedEvent;
import com.eg.gwt.openLayers.client.event.MapPopupOpenedListener.MapPopupOpenedEvent;
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

	private EventListenerCollection eventListeners = new EventListenerCollection();

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

	public int getNumLayers() {
		return MapImpl.getNumLayers(getJSObject());
	}

	/**
	 * Get a layer based on the id assigned by OpenLayers.
	 * A {@link com.eg.gwt.openLayers.client.layer.Layer} can be asked for it's id. This id can be used
	 * to get at the layer within the application.
	 *
	 * @param id - String identifier assigned by OpenLayers
	 * @return Layer - the layer on the map or null if there is no layer with the given id
	 */
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
	 *  This is not an OpenLayers native function. OpenLayers has getLayersByName
	 *  that returns all layers matching the name.
	 *
	 * @param name - the name of a layer or part of it
	 * @return Layer - the first layer that matches the name (so, if there are more layers
	 *    matching the name then only one is returned)
	 */
	public Layer getLayerByName(String name){
		Layer[] layers = this.getLayersByName(name);
		if(layers.length > 0){return layers[0];}else{return null;}
	}

	/**
	 *
	 * @param name - the name of a layer or part of it
	 * @return Layer[] - all layers with a name that fully or partially
	 *    matches the input name
	 */
	public Layer[] getLayersByName(String name){
		String regex= ".*" + name + ".*";
		Layer[] layers = this.getLayers();
		List layersFound = new ArrayList();
		for(int i = 0, max = layers.length; i < max;i++){
			if(layers[i].getName().matches(regex)){
				layersFound.add(layers[i]);
			}
		}
		if(layersFound.size()>0){
			int max = layersFound.size();
			Layer[] found = new Layer[max];
			for(int j = 0; j < max;j++ ){
				found[j] = (Layer) layersFound.get(j);
			}
			return found;
		}else{
			return null;
		}
	}

	/**
	 * This is not an OpenLayers native function. Will remove all overlays
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


	//TODO you want to keep track of Listeners
	// EventListenerCollection should be property of Map
	// that is also necessary for conveniently removing listeners
	public void addMapBaseLayerChangedListener(final MapBaseLayerChangedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_BASE_LAYER_CHANGED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject){
				Map map = Map.narrowToMap(source);
				MapBaseLayerChangedEvent e = new MapBaseLayerChangedEvent(eventObject);
				listener.onBaseLayerChanged(map, e);
			}
		});

	}

	public void addMapLayerAddedListener(final MapLayerAddedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_LAYER_ADDED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject){
				Map map = Map.narrowToMap(source);
				MapLayerAddedEvent e = new MapLayerAddedEvent(eventObject);
				listener.onLayerAdded(map, e);
			}
		});
	};

	public void addMapLayerChangedListener(final MapLayerChangedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_LAYER_CHANGED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject){
				Map map = Map.narrowToMap(source);
				MapLayerChangedEvent e = new MapLayerChangedEvent(eventObject);
				listener.onLayerChanged(map, e);
			}
		});

	}

	public void addMapLayerRemovedListener(final MapLayerRemovedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_LAYER_REMOVED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject){
				Map map = Map.narrowToMap(source);
				MapLayerRemovedEvent e = new MapLayerRemovedEvent(eventObject);
				listener.onLayerRemoved(map, e);
			}
		});

	}

	public void addMapMoveListener(final MapMoveListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_MOVE, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Map map = Map.narrowToMap(source);
				MapMoveEvent e = new MapMoveEvent(eventObject);
				listener.onMapMove(map, e);
			}
		 });
	};


	public void addMapMarkerAddedListener(final MapMarkerAddedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_MARKER_ADDED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Map map = Map.narrowToMap(source);
				MapMarkerAddedEvent e = new MapMarkerAddedEvent(eventObject);
				listener.onMarkerAdded(map, e);
			}
		 });
	};

	public void addMapMarkerRemovedListener(final MapMarkerRemovedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_MARKER_REMOVED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Map map = Map.narrowToMap(source);
				MapMarkerRemovedEvent e = new MapMarkerRemovedEvent(eventObject);
				listener.onMarkerRemoved(map, e);
			}
		 });
	};

	public void addMapPopupOpenedListener(final MapPopupOpenedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_POPUP_OPEN, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Map map = Map.narrowToMap(source);
				MapPopupOpenedEvent e = new MapPopupOpenedEvent(eventObject);
				listener.onPopupOpened(map, e);
			}
		 });
	};

	public void addMapPopupClosedListener(final MapPopupClosedListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_POPUP_CLOSE, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Map map = Map.narrowToMap(source);
				MapPopupClosedEvent e = new MapPopupClosedEvent(eventObject);
				listener.onPopupClosed(map, e);
			}
		 });
	};

	public void addMapClickListener(final MapClickListener listener){
		eventListeners.addListener(this, listener, EventType.MAP_CLICK, new EventHandler (){
			public void onHandle(JSObject source, JSObject eventObject) {
				Map map = Map.narrowToMap(source);
				MapClickEvent e = new MapClickEvent(eventObject);
				listener.onClick(map, e);
			}
		});
	};

	public void removeListener(EventListener listener){
		eventListeners.removeListener(this, listener);
	};

}
