package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerVisibilityChangedListener extends EventListener {

	class VisibilityChangedEvent extends LayerEvent {

		public VisibilityChangedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onVisibilityChanged(VisibilityChangedEvent eventObject);
}
