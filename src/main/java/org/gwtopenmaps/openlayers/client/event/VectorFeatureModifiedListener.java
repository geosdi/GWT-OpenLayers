package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureModifiedListener extends EventListener {

	class FeatureModifiedEvent extends VectorFeatureEvent {

		public FeatureModifiedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onFeatureModified(FeatureModifiedEvent eventObject);
}
