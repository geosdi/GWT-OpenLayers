package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SnappingImpl {
	
	public native static JSObject create(JSObject options) /*-{
		return new $wnd.OpenLayers.Control.Snapping(options);
	}-*/;
	
	public native static JSObject create() /*-{
		return new $wnd.OpenLayers.Control.Snapping();
	}-*/;
	
	public native static boolean activate(JSObject self) /*-{
		return self.activate();
	}-*/;
	
	public native static boolean deactivate(JSObject self) /*-{
		return self.deactivate();
	}-*/;
	
	public native static void setLayer(JSObject self, JSObject vector) /*-{
		self.setLayer(vector);
	}-*/;
	
	public native static void addTargetLayer(JSObject self, JSObject vector) /*-{
		self.addTargetLayer(vector);
	}-*/;
	
	public native static void removeTargetLayer(JSObject self, JSObject vector) /*-{
		self.removeTargetLayer(vector);
	}-*/;
}
