package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.SelectFeature.SelectFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.UnselectFeatureListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * See {@link SelectFeature}.
 * 
 * Default mode of selection is clickout, see {@link SelectFeature}.
 * 
 * @author Edwin Commandeur - Atlis EJS
 * @author Rafael Ceravolo - LOGANN
 * 
 */
public class SelectFeatureOptions extends ControlOptions {

	/**
	 *
	 */
	public void setHover() {
		getJSObject().setProperty("hover", true);
	}

	/**
	 *
	 */
	public void setToggle() {
		getJSObject().setProperty("toggle", true);
	}
	
	/**
	 *
	 */
	public void setMultiple() {
		getJSObject().setProperty("multiple", true);
	}
	
	/**
	 * Allows features to be selected by dragging a box.
	 */
         public void setBox(boolean box) {
             getJSObject().setProperty("box", box);
        }
	/**
	 * Triggers when a feature is selected
	 * 
	 */
	public void onSelect(SelectFeatureListener listener) {
		JSObject callback = SelectFeatureImpl.createSelectFeatureCallback(listener);
		getJSObject().setProperty("onSelect", callback);
	}
	
	

	/**
	 * Triggers when a feature is unselected
	 * 
	 */
	public void onUnSelect(UnselectFeatureListener listener) {
		JSObject callback = SelectFeatureImpl.createUnselectFeatureCallback(listener);
		getJSObject().setProperty("onUnselect", callback);
	}

	/**
	 * From OpenLayers documentation: If true do not actually select features
	 * (i.e. place them in the layer’s selected features array), just highlight
	 * them. This property has no effect if hover is false. Defaults to false.
	 * 
	 * @param highlightOnly
	 *            The property value
	 */
	public void setHighlightOnly(boolean highlightOnly) {
		getJSObject().setProperty("highlightOnly", highlightOnly);
	}

}
