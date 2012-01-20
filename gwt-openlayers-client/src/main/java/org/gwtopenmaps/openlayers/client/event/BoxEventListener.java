package org.gwtopenmaps.openlayers.client.event;

/**
*
* @author Michel Vitor - Intec
*
*/
public interface BoxEventListener extends EventListener
{
    public void onBox(BoxEvents eventObject);

    class BoxEvents extends BoxEvent
    {

        public BoxEvents(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }
    }

}
