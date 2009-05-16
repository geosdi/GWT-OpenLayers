/**
 *
 */
package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.control.DrawFeature.FeatureAddedListener;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeatureOptions extends ControlOptions {

	public void onFeatureAdded(FeatureAddedListener listener){
		JSObject callback = DrawFeatureImpl.createFeatureAddedCallback(listener);
		getJSObject().setProperty("featureAdded", callback);
	}
}
