package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class EventObjectImpl
{

    public static native JSObject getElement(JSObject eventObject) /*-{
        return (eventObject.element)?(eventObject.element):null;
    }-*/;

    public static native String getType(JSObject eventObject) /*-{
        return (eventObject.type)?(eventObject.type):null;
    }-*/;

    public static native JSObject getObject(JSObject eventObject) /*-{
        return (eventObject.object)?(eventObject.object):null;
    }-*/;

}
