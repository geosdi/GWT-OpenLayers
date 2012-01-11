package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * A layer to show a Google map using the <a href=
 * "http://code.google.com/intl/de-DE/apis/maps/documentation/javascript/"
 * >Google Maps JavaScript API V3</a>.
 *
 * Tested with Google API loading from
 * <code>&lt;script src="http://maps.google.com/maps/api/js?gwt=1&amp;v=3.6&amp;sensor=false"&gt;&lt;/script&gt;</code>
 *
 * @author Max Gensthaler
 */
public class GoogleV3 extends Layer {
	// In OpenLayers this class inherits from both EventPane and FixedZoomLevels

	protected GoogleV3(JSObject element) {
		super(element);
	}

	public GoogleV3 narrowToGoogle(JSObject google) {
		return (google == null) ? null : new GoogleV3(google);
	}

	public GoogleV3(String name) {
		this(GoogleV3Impl.create(name));
	}

	public GoogleV3(String name, GoogleV3Options options) {
		this(GoogleV3Impl.create(name, options.getJSObject()));
	}

	public LonLat forwardMercator(double lon, double lat) {
		return LonLat.narrowToLonLat(GoogleV3Impl.forwardMercator(getJSObject(), lon, lat));
	}
}
