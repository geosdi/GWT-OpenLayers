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
public class MeasureImpl {

	public static native JSObject create(JSObject handler)/*-{
			return new $wnd.OpenLayers.Control.Measure(handler);
		}-*/;

	public static native JSObject create(JSObject handler, JSObject options)/*-{
			return new $wnd.OpenLayers.Control.Measure(handler, options);
		}-*/;

	public static native void setPersist(JSObject self, boolean persist)/*-{
		    self.persist = persist;
		}-*/;
	 /**
     * this function was to make communication with JavaScript, but precisely 
     * with the function and measure measurepartial and return units, etc. as measure 
     * this example: 
     * "measure": function (x) ( 
     *               var geometry = x.geometry; 
     *               var units = x.units; 
     *               var order = x.order; 
     *               var measure = x.measure; 
     *               var element = document.getElementById ( 'output'); 
     *               var out = ""; 
     *               if (order == 1) ( 
     *                   out + = "measure:" + x.measure.toFixed (3) + "" + units; 
     *               ) Else ( 
     *                   out + = "measure:" + x.measure.toFixed (3) + "" + units + "<sup> 2 </" + "sup>"; 
     *               ) 
     *                   element.innerHTML = out; 
     *               ),
     * 
     * */
	public static native JSObject createMeasureCallback(MeasureListener listener)/*-{
		    var callback = function(obj){
		      var objmeasure = @org.gwtopenmaps.openlayers.client.control.Measure::narrowToMeasure(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
			  listener.@org.gwtopenmaps.openlayers.client.control.Measure.MeasureListener::onMeasure(Ljava/lang/String;Ljava/lang/String;)(objmeasure.measure,objmeasure.units);
		    }
		    return callback;
	    }-*/;
	 /**
     * this function was to make communication with JavaScript, but precisely 
     * with the function and measure measurepartial and return units, etc. as measure 
     * this example: 
     * "measurepartial": function (x) ( 
     *               var geometry = x.geometry; 
     *               var units = x.units; 
     *               var order = x.order; 
     *               var measure = x.measure; 
     *               var element = document.getElementById ( 'output'); 
     *               var out = ""; 
     *               if (order == 1) ( 
     *                   out + = "measure:" + x.measure.toFixed (3) + "" + units; 
     *               ) Else ( 
     *                   out + = "measure:" + x.measure.toFixed (3) + "" + units + "<sup> 2 </" + "sup>"; 
     *               ) 
     *                   element.innerHTML = out; 
     *               ),
     * 
     * */
	public static native JSObject createMeasurePartialCallback(MeasurePartialListener listener)/*-{
	    var callback = function(obj){
	          var objmeasure = @org.gwtopenmaps.openlayers.client.control.Measure::narrowToMeasure(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
			  listener.@org.gwtopenmaps.openlayers.client.control.Measure.MeasurePartialListener::onMeasurePartial(Ljava/lang/String;Ljava/lang/String;)(objmeasure.measure,objmeasure.units);
	    }
	    return callback;
	}-*/;
}
