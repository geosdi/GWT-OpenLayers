package org.gwtopenmaps.openlayers.client.event;


/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapMarkerRemovedListener extends EventListener
{

    public void onMarkerRemoved(MapMarkerRemovedEvent eventObject);

    class MapMarkerRemovedEvent extends MapEvent
    {

        public MapMarkerRemovedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        // getMarker ???
    }
}
