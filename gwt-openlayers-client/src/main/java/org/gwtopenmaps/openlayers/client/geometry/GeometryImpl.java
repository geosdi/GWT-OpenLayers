package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import com.google.gwt.core.client.JsArray;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author prsebastian
 *
 */
public class GeometryImpl
{

    public static native void destroy(JSObject self) /*-{
        self.destroy();
    }-*/;

    public static native JSObject getBounds(JSObject self) /*-{
        return self.getBounds();
    }-*/;

    public static native String toString(JSObject self) /*-{
        return self.toString();
    }-*/;

    public static native JSObject fromWKT(String wkt) /*-{
        return $wnd.OpenLayers.Geometry.fromWKT(wkt);
    }-*/;

    public static native JSObject clone(JSObject self) /*-{
        return self.clone();
    }-*/;

    public static native void calculateBounds(JSObject self) /*-{
        self.calculateBounds();
    }-*/;
    
    public static native void setBounds(JSObject self, JSObject bounds) /*-{
    	self.setBounds(bounds);
	}-*/;
    
    public static native void clearBounds(JSObject self) /*-{
		self.clearBounds();
	}-*/;
    
    public static native void extendBounds(JSObject self, JSObject bounds) /*-{
		self.extendBounds(bounds);
	}-*/;
    
    public static native JSObject distanceTo(JSObject self, JSObject geometry, JSObject options) /*-{

		 //
	     // Geometry.distanceTo() may return only a Number or a complex distance object
	     // to cover both cases, a primitive Number is wrapped and returned as complex object too
	     //

		var dist = self.distanceTo(geometry, options);
		
		if (isNaN(dist))
		{ 
			return dist;
		}
		else
		{
			function distObject()
			{
				this.distance = dist;
			}
			return new distObject();
		}
	}-*/;
    
    public static native JsArray<JSObject> getVertices(JSObject self, boolean nodes) /*-{
		return self.getVertices(nodes);
	}-*/;
    
    public static native boolean atPoint(JSObject self, JSObject lonlat, double toleranceLon, double toleranceLat) /*-{
		return self.atPoint(lonlat, toleranceLon, toleranceLat);
	}-*/;
    
    public static native void transform(JSObject self, JSObject source, JSObject dest) /*-{
    	self.transform(source, dest);
	}-*/;
}
