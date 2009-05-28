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

	public Popup(String id, LonLat lonlat, Size size, String html, boolean closeBox) {
		this(PopupImpl.create(id, 
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				closeBox));
	}

	public static Popup narrowToOpenLayersPopup(JSObject element) {
		return (element == null) ? null: new Popup(element);
	}

	public void addCloseListener(CloseListener callback) {
		PopupImpl.addCloseBox(this.getJSObject(), callback);
	}
}
