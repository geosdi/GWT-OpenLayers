package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlDeactivateListener extends EventListener {
    
    //TODO refactor along the lines of MapMoveListener
    
    void onDeactivate(JSObject event);
}
