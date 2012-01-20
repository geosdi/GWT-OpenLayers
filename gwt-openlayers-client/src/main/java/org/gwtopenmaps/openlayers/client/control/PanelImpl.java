package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 *
 */
class PanelImpl
{

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Panel(options);
    }-*/;

    public static native void addControls(JSObject panel, JSObject controls) /*-{
        panel.addControls(controls);
    }-*/;
}
