/**
 * 
 */
package com.eg.gwt.openLayers.client;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class StyleImpl {

    public static native JSObject create()
    /*-{
        return $wnd.OpenLayers.Util.extend({}, $wnd.OpenLayers.Feature.Vector.style['default']);
        //return new Object(); //do it all yourself
    }-*/;
    
    public static native void setFillColor(JSObject self, String s)
    /*-{
        self.fillColor = s;
    }-*/;

    public static native String getFillColor(JSObject self)
    /*-{
        return self.fillColor;
    }-*/;
    
    public static native void setFillOpacity(JSObject self, double o)
    /*-{
        self.fillOpacity = o;
    }-*/;

    public static native double getFillOpacity(JSObject self)
    /*-{
        return self.fillOpacity;
    }-*/;

    public static native void setPointRadius(JSObject self, double o)
    /*-{
        self.pointRadius = o;
    }-*/;

    public static native double getPointRadius(JSObject self)
    /*-{
        return self.pointRadius;
    }-*/;

    public static native void setStrokeColor(JSObject self, String s)
    /*-{
        self.strokeColor = s;
    }-*/;

    public static native String getStrokeColor(JSObject self)
    /*-{
        return self.strokeColor;
    }-*/;    

    public static native void setStrokeWidth(JSObject self, double w)
    /*-{
        self.strokeWidth = s;
    }-*/;

    public static native double getStrokeWidth(JSObject self)
    /*-{
        return self.strokeWidth;
    }-*/;
}
