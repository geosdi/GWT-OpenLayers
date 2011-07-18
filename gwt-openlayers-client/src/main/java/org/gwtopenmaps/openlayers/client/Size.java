package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * OpenLayers BaseType representing a width/height pair.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 */
public class Size extends OpenLayersObjectWrapper {

	protected Size(JSObject size) {
		super(size);
	}

	public Size(int w, int h) {
		this(SizeImpl.create(w, h));
	}

	public static Size narrowToSize(JSObject size){
		return (size == null)?null:new Size(size);
	}

	public Size(float width, float height){
		this(SizeImpl.create(width, height));
	}

	public float getWidth(){
		return SizeImpl.getWidth(getJSObject());
	}

	public void setWidth(float width){
		SizeImpl.setWidth(getJSObject(), width);
	}

	public float getHeight(){
		return SizeImpl.getHeight(getJSObject());
	}

	public void setHeight(float height){
		SizeImpl.setHeight(getJSObject(), height);
	}

	/**
	 * Returns true when the size object argument has the same width and
	 * height as the size object, and false otherwise.
	 *
	 * @param size - see {@link Size}.
	 */
	public boolean equals(Size size){
		if(this == size){return true;}
		if(!this.getClassName().equals(size.getClassName())){
			return false;
		} else {
			return SizeImpl.equals(this.getJSObject(), size.getJSObject());
		}
	}

	/**
	 *
	 */
	public String toString(){
		return SizeImpl.toString(getJSObject());
	}

}
