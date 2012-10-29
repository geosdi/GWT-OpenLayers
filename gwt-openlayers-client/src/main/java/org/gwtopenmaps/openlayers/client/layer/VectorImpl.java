package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
*
* @author Erdem Gunay
* @author Edwin Commandeur - Atlis EJS
* @author Curtis Jensen
* @author Lukas Johansson
*
*/
class VectorImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Vector(name);
    }-*/;

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Vector(name, options);
    }-*/;

    public static native void addFeature(JSObject self, JSObject feature) /*-{
        self.addFeatures(feature);
    }-*/;

    public static native void addFeatures(JSObject self, JSObject features) /*-{
        $wnd.gwt_openlayers_util.relay.vectorAddFeatures(self, features);
    }-*/;

    public static native JSObject getFeature(JSObject self, int index) /*-{
        return self.features[index];
    }-*/;

    public static native int getNumberOfFeatures(JSObject self) /*-{
        if(self.features){
        return self.features.length;
        } else {
        return -1;
        }
    }-*/;

    public static native int getNumberOfSelectedFeatures(JSObject self) /*-{
        if(self.selectedFeatures){
        return self.selectedFeatures.length;
        } else {
        return -1;
        }
    }-*/;

    public static native void destroyFeatures(JSObject self) /*-{
        self.destroyFeatures();
    }-*/;

    public static native JSObject getFeatureById(JSObject self, String id) /*-{
        return self.getFeatureById(id);
    }-*/;

    public static native boolean redraw(JSObject vector) /*-{
        return vector.redraw();
    }-*/;

    public static native void drawFeature(JSObject vector, JSObject feature) /*-{
        vector.drawFeature(feature);
    }-*/;

    public static native void drawFeature(JSObject vector, JSObject feature,
        JSObject style) /*-{
        vector.drawFeature(feature, style);
    }-*/;

    public static native void eraseFeatures(JSObject vector) /*-{
        vector.eraseFeatures();
    }-*/;

    public static native void removeFeature(JSObject vector, JSObject feature) /*-{
        vector.removeFeatures(feature);
    }-*/;

    public static native JSObject getDataExtentImp(JSObject vector) /*-{
        return vector.getDataExtent();
    }-*/;

    public static native void setStyle(JSObject self, JSObject style) /*-{
        self.style = style;
    }-*/;

    public static native JSObject getStyle(JSObject self) /*-{
        return self.style;
    }-*/;

    public static native void setStyleMap(JSObject self, JSObject styleMap) /*-{
        self.styleMap = styleMap;
    }-*/;

    public static native JSObject getStyleMap(JSObject self) /*-{
        return self.styleMap;
    }-*/;

    public static native JSObject getSelectedFeature(JSObject self, int index) /*-{
       return self.selectedFeatures[index];
    }-*/;

}
