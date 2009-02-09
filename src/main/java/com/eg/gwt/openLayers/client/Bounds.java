package com.eg.gwt.openLayers.client;

/**
 * Represents a bounding box (or bounding rectangle).
 *
 * @author Erdem Gunay
 *
 */
public class Bounds extends OpenLayersWidget {

	protected Bounds(JSObject element) {
		super(element);
	}

	public static Bounds narrowToBounds(JSObject element)
	{
		return (element == null)?null:new Bounds(element);
	}

	/**
	 * Create a bounding box from longitudes and latitudes
	 * that delimit it.
	 *
	 * Although bounds are said to be specified in longitude/latitude. The actual
	 * units in which the bounds are specified will depend on the projection.
	 *
	 * For example for EPSG:4392
	 *
	 * @param lowerLeftLongitude = west  = minx
	 * @param lowerLeftLatitude = south = miny
	 * @param upperRightLongitude = east  = maxx
	 * @param upperRightLatitude = north = maxy
	 */
	public Bounds(double lowerLeftLongitude,
			double lowerLeftLatitude,
			double upperRightLongitude,
			double upperRightLatitude) {
		this (BoundsImpl.create(lowerLeftLongitude,
				lowerLeftLatitude,
				upperRightLongitude,
				upperRightLatitude));
	}
}
