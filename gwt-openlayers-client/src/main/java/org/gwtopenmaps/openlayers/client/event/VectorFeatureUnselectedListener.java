package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureUnselectedListener extends EventListener
{

    public void onFeatureUnselected(FeatureUnselectedEvent eventObject);

    class FeatureUnselectedEvent extends VectorFeatureEvent
    {

        public FeatureUnselectedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
