package org.gwtopenmaps.openlayers.client.symbolizer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

public class Symbolizer extends JSObjectWrapper {

	protected Symbolizer(JSObject jsObject) {
		super(jsObject);
	}
	
	public Symbolizer(SymbolizerOptions options){
		this(SymbolizerImpl.create(options.getJSObject()));
	}
}
