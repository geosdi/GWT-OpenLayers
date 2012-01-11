package org.gwtopenmaps.openlayers.client.layer;

/**
 * @author Max Gensthaler
 */
public class GoogleV3Options extends EventPaneOptions {
	public void setType(GoogleV3MapType type) {
		getJSObject().setProperty("type", type.getNativeType());
	}

	public void setSphericalMercator(boolean value) {
		getJSObject().setProperty("sphericalMercator", value);
	}
}
