package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.Map;

/**
 * See {@link MousePosition}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4
 *
 */
public abstract class MousePositionOutput {

	/**
	 * A MousePositionOutput instance that implements this function can
	 * be used to set the output format on a {@link MousePosition} control.
	 *
	 * Output sanitization is performed on the String returned. Only a limited
	 * set of characters and html tags are on the whitelist.
	 *
	 * refer to whitelist here...
	 * whitelisted tags: b em bto
	 * whitelisted characters: a-z A-Z 0-9 ' , " ; . : \u00B0
	 *
	 * @param lonLat - a {@link com.eg.gwt.openLayers.client.LonLat} with the longitude/latitude at the mouse position
	 * @param map - the {@link com.eg.gwt.openLayers.client.Map} to which the control has been added.
	 * @return String - the output that is shown by the MousePosition control
	 */
	public abstract String format(LonLat lonLat, Map map);

}
