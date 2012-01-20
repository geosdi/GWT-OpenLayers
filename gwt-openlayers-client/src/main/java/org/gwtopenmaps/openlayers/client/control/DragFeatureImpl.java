package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


public class DragFeatureImpl
{

    public static native JSObject create(JSObject vectorLayer) /*-{
        return new $wnd.OpenLayers.Control.DragFeature(vectorLayer);
    }-*/;

    public static native JSObject create(JSObject vectorLayer, JSObject options) /*-{
        return new $wnd.OpenLayers.Control.DragFeature(vectorLayer,options);
    }-*/;

    public static native JSObject createDragCallback(
        DragFeatureListener listener) /*-{
        var callback = function(vectorFeature,pixel){
        var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(vectorFeature);
        var pixelObj = @org.gwtopenmaps.openlayers.client.Pixel::narrowToPixel(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(pixel);
        listener.@org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener::onDragEvent(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;Lorg/gwtopenmaps/openlayers/client/Pixel;)(vectorFeatureObj,pixelObj);
        }
        return callback;
    }-*/;


}
