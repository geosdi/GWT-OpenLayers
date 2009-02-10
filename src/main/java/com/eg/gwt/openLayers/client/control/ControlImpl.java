package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class ControlImpl {

	public static native boolean activate(JSObject self)/*-{
		return self.activate();
	}-*/;
	
	public static native boolean deactivate(JSObject self)/*-{
		return self.deactivate();
	}-*/;

	
}
