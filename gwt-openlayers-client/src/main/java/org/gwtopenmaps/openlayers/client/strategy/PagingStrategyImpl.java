package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class PagingStrategyImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Strategy.Paging();
    }-*/;

    public static native boolean activate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native boolean deactivate(JSObject self) /*-{
        return self.deactivate();
    }-*/;

    public static native int pageCount(JSObject self) /*-{
        return self.pageCount();
    }-*/;

    public static native int pageNum(JSObject self) /*-{
        return self.pageNum();
    }-*/;

    public static native int pageLength(JSObject self) /*-{
        return self.pageLength();
    }-*/;

    public static native int pageLength(JSObject self, int length) /*-{
        return self.pageLength(length);
    }-*/;

    public static native boolean pageNext(JSObject self) /*-{
        return self.pageNext();
    }-*/;

    public static native boolean pagePrevious(JSObject self) /*-{
        return self.pagePrevious();
    }-*/;
}
