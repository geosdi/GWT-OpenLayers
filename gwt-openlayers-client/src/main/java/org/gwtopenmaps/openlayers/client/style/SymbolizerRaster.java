package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 * A symbolizer used to render text labels for features.
 */
public class SymbolizerRaster extends Symbolizer{

	public SymbolizerRaster(JSObject config) {
		super(SymbolizerRasterImpl.create(config));
	}
	
	public SymbolizerRaster() {
		super(SymbolizerRasterImpl.create());
	}

}
