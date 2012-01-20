package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorBeforeFeatureAddedListener extends EventListener
{

    public void onBeforeFeatureAdded(BeforeFeatureAddedEvent eventObject);

    class BeforeFeatureAddedEvent extends VectorEvent
    {

        public BeforeFeatureAddedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }

}
