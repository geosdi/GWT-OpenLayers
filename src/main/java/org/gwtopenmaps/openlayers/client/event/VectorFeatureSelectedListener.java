package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureSelectedListener extends EventListener {

	class FeatureSelectedEvent extends VectorFeatureEvent {

		public FeatureSelectedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onFeatureSelected(FeatureSelectedEvent eventObject);
}
