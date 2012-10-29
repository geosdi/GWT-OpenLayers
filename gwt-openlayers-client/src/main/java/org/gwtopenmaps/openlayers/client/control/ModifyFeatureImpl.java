package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationEndListener;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationListener;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationStartListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ModifyFeatureImpl
{

    public static native JSObject create(JSObject vectorLayer) /*-{
        return new $wnd.OpenLayers.Control.ModifyFeature(vectorLayer);
    }-*/;

    public static native JSObject create(JSObject vectorLayer, JSObject options) /*-{
        return new $wnd.OpenLayers.Control.ModifyFeature(vectorLayer, options);
    }-*/;

    public static native JSObject createOnModificationStartCallback(OnModificationStartListener listener) /*-{
        var callback = function(obj){
        var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
        listener.@org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationStartListener::onModificationStart(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
        }
        return callback;
    }-*/;

    public static native JSObject createOnModificationCallback(OnModificationListener listener) /*-{
        var callback = function(obj){
        var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
        listener.@org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationListener::onModification(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
        }
        return callback;
    }-*/;

    public static native JSObject createOnModificationEndCallback(OnModificationEndListener listener) /*-{
        var callback = function(obj){
        var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
        listener.@org.gwtopenmaps.openlayers.client.control.ModifyFeature.OnModificationEndListener::onModificationEnd(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
        }
        return callback;
    }-*/;

    public static native boolean isSelectedFeatureModified(JSObject obj) /*-{
        return obj.modified;
    }-*/;

    public static native void selectFeature(JSObject obj, JSObject feature)/*-{
    	obj.selectFeature(feature);
	}-*/;

    public static native void unselectFeature(JSObject obj, JSObject feature)/*-{
		obj.unselectFeature(feature);
	}-*/;
}
