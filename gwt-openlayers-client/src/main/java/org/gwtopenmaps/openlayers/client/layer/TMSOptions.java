package org.gwtopenmaps.openlayers.client.layer;

/**
 * @author Amr Alam - Refractions Research
 */
public class TMSOptions extends LayerOptions {

	public TMSOptions(String layername, String type) {
		// setting required options
		setLayername(layername);
		setType(type);
	}

	public void setServiceVersion(String serviceVersion) {
		getJSObject().setProperty("serviceVersion", serviceVersion);
	}

	public String getServiceVersion() {
		return getJSObject().getPropertyAsString("serviceVersion");
	}

	public void setLayername(String layername) {
		getJSObject().setProperty("layername", layername);
	}

	public String getLayername() {
		return getJSObject().getPropertyAsString("layername");
	}

	public void setType(String type) {
		getJSObject().setProperty("type", type);
	}

	public String getType() {
		return getJSObject().getPropertyAsString("type");
	}

}
