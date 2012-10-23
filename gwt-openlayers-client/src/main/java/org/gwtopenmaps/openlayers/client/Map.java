package org.gwtopenmaps.openlayers.client;

import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.Element;
import java.util.ArrayList;
import java.util.List;
import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.event.MapBaseLayerChangedListener.MapBaseLayerChangedEvent;
import org.gwtopenmaps.openlayers.client.event.MapClickListener.MapClickEvent;
import org.gwtopenmaps.openlayers.client.event.MapLayerAddedListener.MapLayerAddedEvent;
import org.gwtopenmaps.openlayers.client.event.MapLayerChangedListener.MapLayerChangedEvent;
import org.gwtopenmaps.openlayers.client.event.MapLayerRemovedListener.MapLayerRemovedEvent;
import org.gwtopenmaps.openlayers.client.event.MapMarkerAddedListener.MapMarkerAddedEvent;
import org.gwtopenmaps.openlayers.client.event.MapMarkerRemovedListener.MapMarkerRemovedEvent;
import org.gwtopenmaps.openlayers.client.event.MapMoveEndListener.MapMoveEndEvent;
import org.gwtopenmaps.openlayers.client.event.MapMoveListener.MapMoveEvent;
import org.gwtopenmaps.openlayers.client.event.MapPopupClosedListener.MapPopupClosedEvent;
import org.gwtopenmaps.openlayers.client.event.MapPopupOpenedListener.MapPopupOpenedEvent;
import org.gwtopenmaps.openlayers.client.event.MapZoomListener.MapZoomEvent;
import org.gwtopenmaps.openlayers.client.event.*;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.popup.Popup;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * <p>
 * The Map class is the hub of OpenLayers. Instances of the Map class
 * are "interactive maps embedded in a webpage". In GWT-OpenLayers the map is
 * wrapped in a MapWidget which is a GWT Widget. GWT Widgets can receive
 * events from the browser and can be added to GWT Panels.
 * </p>
 * <pre>
 *    MapWidget mapWidget = new MapWidget("100%", "100%");
 *    Map map = mapWidget.getMap(); //instantiates map
 *    map.setControls(new LayerSwitcher());
 * </pre>
 * <em>Or</em>
 * <pre>
 *    MapOptions options = new MapOptions();
 *    options.setControls(new LayerSwitcher());
 *    MapWidget mapWidget = new MapWidget("100%", "100%", options);
 *    Map map = mapWidget.getMap(); //instantiates map
 * </pre>
 * <p>
 * Adjusted from OL API docs:
 * On their own maps do not provide much functionality. To extend a map
 * it's necessary to add controls, see {@link org.gwtopenmaps.openlayers.client.control.Control}
 * and layers, see {@link org.gwtopenmaps.openlayers.client.layer.Layer}
 * to the map.
 *
 * </p>
 *
 * @author Erdem Gunay
 * @author Amr Alam - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 * @author Edwin Commandeur - Atlis Information Systems
 * @author Curtis Jensen - Integrity Applications Inc.
 * @author Lukas Johansson
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group - @email nazzareno.sileno@geosdi.org
 */
public class Map extends OpenLayersEObjectWrapper {

    Map(Element e) {
        super(MapImpl.create(e));
    }

    Map(Element e, MapOptions options) {
        super(MapImpl.create(e, options.getJSObject()));
    }

    protected Map(JSObject e) {
        super(e);
    }

    public static Map narrowToMap(JSObject object) {
        return (object == null) ? null : new Map(object);
    }

    /**
     * @return LonLat - the coordinates of the center
     */
    public LonLat getCenter() {
        return new LonLat(MapImpl.getCenter(getJSObject()));
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
        for (int i = 0; i < layers.length; i++) {
            jsObjects[i] = layers[i].getJSObject();
        }

        JObjectArray array = new JObjectArray(jsObjects);
        MapImpl.addLayers(getJSObject(), array.getJSObject());
    }

    public void addPopup(Popup popup) {
        MapImpl.addPopup(getJSObject(), popup.getJSObject());
    }

