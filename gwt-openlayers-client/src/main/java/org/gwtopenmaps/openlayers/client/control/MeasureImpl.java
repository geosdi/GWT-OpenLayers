/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class MeasureImpl {

	public static native JSObject create(JSObject handler)/*-{
		return new $wnd.OpenLayers.Control.Measure(handler);
	}-*/;

	public static native JSObject create(JSObject handler,JSObject options)/*-{
		return new $wnd.OpenLayers.Control.Measure(handler, options);
	}-*/;

	public static native void setPersist(JSObject self, boolean persist)/*-{
		self.persist = persist;
	}-*/;
}
