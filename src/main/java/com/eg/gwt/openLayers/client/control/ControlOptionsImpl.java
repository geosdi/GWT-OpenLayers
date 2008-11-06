package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

public class ControlOptionsImpl {

    protected static native void setControlActivateListener(JSObject self, ControlActivateListener listener)/*-{
        if(!self.eventListeners){self.eventListeners = new Object();}
           
        var handler = function(event) {
            listener.@com.eg.gwt.openLayers.client.control.ControlActivateListener::onActivate(Lcom/eg/gwt/openLayers/client/JSObject;)(event);
        }
        self.eventListeners.activate = handler;
    }-*/;

    public static native void setControlDeactivateListener(JSObject self, ControlDeactivateListener listener)/*-{
        if(!self.eventListeners){self.eventListeners = {}};
        
        var handler = function(event) {
            listener.@com.eg.gwt.openLayers.client.control.ControlDeactivateListener::onDeactivate(Lcom/eg/gwt/openLayers/client/JSObject;)(event);
        }
        
        self.eventListeners.deactivate = handler;
    }-*/;
}
