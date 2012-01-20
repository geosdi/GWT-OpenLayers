package org.gwtopenmaps.openlayers.client.event;


/**
 * Listener for Trigger BeforeFeatureModified on Vector Layer
 *
 * beforefeaturemodified - Triggered when a feature is selected to be modified.
 * Listeners will receive an object with a *feature* property referencing the
 * selected feature.
 *
 * @author giuseppe
 *
 */
public interface VectorBeforeFeatureModifiedListener extends EventListener
{

    public void onBeforeFeatureModified(BeforeFeatureModifiedEvent eventObject);

    class BeforeFeatureModifiedEvent extends VectorFeatureEvent
    {

        public BeforeFeatureModifiedEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
            // TODO Auto-generated constructor stub
        }

    }

}
