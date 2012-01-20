package org.gwtopenmaps.openlayers.client.event;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapPopupClosedListener extends EventListener
{

    public void onPopupClosed(MapPopupClosedEvent eventObject);

    class MapPopupClosedEvent extends MapEvent
    {

        public MapPopupClosedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }
        // getPopup ???
    }
}