    /**
     * Closes all other popups first
     */
    public void addPopupExclusive(Popup popup) {
        MapImpl.addPopupExclusive(getJSObject(), popup.getJSObject());
    }

    public void removePopup(Popup popup) {
        MapImpl.removePopup(getJSObject(), popup.getJSObject());
    }

    public int getNumLayers() {
        return MapImpl.getNumLayers(getJSObject());
    }

    /**
     * Get a layer based on the id assigned by OpenLayers.
     * A {@link org.gwtopenmaps.openlayers.client.layer.Layer} can be asked for it's id. This id can be used
     * to get at the layer within the application.
     *
     * @param id - String identifier assigned by OpenLayers
     *
     * @return Layer - the layer on the map or null if there is no layer with the given id
     */
    public Layer getLayer(String id) {
        JSObject jsObject = MapImpl.getLayer(id, getJSObject());
        Layer layer = Layer.narrowToLayer(jsObject);
        return layer;
    }

    public Layer[] getLayers() {
        JSObject jsObjects = MapImpl.getLayers(getJSObject());
        JObjectArray jObjectArray = JObjectArray.narrowToJObjectArray(jsObjects);
        Layer[] layers = new Layer[jObjectArray.length()];
        for (int i = 0; i < jObjectArray.length(); i++) {
            layers[i] = Layer.narrowToLayer(jObjectArray.get(i));
        }
        return layers;
    }

    public Control getControlsByClass(String className) {
        JSObject jsObject = MapImpl.getControlsByClass(getJSObject(), className);
        return Control.narrowToControl(jsObject);
    }

    public void removeLayer(Layer layer) {
        MapImpl.removeLayer(getJSObject(), layer.getJSObject());
    }

    /**
     *
     * @param layer
     * @ param setNewBaseLayer
     * - {Boolean} default is true
     */
    public void removeLayer(Layer layer, boolean setNewBaseLayer) {
        MapImpl.removeLayer(getJSObject(), layer.getJSObject(), setNewBaseLayer);
    }

    public void removeControl(Control control) {
        MapImpl.removeControl(getJSObject(), control.getJSObject());
    }

    public int getLayerIndex(Layer layer) {
        return MapImpl.getLayerIndex(getJSObject(), layer.getJSObject());
    }

    public void setLayerIndex(Layer layer, int index) {
        MapImpl.setLayerIndex(getJSObject(), layer.getJSObject(), index);
    }

    /**
     * Method: setLayerZIndex
     *
     * Parameters: layer - {<OpenLayers.Layer>} zIdx - {int}
     */
    public void setLayerZIndex(Layer layer, int zIdx) {
        MapImpl.setLayerZIndex(getJSObject(), layer.getJSObject(), zIdx);
    }

    /**
     * Method: resetLayersZIndex Reset each layer's z-index based on layer's
     * array index
     */
    public void resetLayersZIndex() {
        MapImpl.resetLayersZIndex(getJSObject());
    }

    /**
     * This is not an OpenLayers native function. OpenLayers has getLayersByName
     * that returns all layers matching the name.
     *
     * @param name - the name of a layer or part of it
     *
     * @return Layer - the first layer that matches the name (so, if there are more layers
     * matching the name then only one is returned) or null if no layer matches
     */
    public Layer getLayerByName(String name) {
        //FIXME: this function goes wrong if getLayersByName returns null
        // fix - let getLayersByName return empty array + update javadoc
        Layer[] layers = this.getLayersByName(name);
        if (layers != null && layers.length > 0) {
            return layers[0];
        } else {
            return null;
        }
    }

    /**
     *
     * @param name - the name of a layer or part of it
     *
     * @return Layer[] - all layers with a name that fully or partially
     * matches the input name or null if no layer matches
     */
    public Layer[] getLayersByName(String name) {
        String regex = ".*" + name + ".*";
        Layer[] layers = this.getLayers();
        List<Layer> layersFound = new ArrayList<Layer>();
        for (int i = 0, max = layers.length; i < max; i++) {
            if (layers[i].getName().matches(regex)) {
                layersFound.add(layers[i]);
            }
        }
        if (layersFound.size() > 0) {
            int max = layersFound.size();
            Layer[] found = new Layer[max];
            for (int j = 0; j < max; j++) {
                found[j] = (Layer) layersFound.get(j);
            }
            return found;
        } else {
            return null;
        }
    }

