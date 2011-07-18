package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Rafael Ceravolo - LOGANN
 * @author Lukas Johansson 
 */
public class VectorFeatureImpl {

	public native static JSObject create(JSObject geometry)/*-{
		return new $wnd.OpenLayers.Feature.Vector(geometry, null, null);
	}-*/;

	public native static JSObject create(JSObject geometry, JSObject style)/*-{
		return new $wnd.OpenLayers.Feature.Vector(geometry, null, style);
	}-*/;

	public static native String getRenderIntent(JSObject self) /*-{
		return self.renderIntent;
	}-*/;

    public native static void setFeatureId(JSObject obj, String featureId)/*-{
        obj.id = featureId;
    }-*/;

    public native static boolean redraw(JSObject layer, boolean force)/*-{
        return layer.redraw(force);
    }-*/;

    public native static boolean getVisibility(JSObject obj)/*-{
        return obj.getVisibility();
    }-*/;

    public native static JSObject clone(JSObject obj)/*-{
        return obj.clone();
    }-*/;
}
