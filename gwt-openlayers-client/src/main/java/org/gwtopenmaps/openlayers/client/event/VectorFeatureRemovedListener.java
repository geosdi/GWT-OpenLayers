package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureRemovedListener extends EventListener
{

    public void onFeatureRemoved(FeatureRemovedEvent eventObject);

    class FeatureRemovedEvent extends VectorFeatureEvent
    {

        public FeatureRemovedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
