package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Marker;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MarkerEvent extends EventObject
{

    protected MarkerEvent(JSObject eventObject)
    {
        super(eventObject);
    }

    public Marker getSource()
    {
        JSObject object = getSourceJSObject();

        return (object != null) ? Marker.narrowToMarker(object) : null;
    }

}
