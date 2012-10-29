package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.LayerLoadCancelListener;
import org.gwtopenmaps.openlayers.client.event.LayerLoadCancelListener.LoadCancelEvent;
import org.gwtopenmaps.openlayers.client.event.LayerLoadEndListener;
import org.gwtopenmaps.openlayers.client.event.LayerLoadEndListener.LoadEndEvent;
import org.gwtopenmaps.openlayers.client.event.LayerLoadStartListener;
import org.gwtopenmaps.openlayers.client.event.LayerLoadStartListener.LoadStartEvent;
import org.gwtopenmaps.openlayers.client.event.LayerVisibilityChangedListener;
import org.gwtopenmaps.openlayers.client.event.LayerVisibilityChangedListener.VisibilityChangedEvent;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay, Amr Alam - Refractions Research, Edwin Commandeur -
 * Atlis EJS
 *
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group -
 * @email nazzareno.sileno@geosdi.org
 */
public class Layer extends OpenLayersEObjectWrapper {

    public static final String ARCGIS93REST_CLASS_NAME = "OpenLayers.Layer.ArcGIS93Rest";
    public static final String BOXES_CLASS_NAME = "OpenLayers.Layer.Boxes";
    public static final String GOOGLE_CLASS_NAME = "OpenLayers.Layer.Google";
    public static final String GRIDLAYER_CLASS_NAME = "OpenLayers.Layer.Grid";
    public static final String HTTPREQUESTLAYER_CLASS_NAME = "OpenLayers.Layer.HTTPRequest";
    public static final String IMAGE_CLASS_NAME = "OpenLayers.Layer.Image";
    public static final String MARKERS_CLASS_NAME = "OpenLayers.Layer.Markers";
    public static final String OSM_CLASS_NAME = "OpenLayers.Layer.OSM";
    public static final String TMS_CLASS_NAME = "OpenLayers.Layer.TMS";
    public static final String VECTOR_CLASS_NAME = "OpenLayers.Layer.Vector";
    public static final String WMS_CLASS_NAME = "OpenLayers.Layer.WMS";
    public static final String XYZ_CLASS_NAME = "OpenLayers.Layer.XYZ";

    public static Layer narrowToLayer(JSObject layer) {
        return (layer == null) ? null : new Layer(layer);
    }

    // TODO: add support for moveend event
    // TODO: refactor to use getJSObject().getProperty/setProperty
    protected Layer(JSObject element) {
        super(element);
    }

    public void setIsBaseLayer(boolean isBaseLayer) {
        LayerImpl.setIsBaseLayer(isBaseLayer, getJSObject());
    }

    /**
     * Indicates if Layer is a BaseLayer.
     *
     * @return true if the layer is a BaseLayer false if the layer is not a
     * BaseLayer
     */
    public boolean isBaseLayer() {
        return LayerImpl.isBaseLayer(getJSObject());
    }

    public String getId() {
        return LayerImpl.getId(getJSObject());
    }

    public float getOpacity() {
        return LayerImpl.getOpacity(getJSObject());
    }

    public void setOpacity(float opacity) {
        LayerImpl.setOpacity(opacity, getJSObject());
    }

    /**
     * Indicates if the Layer should be displayed in the LayerSwitcher Control.
     *
     * @return true if the layer should be displayed in the LayerSwitcher
     * Control, false if the layer should be hidden
     */
    public boolean displayInLayerSwitcher() {
        return LayerImpl.displayInLayerSwitcher(getJSObject());
    }

    public void setDisplayInLayerSwitcher(boolean display) {
        LayerImpl.setDisplayInLayerSwitcher(display, getJSObject());
    }

    /**
     * @return The name of the Layer, or an empty string if no name was found.
     */
    public String getName() {
        return LayerImpl.getName(getJSObject());
    }

    /**
     * @param name - the new name for the layer.
     */
    public void setName(String name) {
        getJSObject().setProperty("name", name);
    }

    public boolean isVisible() {
        return LayerImpl.isVisible(getJSObject());
    }

    public void setIsVisible(boolean isVisible) {
        LayerImpl.setIsVisible(isVisible, getJSObject());
    }

    public boolean redraw() {

        /* super class redraw doesn't have a force.  But we'll pass through a value since the JSNI expects one */
        return LayerImpl.redraw(getJSObject(), true);
    }

    /**
     * Method: setZIndex
     *
     * Parameters: zIndex - {Integer}
     */
    public void setZIndex(int zIndex) {
        LayerImpl.setZIndex(getJSObject(), zIndex);
    }

    /**
     * Method: destroy Destroy is a destructor: this is to alleviate cyclic
     * references which the Javascript garbage cleaner can not take care of on
     * its own.
     *
     * Parameters: setNewBaseLayer - {Boolean} Set a new base layer when this
     * layer has been destroyed. Default is true.
     */
    public void destroy(boolean setNewBaseLayer) {
        LayerImpl.destroy(getJSObject(), setNewBaseLayer);
    }

    /**
     * Method: getZIndex
     *
     * Returns: {Integer} the z-index of this layer
     */
    public Object getZIndex() {
        return LayerImpl.getZIndex(getJSObject());
    }

    public void addOptions(LayerOptions layerOptions) {
        LayerImpl.addOptions(getJSObject(), layerOptions.getJSObject());
    }

    public Layer clone() {
        return narrowToLayer(LayerImpl.clone(getJSObject()));
    }

    public void addLayerLoadStartListener(final LayerLoadStartListener listener) {
        eventListeners.addListener(this, listener, EventType.LAYER_LOADSTART, new EventHandler() {
            public void onHandle(EventObject eventObject) {
                LoadStartEvent e = new LoadStartEvent(eventObject);
                listener.onLoadStart(e);
            }
        });
    }

    public void addLayerLoadEndListener(final LayerLoadEndListener listener) {
        eventListeners.addListener(this, listener, EventType.LAYER_LOADEND, new EventHandler() {
            public void onHandle(EventObject eventObject) {
                LoadEndEvent e = new LoadEndEvent(eventObject);
                listener.onLoadEnd(e);
            }
        });
    }

    public void addLayerLoadCancelListener(final LayerLoadCancelListener listener) {
        eventListeners.addListener(this, listener, EventType.LAYER_LOADCANCEL, new EventHandler() {
            public void onHandle(EventObject eventObject) {
                LoadCancelEvent e = new LoadCancelEvent(eventObject);
                listener.onLoadCancel(e);
            }
        });
    }

    public void addLayerVisibilityChangedListener(final LayerVisibilityChangedListener listener) {
        eventListeners.addListener(this, listener, EventType.LAYER_VISIBILITYCHANGED, new EventHandler() {
            public void onHandle(EventObject eventObject) {
                VisibilityChangedEvent e = new VisibilityChangedEvent(eventObject);
                listener.onVisibilityChanged(e);
            }
        });
    }

    public double getResolutionForZoom(double zoom) {
        double result = -1;
        if (this.isBaseLayer()) {
            result = LayerImpl.getResolutionForZoom(getJSObject(), zoom);
        }
        return result;
    }

    public Projection getProjection() {
        return Projection.narrowToProjection(LayerImpl.getProjection(getJSObject()));
    }
}
