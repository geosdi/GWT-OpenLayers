package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * In examples in OpenLayers 2.9 and below Style is use as a Symbolizer.
 *
 * Having a Symbolizer class seems a more appropriate solution, see also:
 * http://trac.openlayers.org/ticket/1845
 *
 * Currently, the methods to create a Symbolizer are implemented on the Style object.
 */
public class Symbolizer extends JSObjectWrapper {

	protected Symbolizer(JSObject jsObject) {
		super(jsObject);
	}

}
