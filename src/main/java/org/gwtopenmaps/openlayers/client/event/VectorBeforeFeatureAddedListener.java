package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorBeforeFeatureAddedListener extends EventListener {

	class BeforeFeatureAddedEvent extends VectorEvent {

		public BeforeFeatureAddedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onBeforeFeatureAdded(BeforeFeatureAddedEvent eventObject);

}
