package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadCancelListener extends EventListener
{

    public void onLoadCancel(LoadCancelEvent eventObject);

    class LoadCancelEvent extends LayerEvent
    {

        public LoadCancelEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
