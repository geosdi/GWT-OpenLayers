package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Lukas Johansson
 */
public class FeatureImpl
{

    public static native void destroy(JSObject self) /*-{
        self.destroy();
    }-*/;

    public static native String getFeatureId(JSObject self) /*-{
        return self.id;
    }-*/;

    public static native String getFID(JSObject self) /*-{
        return self.fid;
    }-*/;

    public static native void setPopup(JSObject feature, JSObject inputPopup) /*-{
        feature.popup = inputPopup;
    }-*/;

    public static native JSObject getPopup(JSObject feature) /*-{
        return feature.popup;
    }-*/;

    public static native void resetPopup(JSObject feature) /*-{
        feature.popup.destroy();
        feature.popup = null;
    }-*/;

    public static native JSObject createPopup(JSObject feature, boolean closeBox) /*-{
        return feature.createPopup(closeBox);
    }-*/;

    public static native JSObject getBounds(JSObject feature) /*-{
        return feature.geometry.getBounds();
    }-*/;

    public static native void setStyle(JSObject feature, JSObject newStyle) /*-{
        feature.style = newStyle;
    }-*/;

    public static native JSObject getStyle(JSObject self) /*-{
        return self.style;
    }-*/;

    public static native JSObject getLayer(JSObject feature) /*-{
        return feature.layer;
    }-*/;

}
