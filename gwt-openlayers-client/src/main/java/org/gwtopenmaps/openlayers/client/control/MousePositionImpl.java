package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
class MousePositionImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.MousePosition();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.MousePosition(options);
    }-*/;

    public static native JSObject formatOutput(MousePositionOutput output) /*-{
        var outputFn = function(lonLat){
        var out = ""
        var lonLatObj = @org.gwtopenmaps.openlayers.client.LonLat::narrowToLonLat(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(lonLat);
        var mapObj = @org.gwtopenmaps.openlayers.client.Map::narrowToMap(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(this.map);
        
        out = output.@org.gwtopenmaps.openlayers.client.control.MousePositionOutput::format(Lorg/gwtopenmaps/openlayers/client/LonLat;Lorg/gwtopenmaps/openlayers/client/Map;)(lonLatObj,mapObj);
        
        return out;
        }
        return outputFn;
    }-*/;

}
