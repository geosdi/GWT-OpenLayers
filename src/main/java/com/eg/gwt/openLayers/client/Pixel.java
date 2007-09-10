package com.eg.gwt.openLayers.client;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Pixel extends OpenLayersWidget {

	protected Pixel(JSObject element) {
		super(element);
	}
	
	public static Pixel narrowToMap(JSObject element)
	{
		return (element == null)? null: new Pixel(element);
	}
	
	public Pixel(int x, int y) {
		this(PixelImpl.create(x, y));
	}

	public String toString() {
		return PixelImpl.toString(getJSObject());
	}
}
