package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.marker.Box;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
*
* @author Michel Vitor - Intec
*
*/
public class BoxEvent extends EventObject
{

    protected BoxEvent(JSObject eventObject)
    {
        super(eventObject);
    }

    public Box getSource()
    {
        JSObject object = getSourceJSObject();

        return (object != null) ? Box.narrowToBox(object) : null;
    }

}
