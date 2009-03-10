package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * 
 */
public class FeatureImpl {

    public static native void destroy(JSObject self)/*-{
        self.destroy();
    }-*/;
    
    public static native String getFeatureId(JSObject self)/*-{
        return self.id;
    }-*/;    

	public static native void setPopup(JSObject feature, JSObject inputPopup)/*-{
		feature.popup = inputPopup;
	}-*/;
	
	public static native JSObject getPopup(JSObject feature)/*-{
		return feature.popup;
	}-*/;
	
	public static native void resetPopup(JSObject feature)/*-{
		feature.popup.destroy();
		feature.popup = null;
	}-*/;

	public static native JSObject createPopup(JSObject feature, boolean closeBox)/*-{
		return feature.createPopup(closeBox);
	}-*/;
	
	public static native JSObject getBounds(JSObject feature)/*-{
		return feature.geometry.getBounds();
	}-*/;
	
	public static native void setStyle(JSObject feature, JSObject newStyle)/*-{
		feature.style = newStyle;
	}-*/;
}
