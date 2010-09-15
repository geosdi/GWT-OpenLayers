package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Curtis Jensen
 *
 */
public class Framed extends Popup {

	protected Framed(JSObject element) {
		super(element);
	}

	/**
	 *
	 * Use addCloseListener to respond to popup close event.
	 *
	 * @param anchor - ...
	 *
	 * For explanation of other parameters see {@link Popup}.
	 */
	public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor, boolean closeBox) {
		this(FramedImpl.create(id,
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(),
				closeBox));
	}

	public Framed(String id, LonLat lonlat, Size size, String html, boolean closeBox) {
		this(FramedImpl.create(id,
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				null,
				closeBox));
	}

	public Framed(String id, LonLat lonlat, String html, boolean closeBox) {
		this(FramedImpl.create(id,
				lonlat.getJSObject(),
				null,
				html,
				null,
				closeBox));
	}
}
