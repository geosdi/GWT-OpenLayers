package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * When activated, selects features on click by default. Use SelectFeatureOptions
 * argument to select on hover.
 *
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class SelectFeature extends Control {

	/**
	 *
	 */
	public interface SelectFeatureListener {
		void onFeatureSelected(VectorFeature vectorFeature);
	}

	/**
	 *
	 */
	public interface UnselectFeatureListener {
		void onFeatureUnselected(JSObject vectorFeature);
	}

	protected SelectFeature(JSObject element) {
		super(element);
	}

	/**
	 *
	 * @param layer
	 */
	public SelectFeature(Vector layer) {
		this(SelectFeatureImpl.create(layer.getJSObject()));
	}

	/**
	*
	* @param layer
	*/
	public SelectFeature(Vector layer, SelectFeatureOptions options) {
		this(SelectFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
	}

	/**
	 * Select a feature when hovering over it with the mouse
	 * (mouse in) and deselect it on mouse out.
	 *
	 * @param hover - true to select on hover
	 */
	public void setHover(boolean hover){
		SelectFeatureImpl.setHover(getJSObject(), hover);
	}

	/**
	 *
	 * Select and deselect a feature by clicking on it with the mouse.
	 *
	 * @param toggle - true to enabling toggling feature selection
	 */
	public void setToggle(boolean toggle){
		SelectFeatureImpl.setToggle(getJSObject(), toggle);
	}

	/**
	 *
	 * Hold down shift or ctrl and click to select multiple features.
	 *
	 * @param multipe - true to enable selecting multiple features
	 */
	public void setMultiple(boolean multiple){
		SelectFeatureImpl.setMultiple(getJSObject(), multiple);
	}

	public void setMultipleKey(String keyName) {
		SelectFeatureImpl.setMultipleKey(this.getJSObject(), keyName);
	}

	public void setToggleKey(String keyName) {
		SelectFeatureImpl.setToggleKey(this.getJSObject(), keyName);
	}

	public void unselect(JSObject feature) {
		SelectFeatureImpl.unselect(this.getJSObject(), feature);
	}

	/**
	 *
	 * Unselect a feature by clicking outside it.
	 *
	 * This is the default way of selecting/unselecting features.
	 *
	 * @param clickout - true to enable unselect on click outside feature.
	 */
	public void setClickOut(boolean clickout){
		SelectFeatureImpl.setClickOut(getJSObject(), clickout);
	}

	//TODO allow setting onSelect and onUnSelect here as well
}
