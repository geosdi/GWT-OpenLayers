package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.OptionsBase;
import com.eg.gwt.openLayers.client.event.ControlActivateListener;
import com.eg.gwt.openLayers.client.event.ControlDeactivateListener;

//TODO make Options base class that is less extensive as Options
// the base class should have some private methods that Options class can supplement
// and use to provide more functionality...
// Let Options extend that, so that previous code will still work

public class ControlOptions extends OptionsBase {

    public void setControlActivateListener(ControlActivateListener listener){
        ControlOptionsImpl.setControlActivateListener(getJSObject());
    }
    
    public void setControlDeactivateListener(ControlDeactivateListener listener){
        
    }
    
}
