package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMSImpl {

	public static native JSObject create(String name, String url, JSObject layerParams)/*-{
		return new $wnd.OpenLayers.Layer.TMS(name, url, layerParams);
	}-*/;

	public static native JSObject create(String name, JSObject urls, JSObject layerParams)/*-{
	    // JavaScript can loose the type of objects.
	    // the Array that was created in JArrayBaseImpl is reported as an "object"
	    // when the OpenLayers code checks for instanceof Array.  Converting the passed in urls Array to a new Array corrects this problem.
	    // There may be a better way, until it is figured out, this is what is done.

	    var tmsURLs = new $wnd.Array(urls.length);
		for (i = 0; i < urls.length; i++) {
		  tmsURLs[i] = urls[i];
		}

		return new $wnd.OpenLayers.Layer.TMS(name, tmsURLs, layerParams);
	}-*/;

	public static native int getNumLoadingTiles(JSObject layer)/*-{
		return layer.numLoadingTiles;
	}-*/;
}
