package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


class PathHandlerImpl
{

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Handler.Path;
    }-*/;

	public static native void click(JSObject handler, JSObject pixel)/*-{
		var fakeEvent = {'xy' : pixel };
		handler.down(fakeEvent);
		handler.up(fakeEvent);
	}-*/;

}
