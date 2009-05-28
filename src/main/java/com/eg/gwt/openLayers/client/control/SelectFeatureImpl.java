package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.control.SelectFeature.SelectFeatureListener;
import com.eg.gwt.openLayers.client.control.SelectFeature.UnselectFeatureListener;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * See {@link SelectFeature}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
class SelectFeatureImpl {

	public static native JSObject create(JSObject layer)/*-{
		return new $wnd.OpenLayers.Control.SelectFeature(layer);
	}-*/;


	public static native JSObject create(JSObject layer, JSObject options)/*-{
		return new $wnd.OpenLayers.Control.SelectFeature(layer, options);
	}-*/;

	public static native void setClickOut(JSObject self, boolean clickout)/*-{
		self.clickout = clickout;
	}-*/;

	public static native void setHover(JSObject self, boolean hover)/*-{
		self.hover = hover;
	}-*/;

	public static native void setMultiple(JSObject self, boolean multiple)/*-{
		self.multiple = multiple;
	}-*/;

	public static native void setToggle(JSObject self, boolean toggle)/*-{
		self.toggle = toggle;
	}-*/;

	public static native JSObject createSelectFeatureCallback(SelectFeatureListener listener)/*-{
		var callback = function(obj){
			listener.@com.eg.gwt.openLayers.client.control.SelectFeature.SelectFeatureListener::onFeatureSelected(Lcom/eg/gwt/openLayers/client/util/JSObject;)(obj);
		}
		return callback;
	}-*/;

	public static native JSObject createUnselectFeatureCallback(UnselectFeatureListener listener)/*-{
		var callback = function(obj){
			listener.@com.eg.gwt.openLayers.client.control.SelectFeature.UnselectFeatureListener::onFeatureUnselected(Lcom/eg/gwt/openLayers/client/util/JSObject;)(obj);
		}
		return callback;
	}-*/;

	public static native void unselect(JSObject selectFeature, JSObject feature)/*-{
    	selectFeature.unselect(feature);
	}-*/;
	
	public static native void setToggleKey(JSObject selectFeature, String keyName)/*-{
		selectFeature["toggleKey"] = keyName;
	}-*/;
	
	public static native void setMultipleKey(JSObject selectFeature, String keyName)/*-{
		selectFeature["multipleKey"] = keyName;
	}-*/;
}
