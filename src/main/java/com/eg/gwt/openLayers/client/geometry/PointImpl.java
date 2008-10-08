package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Atlis EJS, Edwin Commandeur
 * 
 */
public class PointImpl {

    public native static JSObject create(double x, double y)/*-{
        return new $wnd.OpenLayers.Geometry.Point(x, y);
    }-*/;
    
    public native static double getX(JSObject self)/*-{
        return self.x;
    }-*/;
    
    public native static double getY(JSObject self)/*-{
        return self.y;
    }-*/;
    
    public native static String getId(JSObject self)/*-{
        return self.id;
    }-*/;

}
