package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class MouseEvent extends Event
{

    public static MouseEvent narrowToMouseEvent(JSObject element)
    {
        return (element == null) ? null : new MouseEvent(element);
    }

    protected MouseEvent(JSObject openLayersObject)
    {
        super(openLayersObject);
        // TODO Auto-generated constructor stub
    }

    public Pixel getScreenPixel()
    {
        return new Pixel(MouseEventImpl.clientX(getJSObject()),
                MouseEventImpl.clientY(getJSObject()));
    }

}
