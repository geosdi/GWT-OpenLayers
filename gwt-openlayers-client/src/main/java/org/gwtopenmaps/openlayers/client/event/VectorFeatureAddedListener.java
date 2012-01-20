package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureAddedListener extends EventListener
{

    public void onFeatureAdded(FeatureAddedEvent eventObject);

    class FeatureAddedEvent extends VectorFeatureEvent
    {

        public FeatureAddedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
