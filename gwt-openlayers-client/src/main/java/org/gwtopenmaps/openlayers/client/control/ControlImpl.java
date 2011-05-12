package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

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
	
	public static native boolean isActive(JSObject self)/*-{
		return self.active;
	}-*/;
	
}
