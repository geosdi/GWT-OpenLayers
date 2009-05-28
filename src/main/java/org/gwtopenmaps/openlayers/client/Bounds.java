package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.util.JDoubleArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Represents a bounding box (or bounding rectangle).
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 * @author Edwin Commandeur
 */
public class Bounds extends OpenLayersObjectWrapper {

	protected Bounds(JSObject element) {
		super(element);
	}

	public static Bounds narrowToBounds(JSObject element)
	{
		return (element == null)?null:new Bounds(element);
	}

	/**
	 * Create a bounding box by specifying its lower left coordinates,
	 * and its upper right coordinates.
	 *
	 * The units of the bounding box will depend on the CRS and or projection used.
	 *
	 * For example, a bounds object that represents the world-wide bounds
	 * in EPSG:4392 is specified as:
	 *  new Bounds(-180,-90,180,90);
	 *
	 * @param lowerLeftX = west  = minx
	 * @param lowerLeftY = south = miny
	 * @param upperRightX = east  = maxx
	 * @param upperRightY = north = maxy
	 */
	public Bounds(double lowerLeftX,
			double lowerLeftY,
			double upperRightX,
			double upperRightY) {
		this (BoundsImpl.create(lowerLeftX,
				lowerLeftY,
				upperRightX,
				upperRightY));
	}

	public double[] toArray(){
		JSObject boundsOpaque = BoundsImpl.toArray(getJSObject());
		JDoubleArray bounds = JDoubleArray.narrowToJDoubleArray(boundsOpaque);
		int boundsLength = bounds.length();
		double[] boundsCoordinates = new double[4];
		if(boundsLength == 4){
			for(int i = 0; i < boundsLength;i++){
				boundsCoordinates[i] = bounds.get(i);
			}
		}
		return boundsCoordinates;
	}

	/**
	 * @return double - lower left x-coordinate of bounds
	 */
	public double getLowerLeftX(){
		return BoundsImpl.getMinX(getJSObject());
	}

	/**
	 * @return double - lower left y-coordinate of bounds
	 */
	public double getLowerLeftY(){
		return BoundsImpl.getMinY(getJSObject());
	}

	/**
	 * @return double - upper right x-coordinate of bounds
	 */
	public double getUpperRightX(){
		return BoundsImpl.getMaxX(getJSObject());
	}

	/**
	 * @return double - upper right y-coordinate of bounds
	 */
	public double getUpperRightY(){
		return BoundsImpl.getMaxY(getJSObject());
	}

	/**
	 * @param significantDigits - Number of significant digits in the bbox coordinates,
	 *  	pass null to use the default of 6.
	 * @return String - simple string representation of a Bounds object. For example:
	 *  	"5,42,10,45"
	 */
	public String toBBox(Integer significantDigits){
		return BoundsImpl.toBBox(getJSObject(), significantDigits);
	}

	public String toString(){
		return BoundsImpl.toString(getJSObject());
	}

	public LonLat getCenterLonLat() {
		return LonLat.narrowToLonLat(BoundsImpl.getCenterLonLat(this.getJSObject()));
	}

	public Geometry toGeometry() {
		return Geometry.narrowToGeometry(BoundsImpl.toGeometry(this.getJSObject()));
	}
}
