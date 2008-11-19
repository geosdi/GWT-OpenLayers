package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.OptionsBase;
import com.eg.gwt.openLayers.client.event.ControlActivateListener;
import com.eg.gwt.openLayers.client.event.ControlDeactivateListener;

/**
 * Options specific to Control widgets.
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
//TODO perhaps better to enhance Control with these setXxxListener functions
//  these can be registered using 
//      control.events.register("activate", null, handler)
//      control.events.register("deactivate", null, handler)
//  if that works eventListenersToObject in util.js is not necessary
public class ControlOptions extends OptionsBase {

    public void setControlActivateListener(ControlActivateListener listener){
        ControlOptionsImpl.setControlActivateListener(getJSObject(), listener);
    }

    public void setControlDeactivateListener(ControlDeactivateListener listener){
        ControlOptionsImpl.setControlDeactivateListener(getJSObject(), listener);
    }

}
