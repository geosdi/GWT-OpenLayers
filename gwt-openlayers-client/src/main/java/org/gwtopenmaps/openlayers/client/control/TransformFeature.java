/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.TransformBeforeSetFeatureListener.BeforeSetFeatureEvent;
import org.gwtopenmaps.openlayers.client.control.TransformCompleteListener.TransformCompleteEvent;
import org.gwtopenmaps.openlayers.client.control.TransformSetFeatureListener.SetFeatureEvent;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Control to transform features.
 * @author Lorenzo Amato <lorenzo.amato@geosdi.org>
 *
 */

public class TransformFeature extends Control {

	protected TransformFeature(JSObject tranformFeature) {
		super(tranformFeature);
	}

	public TransformFeature(Vector vectorLayer) {
		this(TransformFeatureImpl.create(vectorLayer.getJSObject()));
	}

	public TransformFeature(Vector vectorLayer,
			TransformFeatureOptions transformFeatureOptions) {
		this(TransformFeatureImpl.create(vectorLayer.getJSObject(),
				transformFeatureOptions.getJSObject()));
	}

	/**
	 * Add a listener that is triggered after dragging.
	 */
    public void addTransformCompleteListener(final TransformCompleteListener listener)
    {
        eventListeners.addListener(this, listener, "transformcomplete", new EventHandler()
        {
            @Override
            public void onHandle(EventObject eventObject)
            {
                TransformCompleteEvent e = new TransformCompleteEvent(eventObject);
                listener.onTransformComplete(e);
            }
        });
    }

    /**
     * Triggered before a feature is set for tranformation.
     */
    public void addBeforeSetFeatureListener(final TransformBeforeSetFeatureListener listener)
    {
        eventListeners.addListener(this, listener, "beforesetfeature", new EventHandler()
        {
            @Override
            public void onHandle(EventObject eventObject)
            {
                BeforeSetFeatureEvent e = new BeforeSetFeatureEvent(eventObject);
                listener.onBeforeSetFeature(e);
            }
        });
    }

    /**
     * Triggered when a feature is set for tranformation.
     */
    public void addSetFeatureListener(final TransformSetFeatureListener listener)
    {
        eventListeners.addListener(this, listener, "setfeature", new EventHandler()
        {
            @Override
            public void onHandle(EventObject eventObject)
            {
                SetFeatureEvent e = new SetFeatureEvent(eventObject);
                listener.onSetFeature(e);
            }
        });
    }
}
