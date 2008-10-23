package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * Equal to Point handler, but avoids name conflicts with Point geometry
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PointHandler extends Point {

    protected PointHandler(JSObject element) {
        super(element);
    }
}
