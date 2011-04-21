package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerRaster extends Symbolizer{

	public SymbolizerRaster(JSObject config) {
		super(SymbolizerRasterImpl.create(config));
	}
	
	public SymbolizerRaster() {
		super(SymbolizerRasterImpl.create());
	}

}
