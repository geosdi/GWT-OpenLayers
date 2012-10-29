package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
* @author Lorenzo Amato <lorenzo.amato@geosdi.org>
*
*/

public class TransformFeatureImpl {


    public static native JSObject create(JSObject vectorLayer) /*-{
        return new $wnd.OpenLayers.Control.TransformFeature(vectorLayer);
    }-*/;

    public static native JSObject create(JSObject vectorLayer, JSObject options) /*-{
        return new $wnd.OpenLayers.Control.TransformFeature(vectorLayer, options);
    }-*/;
    
    
    
    
//    
//    public static native void setFeature(JSObject self, JSObject feature)/*-{
//        self.setFeature(feature);
//    }-*/;
}
