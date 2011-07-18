/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Lorenzo Amato - CNR IMAA geoSDI Group
 * @email lorenzo.amato@geosdi.org
 */
public class SnappingImpl {
	
	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.Snapping();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.Snapping(options);
	}-*/;
	
	public static native void addTarget(JSObject self, JSObject target)/*-{
		self.addTarget(target);
	}-*/;
	
	public static native void removeTarget(JSObject self, JSObject target)/*-{
			self.removeTarget(target);
	}-*/;
}
