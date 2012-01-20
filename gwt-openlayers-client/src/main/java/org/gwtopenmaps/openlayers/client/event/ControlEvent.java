package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class ControlEvent extends EventObject
{

    protected ControlEvent(JSObject eventObject)
    {
        super(eventObject);
    }

    public Control getSource()
    {
        JSObject object = getSourceJSObject();

        return (object != null) ? Control.narrowToControl(object) : null;
    }

}
