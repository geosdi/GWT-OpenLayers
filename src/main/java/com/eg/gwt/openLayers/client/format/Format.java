/**
 *
 */
package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * Format objects provide support for reading and writing formats that are
 * relevant for OpenLayers.
 *
 * //TODO improve explanation
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Format extends OpenLayersWidget {

	protected Format(JSObject element) {
		super(element);
	}

	//Formats have a read and write method
	// The read method takes a specific Format as input
	// The write method takes a VectorFeature

}
