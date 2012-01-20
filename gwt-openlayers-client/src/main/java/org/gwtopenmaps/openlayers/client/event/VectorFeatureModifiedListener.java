package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureModifiedListener extends EventListener
{

    public void onFeatureModified(FeatureModifiedEvent eventObject);

    class FeatureModifiedEvent extends VectorFeatureEvent
    {

        public FeatureModifiedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
