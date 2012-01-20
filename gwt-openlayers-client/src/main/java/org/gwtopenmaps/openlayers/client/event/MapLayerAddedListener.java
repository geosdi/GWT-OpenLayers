package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerAddedListener extends EventListener
{

    public void onLayerAdded(MapLayerAddedEvent eventObject);

    class MapLayerAddedEvent extends MapLayerEvent
    {

        public MapLayerAddedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
