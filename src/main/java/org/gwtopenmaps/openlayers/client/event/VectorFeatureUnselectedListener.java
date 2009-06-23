package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureUnselectedListener extends EventListener {

	class FeatureUnselectedEvent extends VectorFeatureEvent {

		public FeatureUnselectedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onFeatureUnselected(FeatureUnselectedEvent eventObject);
}
