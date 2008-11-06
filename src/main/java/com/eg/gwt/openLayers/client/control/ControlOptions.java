package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.OptionsBase;

/**
 * Options specific to Control widgets.
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */

public class ControlOptions extends OptionsBase {

    public void setControlActivateListener(ControlActivateListener listener){
        ControlOptionsImpl.setControlActivateListener(getJSObject(), listener);
    }

    public void setControlDeactivateListener(ControlDeactivateListener listener){
        ControlOptionsImpl.setControlDeactivateListener(getJSObject(), listener);
    }

}
