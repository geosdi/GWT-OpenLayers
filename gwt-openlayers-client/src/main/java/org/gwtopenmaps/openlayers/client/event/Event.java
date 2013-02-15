package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class Event extends OpenLayersObjectWrapper
{

    public static Event narrowToEvent(JSObject element)
    {
        return (element == null) ? null : new Event(element);
    }

    protected Event(JSObject openLayersObject)
    {
        super(openLayersObject);
        // TODO Auto-generated constructor stub
    }

}
