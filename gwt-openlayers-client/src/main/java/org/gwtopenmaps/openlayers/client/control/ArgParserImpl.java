package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * See {@link ArgParser}.
 *
 * @author Edwin Commandeur
 *
 */
class ArgParserImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.ArgParser();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.ArgParser(options);
    }-*/;

}
