package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.Options;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class WMSParams extends Options {

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
	
}
