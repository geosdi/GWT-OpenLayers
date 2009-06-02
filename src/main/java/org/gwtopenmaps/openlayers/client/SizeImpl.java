package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class SizeImpl {

	public static native JSObject create(int w, int h)/*-{
		return new $wnd.OpenLayers.Size(w, h);
	}-*/;

	public static native JSObject create(float w, float h)/*-{
		return new $wnd.OpenLayers.Size(w, h);
	}-*/;

	public static native float getWidth(JSObject self)/*-{
		return self.w;
	}-*/;

	public static native void setWidth(JSObject self, float width)/*-{
		self.w = width;
	}-*/;

	public static native float getHeight(JSObject self)/*-{
		return self.h;
	}-*/;

	public static native void setHeight(JSObject self, float height)/*-{
		self.h = height;
	}-*/;

	//uses OL equals implementation
	public static native boolean equals(JSObject self, JSObject size)/*-{
		return self.equals(size);
	}-*/;

	public static native String toString(JSObject self)/*-{
		return self.toString();
	}-*/;
}
