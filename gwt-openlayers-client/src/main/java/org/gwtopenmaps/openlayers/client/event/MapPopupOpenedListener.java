package org.gwtopenmaps.openlayers.client.event;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapPopupOpenedListener extends EventListener
{

    public void onPopupOpened(MapPopupOpenedEvent eventObject);

    class MapPopupOpenedEvent extends MapEvent
    {

        public MapPopupOpenedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        // getPopup ???
    }
}
