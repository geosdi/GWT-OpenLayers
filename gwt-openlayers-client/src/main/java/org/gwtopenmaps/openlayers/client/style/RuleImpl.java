package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.filter.Filter;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class RuleImpl {
	
	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Rule();
	}-*/;
	
	public native static JSObject create(JSObject options) /*-{
		return $wnd.OpenLayers.Rule(options);
	}-*/;
	
	public native static void setId(JSObject self, String id) /*-{
		self.id = id;
	}-*/;
	
	public native static String getId(JSObject self) /*-{
		return self.id;
	}-*/;
	
	public native static void setName(JSObject self, String name) /*-{
		self.name = name;
	}-*/;
	
	public native static void setTitle(JSObject self, String title) /*-{
		self.title = title;
	}-*/;
	
	public native static void setDescription(JSObject self, String description) /*-{
		self.description = description;
	}-*/;
	
	public native static void setContext(JSObject self, JSObject context) /*-{
		self.context = context;
	}-*/;
	
	public native static void setFilter(JSObject self, Filter filter) /*-{
		self.filter = filter;
	}-*/;
	
	public native static void setElseFilter(JSObject self, boolean elseFilter) /*-{
		self.elseFilter = elseFilter;
	}-*/;
	
	public native static void setSymbolizer(JSObject self, Symbolizer symbolizer) /*-{
		self.symbolizer = symbolizer;
	}-*/;
	
	public native static void setSymbolizer(JSObject self, JSObject hashSymbolizer) /*-{
		self.symbolizer = hashSymbolizer;
	}-*/;
	
	public native static void setSymbolizer(JSObject self, Symbolizer[] symbolizer) /*-{
		self.symbolizers = symbolizer;
	}-*/;
	
	public native static void setMinScaleDenominator(JSObject self, int scale) /*-{
		self.minScaleDenominator = scale;
	}-*/;
	
	public native static void setMaxScaleDenominator(JSObject self, int scale) /*-{
		self.maxScaleDenominator = scale;
	}-*/;
}
