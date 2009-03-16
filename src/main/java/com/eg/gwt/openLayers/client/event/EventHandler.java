package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.util.JSObject;



/**
 * <p>
 * Event handlers should be concrete extensions of this abstract class.
 * These handlers get called when an event fires to which they are registered.
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
 * GWT OpenLayers provides a higher level way to register events through addXxxListener methods, that should
 * be easier to use, and that are type-safe. However, these may not be implemented for all events in OpenLayers.
 * The addXxxListener methods are methods on the Object firing the event:<br/>
 * <code> map.addMapMoveListener(new MapMoveListener()
 * { public void onMapMove(Map source, MapMoveEvent eventObject){ //handler code here } })
 * </p>
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 *
 */
public abstract class EventHandler
{

    JSObject handler = EventHandlerImpl.createHandler(this);

    /**
     * This method is called on the EventHandler when the event fires
     * that the handler is registered for.
     *
     * @param source - the object firing the event
     * @param eventObject - an event object that is passed by OpenLayers
     * when the event is fired (see also {@link EventObject}).
     */
	public abstract void onHandle(JSObject source, JSObject eventObject);

	/**
	 *
	 * @return the actual handler (a javascript object)
	 */
    public JSObject getJSObject(){
        return this.handler;
    }
}