    /**
     * This is not an OpenLayers native function. Will remove all overlays
     * from the this Map.
     */
    public void removeOverlayLayers() {
        Layer[] layers = getLayers();
        for (int i = 0; i < layers.length; i++) {
            if (layers[i].isBaseLayer() == false) {
                removeLayer(layers[i]);
            }
        }
    }

    public void zoomToExtent(Bounds bounds) {
        MapImpl.zoomToExtent(getJSObject(), bounds.getJSObject());
    }

    /**
     * APIMethod: zoomToExtent
     * Zoom to the passed in bounds, recenter.
     * @param bounds
     * @param closest Find the zoom level that most closely fits the
     * specified bounds. Note that this may result in a zoom that does
     * not exactly contain the entire extent. Default is false.
     */
    public void zoomToExtent(Bounds bounds, boolean closest) {
        MapImpl.zoomToExtent(getJSObject(), bounds.getJSObject(), closest);
    }

    public int getZoomForExtent(Bounds bounds, boolean closest) {
        return MapImpl.getZoomForExtent(getJSObject(), bounds.getJSObject(),
                closest);
    }

    /**
     * Returns current zoom level of map object.
     *
     * @return current zoom level
     */
    public int getZoom() {
        return MapImpl.getZoom(getJSObject());
    }

    public LonLat getLonLatFromPixel(Pixel pixel) {
        return new LonLat(MapImpl.getLonLatFromPixel(getJSObject(),
                pixel.getJSObject()));
    }

    public Pixel getPixelFromLonLat(LonLat lonlat) {
        return new Pixel(MapImpl.getPixelFromLonLat(getJSObject(),
                lonlat.getJSObject()));
    }

    /**
     * APIMethod: getLayerPxFromLonLat
     *
     * Parameters:
     * @param lonlat {<OpenLayers.LonLat>} lonlat
     *
     * @return {<OpenLayers.Pixel>} An OpenLayers.Pixel which is the passed-in
     *                      <OpenLayers.LonLat>, translated into layer pixels
     *                      by the current base layer
     */
    public Pixel getLayerPxFromLonLat(LonLat lonlat) {
    	return new Pixel(MapImpl.getLayerPxFromLonLat(getJSObject(),
    			lonlat.getJSObject()));
    }

    /**
     * Method: getLonLatFromLayerPx
     *
     * Parameters:
     * @param px - {<OpenLayers.Pixel>}
     *
     * @return {<OpenLayers.LonLat>}
     */
    public LonLat getLonLatFromLayerPx(Pixel px) {
    	return new LonLat(MapImpl.getLonLatFromLayerPx(getJSObject(),
    			px.getJSObject()));
    }

    public String getProjection() {
        return MapImpl.getProjection(getJSObject());
    }

    /**
     * See also {@link MapUnits}.
     *
     * @return String - the units used by the projection
     */
    public String getUnits() {
        return MapImpl.getUnits(getJSObject());
    }

    public Bounds getExtent() {
        return new Bounds(MapImpl.getExtent(getJSObject()));
    }

    public Bounds getMaxExtent() {
        return new Bounds(MapImpl.getMaxExtent(getJSObject()));
    }

    public double getResolution() {
        return MapImpl.getResolution(getJSObject());
    }

    public double getScale() {
        return MapImpl.getScale(getJSObject());
    }

    public void raiseLayer(Layer layer, int delta) {
        MapImpl.raiseLayer(getJSObject(), layer.getJSObject(), delta);
    }

    public void zoomTo(int zoomLevel) {
        MapImpl.zoomTo(getJSObject(), zoomLevel);
    }

    public void zoomToScale(float scale, boolean closest) {
        MapImpl.zoomToScale(getJSObject(), scale, closest);
    }

