package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class FormatImpl {

	public static native String read(JSObject format, String input)
	/*-{
		return format.read(input);
	}-*/;

	public static native String write(JSObject format, JSObject vectorFeature)
	/*-{
		return format.write(vectorFeature);
	}-*/;

	public static native String writeFeatures(JSObject format, JSObject vectorFeatures)
	/*-{
		return $wnd.gwt_openlayers_util.relay.writeFeatures(format, vectorFeatures);
	}-*/;
}
