package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerRemovedListener extends EventListener
{

    public void onLayerRemoved(MapLayerRemovedEvent eventObject);

    class MapLayerRemovedEvent extends MapLayerEvent
    {

        public MapLayerRemovedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
