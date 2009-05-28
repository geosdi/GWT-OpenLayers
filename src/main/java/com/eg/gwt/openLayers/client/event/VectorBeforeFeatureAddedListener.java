package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorBeforeFeatureAddedListener extends EventListener {

	class BeforeFeatureAddedEvent extends EventObject {

		public BeforeFeatureAddedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onBeforeFeatureAdded(Vector source, BeforeFeatureAddedEvent eventObject);

}
