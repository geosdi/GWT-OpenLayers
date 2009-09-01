/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.Measure.*;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class MeasureOptions extends ControlOptions{
	
	/**
     * APIProperty: persist
     * {Boolean} Keep the temporary measurement sketch drawn after the
     *     measurement is complete.  The geometry will persist until a new
     *     measurement is started, the control is deactivated, or <cancel> is
     *     called.
     */
	public void setPersist(boolean persist){
		getJSObject().setProperty("persist", persist);
	}
	public String getMeasure(){
		return getJSObject().getProperty("measure").toString();
	}
	public void Measure(MeasureListener listener){
		JSObject callback = MeasureImpl.createMeasureCallback(listener);
		getJSObject().setProperty("measure", callback);
	}
	public void Measure(MeasurePartialListener listener){
		JSObject callback = MeasureImpl.createMeasurePartialCallback(listener);
		getJSObject().setProperty("measurepartial", callback);
	}
}
