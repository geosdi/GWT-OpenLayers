package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public class StyleOptionsImpl {
    
    public static native JSObject createContextStylerCallback(ContextStyler styler) /*-{
        var callback = function(feature){
            var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(feature);
            var val = styler.@org.gwtopenmaps.openlayers.client.ContextStyler::doStyle(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
            return val;
        }
        return callback;
    }-*/;
}
