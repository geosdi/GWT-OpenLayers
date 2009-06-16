/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.DrawFeature.FeatureAddedListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeatureOptions extends ControlOptions {

	//TODO: define HandlerOptions, probably in it's own class under handlers
	public class HandlerOptions extends ControlOptions {}

	public void onFeatureAdded(FeatureAddedListener listener){
		JSObject callback = DrawFeatureImpl.createFeatureAddedCallback(listener);
		getJSObject().setProperty("featureAdded", callback);
	}

	public void setHandlerOptions(HandlerOptions handlerOptions){
		getJSObject().setProperty("handlerOptions", handlerOptions.getJSObject());
	}
}
