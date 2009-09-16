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

	public interface MeasureListener{
	    void onMeasure(String measurements,String units); 
	}
	public interface MeasurePartialListener{
	    void onMeasurePartial(String measurements,String units); 
	}	
	protected Measure(JSObject element) {
		super(element);
	}
	public static Measure narrowToMeasure(JSObject element)
	{
		return (element == null)?null:new Measure(element);
	}	
	public Measure(Handler handler) {
		this(MeasureImpl.create(handler.getJSObject()));
	}
	public Measure(Handler handler, MeasureOptions options) {
		this(MeasureImpl.create(handler.getJSObject(),options.getJSObject()));
	}
	public void setPersist(boolean persist){
		MeasureImpl.setPersist(getJSObject(), persist);		
	}
}
