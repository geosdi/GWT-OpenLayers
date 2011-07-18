package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureSelectedListener extends EventListener {

	class FeatureSelectedEvent extends VectorFeatureEvent {

		public FeatureSelectedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onFeatureSelected(FeatureSelectedEvent eventObject);
}
