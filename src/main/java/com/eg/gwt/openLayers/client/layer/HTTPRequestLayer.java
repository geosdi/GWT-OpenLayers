package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;


/**
* Wrapper of OpenLayers.Layer.HTTPRequest in OpenLayers. Renamed HTTPREquest
* to HTTPRequestLayer so it is not confused with HTTPRequest in GWT.
*
* HTTPRequest in GWT provides functionality to make basic HTTP requests.
*
* HTTPRequestLayer in GWT-OL supports ...
*
* From OL API docs:
*
*
* @author Edwin Commandeur - Atlis EJS
*
*/
public class HTTPRequestLayer extends Layer {

	//TODO: this class should implement
	// - getFullRequestUrl
	// - ...

	protected HTTPRequestLayer(JSObject element) {
		super(element);
	}



}
