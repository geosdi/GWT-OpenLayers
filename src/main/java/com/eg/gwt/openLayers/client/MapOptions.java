package com.eg.gwt.openLayers.client;


/**
 * 
 * @author Erdem Gunay
 *
 */
public class MapOptions extends Options {

	public MapOptions() {
		
	}
	
	public void setNumZoomLevels(int numZoomLevels) {
		setAttribute("numZoomLevels", numZoomLevels);
	}

	public void setControls(JObjectArray controls) {
		setAttribute("controls", controls);
	}
	
	public void setProjection(String projection) {
		setAttribute("projection", projection);
	}
}
