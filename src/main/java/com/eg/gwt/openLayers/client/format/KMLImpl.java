package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class KMLImpl {

	public static native JSObject create()
	/*-{
		return new $wnd.OpenLayers.Format.KML();
	}-*/;

	public static native JSObject read(JSObject kmlFormat, String kmlString)/*-{
		return kmlFormat.read(kmlString);
	}-*/;
	
	public static native String write(JSObject kmlFormat, JSObject feature, boolean pretty)/*-{
		return kmlFormat.write(feature, pretty);
	}-*/;

}
