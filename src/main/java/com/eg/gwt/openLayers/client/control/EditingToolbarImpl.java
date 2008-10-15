package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

public class EditingToolbarImpl {

    public static native JSObject create(JSObject vectorLayer)/*-{
        return new $wnd.OpenLayers.Control.EditingToolbar(vectorLayer);
    }-*/;

}
