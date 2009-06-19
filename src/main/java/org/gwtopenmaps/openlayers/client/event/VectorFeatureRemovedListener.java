package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureRemovedListener extends EventListener {

	class FeatureRemovedEvent extends VectorFeatureEvent {

		public FeatureRemovedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onFeatureRemoved(FeatureRemovedEvent eventObject);
}
