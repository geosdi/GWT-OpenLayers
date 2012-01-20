package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MarkerBrowserEventListener extends EventListener
{

    public void onBrowserEvent(MarkerBrowserEvent markerBrowserEvent);

    class MarkerBrowserEvent extends MarkerEvent
    {

        public MarkerBrowserEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
