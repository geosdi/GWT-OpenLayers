package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.marker.Box;
import org.gwtopenmaps.openlayers.client.util.JSObject;
/**
* @author Michel Vitor A Rodrigues
*/
public class BoxesImpl {

	public static native JSObject create(String name, JSObject options)/*-{
		return new $wnd.OpenLayers.Layer.Boxes(name, options);
	}-*/;
	
	public static native JSObject create(String name)/*-{
	    return new $wnd.OpenLayers.Layer.Boxes(name);
	}-*/;
	
	public static native void drawMarker(JSObject box, Box marker)/*-{
	    box.drawMarker(marker);
	}-*/;
	public static native void removeMarker(JSObject box, Box marker)/*-{
	    box.removeMarker(marker); 	
	}-*/;
}
