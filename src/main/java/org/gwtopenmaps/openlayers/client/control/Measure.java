/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.handler.Handler;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class Measure extends Control {

	protected Measure(JSObject element) {
		super(element);
	}
	public Measure(Handler handler) {
		this(MeasureImpl.create(handler.getJSObject()));
	}
	public Measure(Handler handler, MeasureOptions options) {
		this(MeasureImpl.create(handler.getJSObject(),options.getJSObject()));
	}
    public void setPersist(boolean persist ){
    	MeasureImpl.setPersist(getJSObject(),persist);   	
    }
}
