package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.control.SelectFeature.SelectFeatureListener;
import com.eg.gwt.openLayers.client.control.SelectFeature.UnselectFeatureListener;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.OptionsBase;

/**
 * See {@link SelectFeature}.
 *
 * Default mode of selection is clickout, see {@link SelectFeature}.
 *
 * @since GWT-OL 0.4
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class SelectFeatureOptions extends OptionsBase {


	/**
	 *
	 * @since GWT-OL 0.4
	 */
	public void setHover(){
		setAttribute("hover", true);
	}

	/**
	 *
	 * @since GWT-OL 0.4
	 */
	public void setToggle(){
		setAttribute("toggle", true);
	}

	/**
	 *
	 * @since GWT-OL 0.4
	 */
	public void setMultiple(){
		setAttribute("multiple", true);
	}

	/**
	 * Triggers when a feature is selected
	 *
	 * @since GWT-OL 0.4
	 */
	public void onSelect(SelectFeatureListener listener){
		JSObject callback = SelectFeatureImpl.createSelectFeatureCallback(listener);
		setAttribute("onSelect", callback);
	}

	/**
	 * Triggers when a feature is unselected
	 *
	 * @since GWT-OL 0.4
	 */
	public void onUnSelect(UnselectFeatureListener listener){
		JSObject callback = SelectFeatureImpl.createUnselectFeatureCallback(listener);
		setAttribute("onUnselect", callback);
	}

}
