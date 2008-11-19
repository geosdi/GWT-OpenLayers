package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.Bounds;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class WMSParams extends LayerOptions {

	public WMSParams() {
		
	}
	
	public void setLayers(String layers) {
		setAttribute("layers", layers);
	}
	public String getLayers() {
		return getAttribute("layers");
	}
	
	public void setStyles(String styles) {
		setAttribute("styles", styles);
	}
	public String getStyles() {
		return getAttribute("styles");
	}
	
	public void setFormat(String styles) {
		setAttribute("format", styles);
	}
	public String getFormat() {
		return getAttribute("format");
	}
	
	public void setMaxExtent(Bounds bounds) {
		setAttribute("maxExtent", bounds.getJSObject());
	}
	public Bounds getMaxExtent() {
		return Bounds.narrowToBounds(getAttributeAsJSObject("maxExtent"));
	}
	
    /**
     * Set transparent parameter in WMS request. Default is false.
     *
     * Within this method the value of the parameter will be set in uppercase,
     * since at least IONIC's WMS requires it to be in uppercase, in
     * accordance with the WMS Specification
     *
     * The WMS 1.1.1 spec states:
     *  "TRANSPARENT can take on two values, "TRUE" or "FALSE"."
     *  and
     *  "Parameter names shall not be case sensitive, 
     *  but parameter values shall be case sensitive."
     *  
     */
    public void setIsTransparent(boolean isTransparent){
        if(isTransparent){
            setAttribute("transparent", "TRUE");
        } else {
            setAttribute("transparent", "FALSE");
        }
    }
}
