package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 *
 */
public class MouseEventImpl {
	
	public native static int clientX(JSObject self) /*-{
		return self.clientX;
	}-*/;
	
	public native static int clientY(JSObject self) /*-{
		return self.clientY;
	}-*/;

}
