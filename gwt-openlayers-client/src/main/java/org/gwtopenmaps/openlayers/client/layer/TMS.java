package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMS extends GridLayer {

	protected TMS(JSObject element) {
		super(element);
	}

	public TMS(String name, String url, TMSOptions options) {
		this(TMSImpl.create(name, url, options.getJSObject()));
	}

	public TMS(String name, String[] urls, TMSOptions options) {
		this(TMSImpl.create(name, new JStringArray(urls).getJSObject(), options.getJSObject()));
	}

	public int getNumLoadingTiles(){
		return TMSImpl.getNumLoadingTiles(getJSObject());
	}
}
