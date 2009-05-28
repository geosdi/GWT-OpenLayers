package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.OpenLayersObjectWrapper;
import com.eg.gwt.openLayers.client.Size;
import com.eg.gwt.openLayers.client.util.JSObject;

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
