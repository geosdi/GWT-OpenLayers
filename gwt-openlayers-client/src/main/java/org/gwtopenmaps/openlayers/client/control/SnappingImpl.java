package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SnappingImpl {
	
	public native static JSObject create(JSObject options) /*-{
		return $wnd.OpenLayers.Control.Snapping(options);
	}-*/;
	
	public native static boolean activate(JSObject self) /*-{
		return self.ativate();
	}-*/;
	
	public native static boolean deactivate(JSObject self) /*-{
		return self.deativate();
	}-*/;
}
