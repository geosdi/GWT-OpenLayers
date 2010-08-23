package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Size;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 * 
 */
public class GridLayerOptions extends HTTPRequestLayerOptions {

	public final void setTileSize(Size size) {
		getJSObject().setProperty("tileSize", size.getJSObject());
	}

	/**
	 * For tiled layers the buffer size can be set.
	 *
	 * The default buffer is 2.
	 */
	public void setBuffer(int buffer){
		getJSObject().setProperty("buffer", buffer);
	}

}