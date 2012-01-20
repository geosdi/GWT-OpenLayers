package org.gwtopenmaps.openlayers.client.event;


/**
 * Needs to be implemented to listen to map move events.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapMoveListener extends EventListener
{

    void onMapMove(MapMoveEvent eventObject);

    class MapMoveEvent extends MapEvent
    {
        public MapMoveEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }
    }

}
