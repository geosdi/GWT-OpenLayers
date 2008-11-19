package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.event.ControlActivateListener;
import com.eg.gwt.openLayers.client.event.ControlDeactivateListener;

/**
 * Options specific to Control widgets.
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ControlOptionsImpl {

    protected static native void setControlActivateListener(JSObject self, ControlActivateListener listener)/*-{
        if(!self.eventListeners){self.eventListeners = new Object();}
           
        var handler = function(event) {
            listener.@com.eg.gwt.openLayers.client.event.ControlActivateListener::onActivate(Lcom/eg/gwt/openLayers/client/JSObject;)(event);
        }
        self.eventListeners.activate = handler;
    }-*/;

    public static native void setControlDeactivateListener(JSObject self, ControlDeactivateListener listener)/*-{
        if(!self.eventListeners){self.eventListeners = {}};
        
        var handler = function(event) {
            listener.@com.eg.gwt.openLayers.client.event.ControlDeactivateListener::onDeactivate(Lcom/eg/gwt/openLayers/client/JSObject;)(event);
        }
        
        self.eventListeners.deactivate = handler;
    }-*/;
}
