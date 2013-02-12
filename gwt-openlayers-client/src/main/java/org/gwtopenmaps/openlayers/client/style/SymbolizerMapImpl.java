package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.feature.Feature;
import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerMapImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.StyleMap();
    }-*/;

    public static native JSObject create(JSObject style, JSObject options) /*-{
        return new $wnd.OpenLayers.StyleMap(style, options);
    }-*/;

    public static native JSObject createSymbolizer(JSObject self, Feature feature, String intent) /*-{
        return self.createSymbolizer(feature, intent);
    }-*/;
}
