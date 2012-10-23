package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 *
 * @author Martin Hultman - Swedish Meteorological and Hydrological Institute
 *
 */
public class KeyboardDefaultsImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.KeyboardDefaults();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.KeyboardDefaults(options);
	}-*/;

}
