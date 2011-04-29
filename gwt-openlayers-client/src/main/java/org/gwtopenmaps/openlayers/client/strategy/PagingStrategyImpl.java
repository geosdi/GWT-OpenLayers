package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class PagingStrategyImpl {

	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Strategy.Paging();
	}-*/;

	public native static boolean activate(JSObject self) /*-{
		return self.activate();
	}-*/;
	
	public native static boolean deactivate(JSObject self) /*-{
		return self.deactivate();
	}-*/;
	
	public native static int pageCount(JSObject self) /*-{
		return self.pageCount();
	}-*/;
	
	public native static int pageNum(JSObject self) /*-{
		return self.pageNum();
	}-*/;
	
	public native static int pageLength(JSObject self) /*-{
		return self.pageLength();
	}-*/;
	
	public native static int pageLength(JSObject self, int length) /*-{
		return self.pageLength(length);
	}-*/;
	
	public native static boolean pageNext(JSObject self) /*-{
		return self.pageNext();
	}-*/;
	
	public native static boolean pagePrevious(JSObject self) /*-{
		return self.pagePrevious();
	}-*/;	
}
