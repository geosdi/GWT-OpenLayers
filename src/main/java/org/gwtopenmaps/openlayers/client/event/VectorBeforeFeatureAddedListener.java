package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorBeforeFeatureAddedListener extends EventListener {

	class BeforeFeatureAddedEvent extends VectorEvent {

		public BeforeFeatureAddedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onBeforeFeatureAdded(BeforeFeatureAddedEvent eventObject);

}
