package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMSOptions extends LayerOptions {

	public TMSOptions() {
	}

	public void setLayers(String layers) {
		getJSObject().setProperty("layers", layers);
	}

	public String getLayers() {
		return getJSObject().getPropertyAsString("layers");
	}

	public void setStyles(String styles) {
		getJSObject().setProperty("styles", styles);
	}
	public String getStyles() {
		return getJSObject().getPropertyAsString("styles");
	}

	public void setFormat(String styles) {
		getJSObject().setProperty("format", styles);
	}
	public String getFormat() {
		return getJSObject().getPropertyAsString("format");
	}

	public void setMaxExtent(Bounds bounds) {
		getJSObject().setProperty("maxExtent", bounds.getJSObject());
	}
	public Bounds getMaxExtent() {
		return Bounds.narrowToBounds(getJSObject().getProperty("maxExtent"));
	}
}
