package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerVisibilityChangedListener extends EventListener
{

    public void onVisibilityChanged(VisibilityChangedEvent eventObject);

    class VisibilityChangedEvent extends LayerEvent
    {

        public VisibilityChangedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
