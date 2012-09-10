package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Jon Britton, SpiffyMap Ltd.
 */
class BoundsImpl {

	public static native JSObject create(double lllon, double lllat, double urlon, double urlat)/*-{
		return new $wnd.OpenLayers.Bounds(lllon, lllat, urlon, urlat);
	}-*/;
    
    public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Bounds();
	}-*/;

	public static native JSObject toArray(JSObject bounds)/*-{
		return bounds.toArray();
	}-*/;

	public static native double getMinX(JSObject bounds)/*-{
		return bounds.left;
	}-*/;

	public static native double getMinY(JSObject bounds)/*-{
		return bounds.bottom;
	}-*/;

	public static native double getMaxX(JSObject bounds)/*-{
		return bounds.right;
	}-*/;

	public static native double getMaxY(JSObject bounds)/*-{
		return bounds.top;
	}-*/;

	public static native String toBBox(JSObject bounds, Integer significantDigits)/*-{
		return bounds.toBBOX(significantDigits);
	}-*/;

	public static native String toString(JSObject bounds)/*-{
		return bounds.toString();
	}-*/;

	public static native JSObject getCenterLonLat(JSObject bounds)/*-{
    	return bounds.getCenterLonLat();
    }-*/;
    
    public static native JSObject getCenterPixel(JSObject bounds)/*-{
    	return bounds.getCenterPixel();
    }-*/;

	public static native JSObject toGeometry(JSObject bounds)/*-{
	   return bounds.toGeometry();
    }-*/;
	
	public static native boolean containsBounds(JSObject bounds, JSObject in_bounds, boolean partial, boolean contains)/*-{
		return bounds.containsBounds(in_bounds, partial, contains);
	}-*/;

	public static native float getWidth(JSObject bounds)/*-{
		return bounds.getWidth();
	}-*/;
   
	public static native float getHeight(JSObject bounds)/*-{
		return bounds.getHeight();
	}-*/;
	
	public static native void extend(JSObject bounds, JSObject extension)/*-{
		bounds.extend(extension);
	}-*/;
	public native static JSObject transform(JSObject self, JSObject source, JSObject dest)/*-{
		return self.transform(source, dest);
	}-*/;

    public static native boolean containsLonLat(JSObject bounds, JSObject ll, boolean inclusive)/*-{
        return bounds.containsLonLat(ll, inclusive);
    }-*/;

    public static native JSObject getSize(JSObject bounds)/*-{
        return bounds.getSize();
    }-*/;
    
    public static native JSObject scale(JSObject bounds, float ratio, JSObject origin)/*-{
        return bounds.scale(ratio, origin);
    }-*/;
    
    public static native JSObject add(JSObject bounds, float x, float y)/*-{
        return bounds.add(x, y);
    }-*/;
    
    public static native boolean intersectsBounds(JSObject bounds, JSObject otherBounds)/*-{
        return bounds.intersectsBounds(otherBounds);
    }-*/;

}
