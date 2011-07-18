package org.gwtopenmaps.openlayers.client.event;

/**
 * Listener for Trigger AfterFeatureModified on Vector Layer
 * 
 * @author giuseppe
 * 
 */
public interface VectorAfterFeatureModifiedListener extends EventListener {

	class AfterFeatureModifiedEvent extends VectorFeatureEvent {

		public AfterFeatureModifiedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onAfterFeatureModified(AfterFeatureModifiedEvent eventObject);

}
