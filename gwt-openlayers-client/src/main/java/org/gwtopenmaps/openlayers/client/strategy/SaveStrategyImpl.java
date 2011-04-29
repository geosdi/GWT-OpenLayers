package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SaveStrategyImpl {

	public native static boolean activate(JSObject self) /*-{
		return self.activate();
	}-*/;
	
	public native static boolean deactivate(JSObject self) /*-{
		return self.activate();
	}-*/;
	
	public native static void setAuto(JSObject self, boolean enable) /*-{
		self.auto = enable;
	}-*/;
	
	public native static void setAuto(JSObject self, int interval) /*-{
		self.auto = interval;
	}-*/;
	
	public native static void save(JSObject self) /*-{
		self.save();
	}-*/;
	
	public native static void save(JSObject self, JSObject array) /*-{
		self.save(array);		
	}-*/;
	
	public native static JSObject create() /*-{
		return new $wnd.OpenLayers.Strategy.Save();
	}-*/;
}