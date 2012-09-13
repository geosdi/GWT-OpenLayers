package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.Projection;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author prsebastian
 *
 */
public class Geometry extends OpenLayersObjectWrapper
{

    public static final String LINEARRING_CLASS_NAME = "OpenLayers.Geometry.LinearRing";
    public static final String LINESTRING_CLASS_NAME = "OpenLayers.Geometry.LineString";
    public static final String POINT_CLASS_NAME = "OpenLayers.Geometry.Point";
    public static final String POLYGON_CLASS_NAME = "OpenLayers.Geometry.Polygon";
    public static final String MULTI_POLYGON_CLASS_NAME = "OpenLayers.Geometry.MultiPolygon";
    public static final String MULTI_LINE_STRING_CLASS_NAME = "OpenLayers.Geometry.MultiLineString";
    // TODO more class names
    
    /**
     * The distance between this geometry and the target. 
     * If details is true, the return will be an object with distance, x0, y0, x1, and x2 properties.
     * The x0 and y0 properties represent the coordinates of the closest point on this geometry.
     * The x1 and y1 properties represent the coordinates of the closest point on the target geometry.
     */
    public interface Distance {
    	/**
    	 * @return The distance between this geometry and the target.
    	 */
    	public double getDistance();
		/**
		 * @return x coordinate of the closest point on this geometry. <code>null</code> if 
		 * no details available.
		 */
		public Double getX0();
		/**
		 * @return y coordinate of the closest point on this geometry. <code>null</code> if 
		 * no details available.
		 */
		public Double getY0();
		/**
		 * @return x coordinate of the closest point on the target geometry. <code>null</code> if 
		 * no details available.
		 */
		public Double getX1();
		/**
		 * @return y coordinate of the closest point on the target geometry. <code>null</code> if 
		 * no details available.
		 */
		public Double getY1();
    }
    
    private class DistanceImpl implements Distance {
    	
    	private double distance;
    	private Double x0 = null;
    	private Double y0 = null;
    	private Double x1 = null;
    	private Double y1 = null;

    	public DistanceImpl(double distance) {
    		this.distance = distance;
		}
    	
    	public double getDistance() {
			return distance;
		}
    	public Double getX0() {
			return x0;
		}
		public void setX0(Double x0) {
			this.x0 = x0;
		}
		public Double getY0() {
			return y0;
		}
		public void setY0(Double y0) {
			this.y0 = y0;
		}
		public Double getX1() {
			return x1;
		}
		public void setX1(Double x1) {
			this.x1 = x1;
		}
		public Double getY1() {
			return y1;
		}
		public void setY1(Double y1) {
			this.y1 = y1;
		}
    }

    public static Geometry narrowToGeometry(JSObject element)
    {
        return (element == null) ? null : new Geometry(element);
    }

    public static Geometry fromWKT(String wkt)
    {
        return narrowToGeometry(GeometryImpl.fromWKT(wkt));
    }

    protected Geometry(JSObject element)
    {
        super(element);
    }

    public void destroy()
    {
        GeometryImpl.destroy(getJSObject());
    }

    public Bounds getBounds()
    {
        return Bounds.narrowToBounds(GeometryImpl.getBounds(this.getJSObject()));
    }

    public String toString()
    {
        return GeometryImpl.toString(this.getJSObject());
    }

    public Geometry clone()
    {
        return narrowToGeometry(GeometryImpl.clone(this.getJSObject()));
    }

    /**
     * Recalculate the bounds for the geometry.
     *
     */
    public void calculateBounds()
    {
        GeometryImpl.calculateBounds(getJSObject());
    }

    public double getArea()
    {
        return 0;
    }

    public double getLength()
    {
        return 0.0;
    }
    
    /**
     * Set the bounds for this Geometry.
     */
    public void setBounds(Bounds bounds)
    {
    	GeometryImpl.setBounds(getJSObject(), bounds.getJSObject());
    }
    
    /**
     * Nullify this components bounds and that of its parent as well.
     */
    public void clearBounds()
    {
    	GeometryImpl.clearBounds(getJSObject());
    }
    
    /**
     * Extend the existing bounds to include the new bounds. 
     * If geometry’s bounds is not yet set, then set a new Bounds.
     */
    public void extendBounds(Bounds newBounds)
    {
    	GeometryImpl.extendBounds(getJSObject(), newBounds.getJSObject());
    }
    
    /**
     * Calculate the closest distance between two geometries (on the x-y plane).
     * @param geometry The target geometry.
     * @param options Optional properties for configuring the distance calculation.
     * @return  The distance between this geometry and the target.
     * If details is true, the return will be an object with distance, x0, y0, x1, and x2 properties.
     * The x0 and y0 properties represent the coordinates of the closest point on this geometry.
     * The x1 and y1 properties represent the coordinates of the closest point on the target geometry.
     */
    public Distance distanceTo(Geometry geometry, JSObject options)
    {
    	JSObject distanceJSObject = GeometryImpl.distanceTo(getJSObject(), geometry.getJSObject(), options);
    	
    	DistanceImpl distance = new DistanceImpl(distanceJSObject.getPropertyAsDouble("distance"));
    	
    	if (distanceJSObject.hasProperty("x0")) 
    	{
    		distance.setX0(distanceJSObject.getPropertyAsDouble("x0"));
    	}
    	
    	if (distanceJSObject.hasProperty("y0")) 
    	{
    		distance.setY0(distanceJSObject.getPropertyAsDouble("y0"));
    	}

    	if (distanceJSObject.hasProperty("x1")) 
    	{
    		distance.setX1(distanceJSObject.getPropertyAsDouble("x1"));
    	}
    	
    	if (distanceJSObject.hasProperty("y1")) 
    	{
    		distance.setY1(distanceJSObject.getPropertyAsDouble("y1"));
    	}
    	
    	return distance;
    }
    
    /**
     * Return a list of all points in this geometry.
     * @param nodes For lines, only return vertices that are endpoints.
     * 	If false, for lines, only vertices that are not endpoints will be returned. 
     * 	If not provided, all vertices will be returned.
     * @return A list of all vertices in the geometry.
     */
      public Point[] getVertices(boolean nodes)
	  {
		JsArray<JSObject> vertices = GeometryImpl.getVertices(getJSObject(), nodes);

	  	Point[] points = new Point[vertices.length()];
	  	
	  	for (int i = 0; i < vertices.length(); i++) {
			
	  		points[i] = new Point(vertices.get(i));
		}  
		
	  	return points;
	  }
    
  
    /**
     * This is only an approximation based on the bounds of the geometry.
     * @param lonlat
     * @param toleranceLon tolerance in Geometric Coords
     * @param toleranceLat tolerance in Geographic Coords
     * @return Whether or not the geometry is at the specified location
     */
    public boolean atPoint(LonLat lonlat, double toleranceLon, double toleranceLat)
    {
    	return GeometryImpl.atPoint(getJSObject(), lonlat.getJSObject(), toleranceLon, toleranceLat);
    }
    

    /**
     * Calculate the centroid of this geometry. This method is defined in subclasses.
     * @return The centroid of the collection
     */
    public Point getCentroid()
    {
    	return new Point(0,0);
    }
    
    
    /**
     * Translate the x,y properties of the geometry from source to dest.
     *
     * @param source
     * @param dest
     */
    public void transform(Projection source, Projection dest)
    {
    	
        GeometryImpl.transform(getJSObject(), source.getJSObject(), dest.getJSObject());
    }

    
}
