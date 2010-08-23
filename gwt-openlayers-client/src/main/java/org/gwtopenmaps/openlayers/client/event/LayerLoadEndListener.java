package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadEndListener extends EventListener {

	class LoadEndEvent extends LayerEvent {

		public LoadEndEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onLoadEnd(LoadEndEvent eventObject);
}
