/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author lorenzo
 *
 */
public class GraticuleImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Graticule();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Graticule(options);
    }-*/;

}
