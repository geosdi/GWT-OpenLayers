package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * OpenLayers BaseType representing a width/height pair.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 * @since GWT-OL 0.2, OL ...
 */
//TODO Is Size used for non integer sizes?
// if not, this class needs to be adjusted
public class Size extends OpenLayersObjectWrapper {

	protected Size(JSObject size) {
		super(size);
	}

	public Size(int w, int h) {
		this(SizeImpl.create(w, h));
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public static Size narrowToSize(JSObject size){
		return (size == null)?null:new Size(size);
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public Size(float width, float height){
		this(SizeImpl.create(width, height));
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public float getWidth(){
		return SizeImpl.getWidth(getJSObject());
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public void setWidth(float width){
		SizeImpl.setWidth(getJSObject(), width);
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public float getHeight(){
		return SizeImpl.getHeight(getJSObject());
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public void setHeight(float height){
		SizeImpl.setHeight(getJSObject(), height);
	}

	/**
	 * Returns true when the size argument has the same width and
	 * height as this size.
	 *
	 * @param size - see {@link Size}.
	 * @since GWT-OL 0.4
	 */
	public boolean equals(Size size){
		return SizeImpl.equals(getJSObject(), size.getJSObject());
	}

	/**
	 * @since GWT-OL 0.4
	 */
	public String toString(){
		return SizeImpl.toString(getJSObject());
	}

}
