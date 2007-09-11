package com.eg.gwt.openLayers.client;

/**
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
	
	public Bounds(double lllon, double lllat, double urlon, double urlat) {
		this (BoundsImpl.create(lllon, lllat, urlon, urlat));
	}
}
