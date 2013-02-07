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

	/**
	 * If set, requests that would result in GET urls with more characters than the number provided will be made using form-encoded HTTP POST.
	 * It is good practice to avoid urls that are longer than 2048 characters.
	 * @param maxGetUrlLength The max length of an URL, otherwise a POST is used.
	 */
    public void setMaxGetUrlLength(int maxGetUrlLength)
    {
        setParameter("maxGetUrlLength", Integer.toString(maxGetUrlLength));
    }
}