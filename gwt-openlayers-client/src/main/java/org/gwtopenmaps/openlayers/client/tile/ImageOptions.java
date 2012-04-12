package org.gwtopenmaps.openlayers.client.tile;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Niels Meijer
 * 
 */
public class ImageOptions extends TileOptions {

	protected ImageOptions(JSObject jsObject) {
		super(jsObject);
	}

	public ImageOptions() {
		this(JSObject.createJSObject());
	}

	public int getMaxGetUrlLength() {
		return getJSObject().getPropertyAsInt("maxGetUrlLength");
	}

	/**
	 * If set, requests that would result in GET urls with more characters than
	 * the number provided will be made using form-encoded HTTP POST.
	 * 
	 * @param value
	 *            maxGetUrlLength
	 */
	public void setMaxGetUrlLength(int value) {
		getJSObject().setProperty("maxGetUrlLength", value);
	}

}
