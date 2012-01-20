package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadEndListener extends EventListener
{

    public void onLoadEnd(LoadEndEvent eventObject);

    class LoadEndEvent extends LayerEvent
    {

        public LoadEndEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
