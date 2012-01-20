package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureSelectedListener extends EventListener
{

    public void onFeatureSelected(FeatureSelectedEvent eventObject);

    class FeatureSelectedEvent extends VectorFeatureEvent
    {

        public FeatureSelectedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

    }
}
