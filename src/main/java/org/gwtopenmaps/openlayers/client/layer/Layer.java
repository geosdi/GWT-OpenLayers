package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.LayerLoadCancelListener;
import org.gwtopenmaps.openlayers.client.event.LayerLoadEndListener;
import org.gwtopenmaps.openlayers.client.event.LayerLoadStartListener;
import org.gwtopenmaps.openlayers.client.event.LayerVisibilityChangedListener;
import org.gwtopenmaps.openlayers.client.event.LayerLoadCancelListener.LoadCancelEvent;
import org.gwtopenmaps.openlayers.client.event.LayerLoadEndListener.LoadEndEvent;
import org.gwtopenmaps.openlayers.client.event.LayerLoadStartListener.LoadStartEvent;
import org.gwtopenmaps.openlayers.client.event.LayerVisibilityChangedListener.VisibilityChangedEvent;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay,
 *         Amr Alam - Refractions Research,
 *         Edwin Commandeur - Atlis EJS
 *
 */
public class Layer extends OpenLayersEObjectWrapper {

	//TODO: add support for moveend event

	protected Layer(JSObject element) {
		super(element);
	}

	public static Layer narrowToLayer(JSObject layer){
		return new Layer(layer);
	}

	/**
	 * @param force - if true force redraw by adding random parameter to getMap request
	 *
	 * If force is false or null no random parameters are added, in that case
	 * the browser may cache the getMap request, thus not redrawing the map
	 *
	 */
	public void redraw(boolean force) {
		LayerImpl.redraw(getJSObject(), force);
	}



	public void setIsBaseLayer(boolean isBaseLayer) {
		LayerImpl.setIsBaseLayer(isBaseLayer, getJSObject());
	}

	/**
	 * Indicates if Layer is a BaseLayer.
	 *
	 * @return true if the layer is a BaseLayer
	 *         false if the layer is not a BaseLayer
	 */
	public boolean isBaseLayer() {
		return LayerImpl.isBaseLayer(getJSObject());
	}

	public String getId() {
		return LayerImpl.getId(getJSObject());
	}

	public float getOpacity(){
		return LayerImpl.getOpacity(getJSObject());
	}

	public void setOpacity(float opacity){
		LayerImpl.setOpacity(opacity, getJSObject());
	}

	/**
	 * Indicates if the Layer should be displayed in the LayerSwitcher Control.
	 *
	 * @return true if the layer should be displayed in the LayerSwitcher Control,
	 *         false if the layer should be hidden
	 */
	public boolean displayInLayerSwitcher(){
		return LayerImpl.displayInLayerSwitcher(getJSObject());
	}

	public void setDisplayInLayerSwitcher(boolean display){
		LayerImpl.setDisplayInLayerSwitcher(display, getJSObject());
	}

	/**
	 * @return The name of the Layer, or an empty string if no name was found.
	 */
	public String getName(){
		return LayerImpl.getName(getJSObject());
	}

	public boolean isVisible(){
		return LayerImpl.isVisible(getJSObject());
	}

	public void setIsVisible(boolean isVisible){
		LayerImpl.setIsVisible(isVisible, getJSObject());
	}

	//TODO EventListenerCollection should be property of layer
	//  and keep references to listeners

	public void addLayerLoadStartListener(final LayerLoadStartListener listener){
		eventListeners.addListener(this, listener, EventType.LAYER_LOADSTART, new EventHandler(){
			public void onHandle(JSObject eventObject) {
				LoadStartEvent e = new LoadStartEvent(eventObject);
				listener.onLoadStart(e);
			}
		 });
	}

	public void addLayerLoadEndListener(final LayerLoadEndListener listener){
		eventListeners.addListener(this, listener, EventType.LAYER_LOADEND, new EventHandler(){
			public void onHandle(JSObject eventObject) {
				LoadEndEvent e = new LoadEndEvent(eventObject);
				listener.onLoadEnd(e);
			}
		 });
	}

	public void addLayerLoadCancelListener(final LayerLoadCancelListener listener){
		eventListeners.addListener(this, listener, EventType.LAYER_LOADCANCEL, new EventHandler(){
			public void onHandle(JSObject eventObject) {
				LoadCancelEvent e = new LoadCancelEvent(eventObject);
				listener.onLoadCancel(e);
			}
		 });
	}

	public void addLayerVisibilityChangedListener(final LayerVisibilityChangedListener listener){
		eventListeners.addListener(this, listener, EventType.LAYER_VISIBILITYCHANGED, new EventHandler(){
			public void onHandle(JSObject eventObject) {
				VisibilityChangedEvent e = new VisibilityChangedEvent(eventObject);
				listener.onVisibilityChanged(e);
			}
		 });
	}

}
