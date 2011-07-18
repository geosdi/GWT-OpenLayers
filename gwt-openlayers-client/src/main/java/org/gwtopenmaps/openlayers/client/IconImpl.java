package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class IconImpl {

	public static native JSObject create(String url, JSObject size)/*-{
		return new $wnd.OpenLayers.Icon(url, size);
	}-*/;

	public static native JSObject create(String url, JSObject size, JSObject offset)/*-{
		return new $wnd.OpenLayers.Icon(url, size, offset);
	}-*/;

	public static native void setSize(JSObject self, JSObject size)/*-{
		self.setSize(size);
	}-*/;

    public static native void setUrl(JSObject self, String url)/*-{
		self.setUrl(url);
	}-*/;
	public static native void setZIndex(JSObject self, int zIndex)/*-{
        self.imageDiv.childNodes[0].style.zIndex = zIndex;
    }-*/;

    public static native String getZIndex(JSObject self)/*-{
        return self.imageDiv.childNodes[0].style.zIndex;
    }-*/;

}
