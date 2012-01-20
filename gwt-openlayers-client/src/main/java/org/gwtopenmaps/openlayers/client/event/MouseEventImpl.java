package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 *
 */
public class MouseEventImpl
{

    public static native int clientX(JSObject self) /*-{
        return self.clientX;
    }-*/;

    public static native int clientY(JSObject self) /*-{
        return self.clientY;
    }-*/;

}
