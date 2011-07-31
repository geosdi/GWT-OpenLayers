package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 * Base class representing a symbolizer used for feature rendering
 * 
 */
public class Symbolizer extends JSObjectWrapper {

	protected Symbolizer(JSObject jsObject) {
		super(jsObject);
	}
	
	public void setZIndex(int zIndex) {
		SymbolizerImpl.setZIndex(this.getJSObject(), zIndex);
	}

	/**
	 * Default is 0.
	 * @return
	 */
	public int getZIndex() {
		return SymbolizerImpl.getZIndex(this.getJSObject());
	}
}
