package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;

public class CollectionImpl {

    public native static int getNumberOfComponents(JSObject self)/*-{
        return self.components.length;
    }-*/;
    
    public native static JSObject getComponent(JSObject self, int index)/*-{
        return self.components[index];
    }-*/;
}
