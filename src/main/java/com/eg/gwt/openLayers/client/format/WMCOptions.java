package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.OptionsBase;

public class WMCOptions extends OptionsBase {

	//TODO: create constructors that take map or id

	/**
	 * Use this method to merge ... with the map
	 * or
	 * use setMapDomElementId to create a new map in that dom element.
	 *
	 *
	 * @param map - the map to merge map elements with that are created
	 *   on the basis of the WMC document
	 */
	public void setMap(Map map){
		setAttribute("map", map.getJSObject());
	};

	/**
	 *
	 * @param id - the dom element id where to put the map created
	 *   from reading a WMC document
	 */
	public void setMapDomElementId(String id){
		setAttribute("map", id);
	}
}
