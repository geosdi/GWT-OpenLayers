package com.eg.gwt.openLayers.client.feature;

import com.eg.gwt.openLayers.client.Bounds;
import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.OpenLayersObjectWrapper;
import com.eg.gwt.openLayers.client.Style;
import com.eg.gwt.openLayers.client.popup.Popup;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * 
 */
public abstract class Feature extends OpenLayersObjectWrapper {

    protected Feature(JSObject element){
        super(element);
    }
    
    public void destroy(){
        FeatureImpl.destroy(getJSObject());
    }
    
    public String getFeatureId(){
        return FeatureImpl.getFeatureId(getJSObject());
    }

	public Popup createPopup(boolean closeBox) {
		JSObject popupObj = FeatureImpl.createPopup(this.getJSObject(), closeBox);
		
		return Popup.narrowToOpenLayersPopup(popupObj);
	}
	
	public LonLat getCenterLonLat() {
		return Bounds.narrowToBounds(FeatureImpl.getBounds(this.getJSObject())).getCenterLonLat();
	}
	
	public void setPopup(Popup popup) {
		FeatureImpl.setPopup(this.getJSObject(), popup.getJSObject());
	}
	
	public Popup getPopup() {
		return Popup.narrowToOpenLayersPopup(FeatureImpl.getPopup(this.getJSObject()));
	}
	
	public void resetPopup() {
		FeatureImpl.resetPopup(this.getJSObject());
	}
	
	public void setStyle(Style newStyle) {
		FeatureImpl.setStyle(this.getJSObject(), newStyle.getJSObject());
	}
}
