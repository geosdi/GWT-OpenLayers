package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Pixel;
import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.layer.Layer;

/**
 * <p>Base class for event objects.</p>
 *
 * <b>Caveat: In Openlayers 2.x event handling is not yet implemented uniformly in OpenLayers. This should be fixed in version 3.x and higher.</b>
 * <p>
 * In OpenLayers, an event object is an argument that gets passed to the listener when it is called.
 * In GWT OpenLayers, this event object gets passed to the onHandle method of the EventHandler {@link EventHandler} when
 * the onHandle method is called. An event object class extending this base class can wrap this event object.
 * </p>
 * <p>
 * Depending on which event is fired, and from which source the event is fired
 * (e.g. Map, Layer, etc.), the event object may differ. Therefore, the
 * addXxxListener methods (see also {@link EventHandler}) that abstract from event registration details,
 * wrap the event object passed to onHandle in a way that is specific to the event.
 * </p>
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventObject {

	private JSObject eventObject;

	public EventObject(JSObject eventObject){
		this.eventObject = eventObject;
	}

	/**
	 *
	 * @return Element as an opaque JSObject
	 */
	public JSObject getElement(){
		return EventObjectImpl.getElement(getJSObject());
	}


	/**
	 * Type is a string like "addlayer" or "move" denoting the type of event.
	 *
	 * @return A string denoting the type of event, or null if there is no type property.
	 */
	public String getType(){
		String type = EventObjectImpl.getType(getJSObject());
		return type;
	}

	/**
	 * @return opaque handle on javascript object that fired the event
	 */
	public JSObject getObject(){
		JSObject object = EventObjectImpl.getObject(getJSObject());
		return object;
	}

	//TODO move this javadoc?
	/**
	 * Events fired by the Map like "addlayer", "removelayer", etc.
	 * return the layer as property of the event object.
	 *
	 * @return Layer effected by the event, or null if there is no layer property
	 */
	protected Layer getLayer(){
		JSObject layer = EventObjectImpl.getLayer(getJSObject());
		if(layer!= null){
			return Layer.narrowToLayer(layer);
		} else {
			return null;
		}
	}

	protected VectorFeature getFeature(){
		JSObject vectorFeature = EventObjectImpl.getFeature(getJSObject());
		if(vectorFeature != null){
			return VectorFeature.narrowToVectorFeature(vectorFeature);
		} else {
			return null;
		}
	}

	protected Pixel getPixel(){
		JSObject pixel = EventObjectImpl.getPixel(getJSObject());
		if(pixel != null){
			return Pixel.narrowToPixel(pixel);
		} else {
			return null;
		}
	}

	public JSObject getJSObject(){
		return this.eventObject;
	}
}
