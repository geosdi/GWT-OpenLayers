package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatImpl
{

    public static native JSObject read(JSObject format, String input)
    /*-{
            return format.read(input);
    }-*/;

    public static native JSObject read(JSObject format, String input, JSObject options)
    /*-{
            return format.read(input, options);
    }-*/;

    public static native String write(JSObject format, JSObject object)
    /*-{
            return format.write(object);
    }-*/;

    public static native String writeArray(JSObject format, JSObject array)
    /*-{
            return $wnd.gwt_openlayers_util.relay.writeArray(format, array);
    }-*/;
}
