package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapBaseLayerChangedListener extends EventListener
{

    public void onBaseLayerChanged(MapBaseLayerChangedEvent eventObject);

    class MapBaseLayerChangedEvent extends MapLayerEvent
    {

        public MapBaseLayerChangedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
