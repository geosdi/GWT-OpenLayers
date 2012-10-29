package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Rafael Ceravolo - LOGANN
 * @author Lukas Johansson
 */
public class VectorFeatureImpl {

    public static native JSObject create(JSObject geometry) /*-{
     return new $wnd.OpenLayers.Feature.Vector(geometry, null, null);
     }-*/;

    public static native JSObject create(JSObject geometry, JSObject style) /*-{
     return new $wnd.OpenLayers.Feature.Vector(geometry, null, style);
     }-*/;

    public static native String getRenderIntent(JSObject self) /*-{
     return self.renderIntent;
     }-*/;

    public static native void setFeatureId(JSObject obj, String featureId) /*-{
     obj.id = featureId;
     }-*/;

    public static native boolean redraw(JSObject layer, boolean force) /*-{
     return layer.redraw(force);
     }-*/;

    public static native boolean getVisibility(JSObject obj) /*-{
     return obj.getVisibility();
     }-*/;

    public static native JSObject clone(JSObject obj) /*-{
     return obj.clone();
     }-*/;

    public static native JSObject getCluster(JSObject obj) /*-{
     return (obj.cluster === undefined) ? null : obj.cluster;
     }-*/;

    public static native void move(JSObject self, JSObject location)/*-{
     self.move(location);
     }-*/;

    public static native void toState(JSObject self, String state) /*-{
        self.toState(state);
    }-*/;

    public static native String getState(JSObject self) /*-{
        return self.state;
    }-*/;
}
