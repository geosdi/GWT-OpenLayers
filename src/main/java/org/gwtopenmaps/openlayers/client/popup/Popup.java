package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 *
 */
public class Popup extends OpenLayersObjectWrapper {

	public interface CloseListener {
		void onPopupClose(JSObject evt);
	}

	protected Popup(JSObject element) {
		super(element);
	}

	/**
	 *
	 * Use addCloseListener to respond to popup close event.
	 *
	 * @param id - String identifier for Popup. Used by ..?..
	 * @param lonlat - {@link org.gwtopenmaps.openlayers.client.LonLat} where Popup should appear
	 * @param size - {@link org.gwtopenmaps.openlayers.client.Size} that provides height and width for Popup
	 * @param html - String with html content to appear in Popup
	 * @param closeBox - Set to true to get close button in upper right corner of Popup
	 */
	public Popup(String id, LonLat lonlat, Size size, String html, boolean closeBox) {
		this(PopupImpl.create(id,
				lonlat.getJSObject(),
				(size!=null)?size.getJSObject():null,
				html,
				closeBox));
	}

	public static Popup narrowToOpenLayersPopup(JSObject element) {
		return (element == null) ? null: new Popup(element);
	}

	public void addCloseListener(CloseListener callback) {
		PopupImpl.addCloseListener(this.getJSObject(), callback);
	}
}
