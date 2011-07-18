package org.gwtopenmaps.openlayers.client.marker;

import org.gwtopenmaps.openlayers.client.util.JSObject;

class BoxImpl {

	public static native JSObject create(JSObject bounds, String borderColor, int borderWidth)/*-{
	     return new $wnd.OpenLayers.Marker.Box(bounds, borderColor, borderWidth);
    }-*/;
	public static native void setBorder(JSObject object, String borderColor, int borderWidth)/*-{
		object.setBorder(borderColor, borderWidth);
	}-*/;
    
	public static native void setZIndex(JSObject self, int zIndex)/*-{
        self.div.style.zIndex = zIndex;
    }-*/;

    public static native String getZIndex(JSObject self)/*-{
        return self.div.style.zIndex;
    }-*/;

    public static native JSObject getBounds(JSObject self)/*-{
        return self.bounds;
    }-*/;

}
