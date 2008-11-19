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
	 * that delimiting it. 
	 * 
	 * @param lllon - lower left longitude  = west  = minx
	 * @param lllat - lower left latitude   = south = miny 
	 * @param urlon - upper right longitude = east  = maxx
	 * @param urlat - upper right latitude  = north = maxy
	 */
	public Bounds(double lllon, double lllat, double urlon, double urlat) {
		this (BoundsImpl.create(lllon, lllat, urlon, urlat));
	}
}
