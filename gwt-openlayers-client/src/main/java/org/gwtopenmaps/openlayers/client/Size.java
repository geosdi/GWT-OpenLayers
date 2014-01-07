/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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
