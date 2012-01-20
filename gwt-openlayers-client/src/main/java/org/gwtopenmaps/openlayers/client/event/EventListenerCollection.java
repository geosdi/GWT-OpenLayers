package org.gwtopenmaps.openlayers.client.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;


/**
 * The EventListenerCollection serves to maintain references to EventListeners, and
 * keeps hold of the properties necessary to unregister EventListeners.
 *
 * When an EventListener is added to the EventListener collection it is passed all
 * the information to add it as a listener for events a particular widget fires.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventListenerCollection
{

    private Map<EventListener, ListenerRegisteredProperties> map =
        new HashMap<EventListener, ListenerRegisteredProperties>();

    public void addListener(OpenLayersObjectWrapper w, EventListener listener, String type, EventHandler handler)
    {
        // TODO check if type is defined and valid?
        w.getEvents().register(type, w, handler);
        addToCollection(listener, new ListenerRegisteredProperties(type, handler));
    }

    public void removeListener(OpenLayersObjectWrapper w, EventListener listener)
    {
        ListenerRegisteredProperties props = getRegisteredProperties(listener);
        if (props != null)
        {
            w.getEvents().unregister(props.getType(), w, props.getEventHandler());
            removeRegisteredProperties(listener);
        }
        // TODO give feedback that listener is not in collection
    }

    /**
     * Removes all listeners registered on an object.
     *
     * @param wrapper - wrapper object for OpenLayers object that fires events
     */
    public void removeListeners(OpenLayersObjectWrapper wrapper)
    {
        Set<EventListener> keys = map.keySet(); // iterate over keyset
        for (Iterator<EventListener> it = keys.iterator(); it.hasNext();)
        {
            EventListener listener = (EventListener) it.next();
            removeListener(wrapper, listener);
        }
    }

    /**
     *  A view of all the listeners registered on an object.
     *
     *  Items in the set can be cast to {@link org.gwtopenmaps.openlayers.client.event.EventListener} objects.
     *
     *  @return - a Set of {@link org.gwtopenmaps.openlayers.client.event.EventListener} objects.
     */
    public Set<EventListener> getListeners()
    {
        Set<EventListener> keys = map.keySet();

        return keys;
    }

    private void addToCollection(EventListener listener, ListenerRegisteredProperties props)
    {
        map.put(listener, props);
    }

    private ListenerRegisteredProperties getRegisteredProperties(EventListener listener)
    {
        return (ListenerRegisteredProperties) map.get(listener);
    }

    private void removeRegisteredProperties(EventListener listener)
    {
        map.remove(listener);
    }


    private class ListenerRegisteredProperties
    {
        String type;
        EventHandler handler;

        ListenerRegisteredProperties(String type, EventHandler handler)
        {
            this.type = type;
            this.handler = handler;
        }

        String getType()
        {
            return this.type;
        }

        EventHandler getEventHandler()
        {
            return this.handler;
        }
    }
}
