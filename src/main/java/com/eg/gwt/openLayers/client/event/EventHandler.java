package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;



/**
 * <p>
 * Event handlers should implement this interface. These handlers get
 * called when an event fires to which they are registered.
 * </p>
 * <p>
 * An event handler can be registered in the following way:<br/>
 * <code> map.getEvents().register("addlayer", map, new EventHandler()
 * { public void onHandle(JSObject source, JSObject eventObject){ //handler code here } })</code>
 * </p>
 * <p>
 * Consult the OpenLayers API documentation at the <a href="http://openlayers.org/" target="_blank">OpenLayers site</a> 
 * to see which type of objects fire events (e.g. Map, Layer, etc)
 * and to see which events these objects fire (e.g. "addlayer" fired by Map).
 * </p>
 * <p>
 * GWT OpenLayers provides a higher level way to register events, that is
 * easier to use, and is type-safe, but may not be implement for all events in OpenLayers.
 * This is through addXxxListener methods on the Object firing the event:<br/> 
 * <code> map.addMapMoveListener(new MapMoveListener()
 * { public void onMapMove(Map source, MapMoveEvent eventObject){ //handler code here } })
 * </p>
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur
 *
 */
public interface EventHandler 
{
    /**
     * Gets called when the event fires.
     *  
     * @param source - the object firing the event
     * @param eo - an event object that is sometimes passed by OpenLayers 
     * when the event is fired (see also {@link EventObject}).
     */
	public void onHandle(JSObject source, JSObject eo);
}
