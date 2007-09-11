package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Erdem Gunay
 *
 */
public abstract class Control extends OpenLayersWidget {

	protected Control(JSObject element) {
		super(element);
	}

	public boolean activate() {
		return ControlImpl.activate(getJSObject());
	}

	public boolean deactivate() {
		return ControlImpl.deactivate(getJSObject());
	}
	
}
