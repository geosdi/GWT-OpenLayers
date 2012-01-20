package org.gwtopenmaps.openlayers.client.event;


/**
 * Needs to be implemented to listen to map zoom events.
 *
 * @author Curtis Jensen
 *
 */
public interface MapZoomListener extends EventListener
{

    void onMapZoom(MapZoomEvent eventObject);

    class MapZoomEvent extends MapEvent
    {
        public MapZoomEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }
    }

}
