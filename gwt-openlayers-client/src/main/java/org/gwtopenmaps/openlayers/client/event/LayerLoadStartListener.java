package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadStartListener extends EventListener
{

    public void onLoadStart(LoadStartEvent eventObject);

    class LoadStartEvent extends LayerEvent
    {

        public LoadStartEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
