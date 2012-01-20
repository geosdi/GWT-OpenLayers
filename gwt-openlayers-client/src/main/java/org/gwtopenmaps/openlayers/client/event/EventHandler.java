package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * <p>
 * Event handlers should be concrete extensions of this abstract class.
 * The onHandle method of a handlers gets called when an event fires
 * to which the handler is registered. See below, for a more convenient
 * way to listen to events.
 * </p>
 * <p>
 * An event handler can be registered in the following way:<br/>
 * <pre>
 *     map.getEvents().register("addlayer", map, new EventHandler()
 *     {
 *         public void onHandle(EventObject eventObject)
 *         {
 *             //handler code here
 *         }
 *     });
 * </pre>
 * </p>
 * <p>
 * Consult the OpenLayers API documentation at the <a href="http://openlayers.org/" target="_blank">OpenLayers site</a>
 * to see which objects fire events (e.g. Map, Layer, etc)
 * and which events they fire (e.g. "addlayer" fired by Map).
 * </p>
 * <p>
 * GWT OpenLayers provides a higher level way to register events through addXxxListener methods, which are
 * easier to use, and which provide type-safety. However, these may not be implemented for all events in OpenLayers.
 * The addXxxListener methods are methods on the Object firing the event:<br/>
 * <pre>
 *     map.addMapMoveListener(new MapMoveListener()
 *     {
 *         public void onMapMove(MapMoveEvent eventObject)
 *         {
 *             //handler code here
 *         }
 *     })
 * </pre>
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
     * @param eventObject - an event object that is passed by OpenLayers
     * when the event is fired (see also {@link EventObject}).
     */
    public abstract void onHandle(EventObject eventObject);

    /**
     *
     * @return the actual handler (a javascript object)
     */
    public JSObject getJSObject()
    {
        return this.handler;
    }
}
