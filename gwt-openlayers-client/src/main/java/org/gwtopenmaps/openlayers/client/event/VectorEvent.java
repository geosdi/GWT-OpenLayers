package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class VectorEvent extends EventObject
{

    protected VectorEvent(JSObject eventObject)
    {
        super(eventObject);
    }

    public Vector getSource()
    {
        JSObject object = getSourceJSObject();

        return (object != null) ? Vector.narrowToVector(object) : null;
    }

}
