package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureAddedListener extends EventListener {

	class FeatureAddedEvent extends VectorFeatureEvent {

		public FeatureAddedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onFeatureAdded(FeatureAddedEvent eventObject);
}
