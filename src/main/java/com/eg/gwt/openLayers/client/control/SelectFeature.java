package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * When activated, selects features on click by default. Use SelectFeatureOptions
 * argument to select on hover.
 *
 * @since GWT-OL 0.4 and OL 2.4
 * (tested in OpenLayers 2.7)
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class SelectFeature extends Control {


	/**
	 *
	 * @since GWT-OL 0.4
	 */
	public interface SelectFeatureListener {
		void onFeatureSelected(JSObject vectorFeature);
	}

	/**
	 *
	 * @since GWT-OL 0.4
	 */
	public interface UnselectFeatureListener {
		void onFeatureUnselected(JSObject vectorFeature);
	}

	protected SelectFeature(JSObject element) {
		super(element);
	}

	/**
	 *
	 * @since GWT-OL 0.4
	 * @param layer
	 */
	public SelectFeature(Vector layer) {
		this(SelectFeatureImpl.create(layer.getJSObject()));
	}

	/**
	*
	* @since GWT-OL 0.4
	* @param layer
	*/
	public SelectFeature(Vector layer, SelectFeatureOptions options) {
		this(SelectFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
	}

	/**
	 * Select a feature when hovering over it with the mouse
	 * (mouse in) and deselect it on mouse out.
	 *
	 * @since GWT-OL 0.4
	 * @param hover - true to select on hover
	 */
	public void setHover(boolean hover){
		SelectFeatureImpl.setHover(getJSObject(), hover);
	}

	/**
	 *
	 * Select and deselect a feature by clicking on it with the mouse.
	 *
	 * @since GWT-OL 0.4
	 * @param toggle - true to enabling toggling feature selection
	 */
	public void setToggle(boolean toggle){
		SelectFeatureImpl.setToggle(getJSObject(), toggle);
	}

	/**
	 *
	 * Hold down shift or ctrl and click to select multiple features.
	 *
	 * @since GWT-OL 0.4
	 * @param multipe - true to enable selecting multiple features
	 */
	public void setMultiple(boolean multiple){
		SelectFeatureImpl.setMultiple(getJSObject(), multiple);
	}

	/**
	 *
	 * Unselect a feature by clicking outside it.
	 *
	 * This is the default way of selecting/unselecting features.
	 *
	 * @since GWT-OL 0.4
	 * @param clickout - true to enable unselect on click outside feature.
	 */
	public void setClickOut(boolean clickout){
		SelectFeatureImpl.setClickOut(getJSObject(), clickout);
	}

	//TODO allow setting onSelect and onUnSelect here as well
}
