package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
public class FramedCloud extends Popup {

	protected FramedCloud(JSObject element) {
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
	public FramedCloud(
			String id,
			LonLat lonlat,
			Size size,
			String html,
			OpenLayersObjectWrapper anchor,
			boolean closeBox) {

		this(FramedCloudImpl.create(
				id,
				lonlat.getJSObject(),
				(size != null) ? size.getJSObject() : null,
				html,
				(anchor != null) ? anchor.getJSObject(): null,
				closeBox));
	}

	//TODO: Fix that GWT widgets can be used inside popup
	/*
	public FramedCloud(
			String id,
			LonLat lonlat,
			Size size,
			Widget html,
			OpenLayersObjectWrapper anchor,
			boolean closeBox,
			PopupCloseListener callback) {

		this();
	}*/
}