    public void zoomToMaxExtent() {
        MapImpl.zoomToMaxExtent(getJSObject());
    }

    public void setOptions(MapOptions mapOptions) {
        MapImpl.setOptions(getJSObject(), mapOptions.getJSObject());
    }

    public void panTo(LonLat lonlat) {
        MapImpl.panTo(getJSObject(), lonlat.getJSObject());
    }

    public void pan(int dx, int dy) {
        MapImpl.pan(getJSObject(), dx, dy);
    }

    public Size getTileSize() {
        return new Size(MapImpl.getTileSize(getJSObject()));
    }

    public Size getSize() {
        return new Size(MapImpl.getSize(getJSObject()));
    }

    public double getMaxResolution() {
        return MapImpl.getMaxResolution(getJSObject());
    }

    public double getResolutionForZoom() {
        return getJSObject().getPropertyAsDouble("fractionalZoom");
    }

    public String getCurrentUnits() {
        return getJSObject().getPropertyAsString("units");
    }

    public Layer getBaseLayer() {
        return Layer.narrowToLayer(getJSObject().getProperty("baseLayer"));
    }

    public double getResolutionForZoom(double zoom) {
        return this.getBaseLayer().getResolutionForZoom(zoom);
    }

    public double getZoomForResolution(double resolution, boolean closest) {
        return MapImpl.getZoomForResolution(getJSObject(), resolution, closest);
    }

    public double getZoomFromScale(double scale, boolean closest) {
        double resolution = OpenLayers.Util.getResolutionFromScale(scale,
                getCurrentUnits());
        return this.getZoomForResolution((Double) resolution, closest);
    }

    public double getScaleForZoom(double zoom, String units) {
        double resolution = this.getResolutionForZoom(zoom);
        return OpenLayers.Util.getScaleFromResolution(resolution, units);
    }

    /**
     * <p>
     * Somehow this is not an API property in OL, but it seems it would
     * make sense as an API property and it is well documented:
     * </p>
     * <p>
     * For a base layer that supports it, allow the map resolution
     * to be set to a value between one of the values in the resolutions
     * array. Default is false.
     *
     * When fractionalZoom is set to true, it is possible to zoom to
     * an arbitrary extent. This requires a base layer from a source
     * that supports requests for arbitrary extents (i.e. not cached
     * tiles on a regular lattice). This means that fractionalZoom
     * will not work with commercial layers (Google, Yahoo, VE), layers
     * using TileCache, or any other pre-cached data sources.
     *
     * If you are using fractionalZoom, then you should also use
     * getResolutionForZoom instead of layer.resolutions[zoom] as the
     * former works for non-integer zoom levels.
     * </p>
     *
     */
    public void setFractionalZoom(boolean fractionalZoom) {
        getJSObject().setProperty("fractionalZoom", fractionalZoom);
    }

    public void setMinExtent(Bounds extent) {
        getJSObject().setProperty("minExtent", extent.getJSObject());
    }

    public void setMaxExtent(Bounds extent) {
        getJSObject().setProperty("maxExtent", extent.getJSObject());
    }

    public void setRestrictedExtent(Bounds extent) {
        getJSObject().setProperty("restrictedExtent", extent.getJSObject());
    }

    /*
     * see MapOptions.setAllOverlays
     *
     * @param allOverlays
     */
    public boolean getAllOverlays() {
        return getJSObject().getPropertyAsBoolean("allOverlays");
    }

    public void setBaseLayer(Layer newBaseLayer) {
        MapImpl.setBaseLayer(getJSObject(), newBaseLayer.getJSObject());
    }

    /**
     * This function should be called by any external code which dynamically changes the size of the map div.
     * It can also be called when experiencing the problem of the single small tile in the upper left corner (doesn't work in all situations thought)
     */
    public void updateSize() {
        MapImpl.updateSize(getJSObject());
    }

    ;

	public void destroy() {
        MapImpl.destroy(getJSObject());
    }

