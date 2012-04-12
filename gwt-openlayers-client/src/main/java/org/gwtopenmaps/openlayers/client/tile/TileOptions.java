package org.gwtopenmaps.openlayers.client.tile;

import org.gwtopenmaps.openlayers.client.layer.Params;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Niels Meijer
 * 
 */
public class TileOptions extends Params {

	protected TileOptions(JSObject jsObject) {
		super(jsObject);
	}

	public TileOptions() {
		this(JSObject.createJSObject());
	}

	

}
