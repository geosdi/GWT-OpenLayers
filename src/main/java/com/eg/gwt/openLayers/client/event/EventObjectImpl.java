package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class EventObjectImpl {

    public static native JSObject getElement(JSObject eventObject)/*-{
        return (eventObject.element)?(eventObject.element):"undefined";
    }-*/;
    
    public static native String getType(JSObject eventObject)/*-{
        return (eventObject.type)?(eventObject.type):"undefined";
    }-*/;
    
    public static native JSObject getLayer(JSObject eventObject)/*-{
        return (eventObject.layer)?(eventObject.layer):"undefined";
    }-*/;

}