    public void addMapBaseLayerChangedListener(final MapBaseLayerChangedListener listener) {
        eventListeners.addListener(this, listener,
                EventType.MAP_BASE_LAYER_CHANGED, new EventHandler() {

            public void onHandle(EventObject eventObject) {
                MapBaseLayerChangedEvent e = new MapBaseLayerChangedEvent(
                        eventObject);
                listener.onBaseLayerChanged(e);
            }
        });

    }

    public void addMapLayerAddedListener(final MapLayerAddedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_LAYER_ADDED,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapLayerAddedEvent e = new MapLayerAddedEvent(
                                eventObject);
                        listener.onLayerAdded(e);
                    }
                });
    }

    ;

	public void addMapLayerChangedListener(final MapLayerChangedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_LAYER_CHANGED,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapLayerChangedEvent e = new MapLayerChangedEvent(
                                eventObject);
                        listener.onLayerChanged(e);
                    }
                });

    }

    public void addMapLayerRemovedListener(final MapLayerRemovedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_LAYER_REMOVED,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapLayerRemovedEvent e = new MapLayerRemovedEvent(
                                eventObject);
                        listener.onLayerRemoved(e);
                    }
                });

    }

    public void addMapMoveListener(final MapMoveListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_MOVE,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapMoveEvent e = new MapMoveEvent(eventObject);
                        listener.onMapMove(e);
                    }
                });
    }

    public void addMapMoveEndListener(final MapMoveEndListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_MOVEEND,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapMoveEndEvent e = new MapMoveEndEvent(eventObject);
                        listener.onMapMoveEnd(e);
                    }
                });
    }

    public void addMapZoomListener(final MapZoomListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_ZOOMEND,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapZoomEvent e = new MapZoomEvent(eventObject);
                        listener.onMapZoom(e);
                    }
                });
    }

    public void addMapMarkerAddedListener(final MapMarkerAddedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_MARKER_ADDED,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapMarkerAddedEvent e = new MapMarkerAddedEvent(
                                eventObject);
                        listener.onMarkerAdded(e);
                    }
                });
    }

    public void addMapMarkerRemovedListener(final MapMarkerRemovedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_MARKER_REMOVED,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapMarkerRemovedEvent e = new MapMarkerRemovedEvent(
                                eventObject);
                        listener.onMarkerRemoved(e);
                    }
                });
    }

    public void addMapPopupOpenedListener(final MapPopupOpenedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_POPUP_OPEN,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapPopupOpenedEvent e = new MapPopupOpenedEvent(
                                eventObject);
                        listener.onPopupOpened(e);
                    }
                });
    }

    public void addMapPopupClosedListener(final MapPopupClosedListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_POPUP_CLOSE,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapPopupClosedEvent e = new MapPopupClosedEvent(
                                eventObject);
                        listener.onPopupClosed(e);
                    }
                });
    }

    public void addMapClickListener(final MapClickListener listener) {
        eventListeners.addListener(this, listener, EventType.MAP_CLICK,
                new EventHandler() {

                    public void onHandle(EventObject eventObject) {
                        MapClickEvent e = new MapClickEvent(eventObject);
                        listener.onClick(e);
                    }
                });
    }

    /**
     * Remove MapClickListener Defined on the Map
     *
     * @param listener
     */
    public void removeMapClickListener(final MapClickListener listener) {
        eventListeners.removeListener(this, listener);
    }

    public void disableBrowserContextMenu(BrowserMenuListener listener) {
        MapImpl.disableBrowserContextMenu(getJSObject(), listener);
    }

    /**
     *
     * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
     * @email giuseppe.lascaleia@geosdi.org
     *
     */
    public interface BrowserMenuListener {

        void onMouseClick(MouseEvent e);
    }

    /**
     * returns the DOM node of the viewport.
     * @return
     */
	public Element getViewport() {
		return MapImpl.getViewport(getJSObject());
	}

	/**
	 * zoom in with one step.
	 */
	public void zoomIn() {
		MapImpl.zoomIn(getJSObject());
	}

	/**
	 * zoom out with one step.
	 */
	public void zoomOut() {
		MapImpl.zoomOut(getJSObject());
	}
}
