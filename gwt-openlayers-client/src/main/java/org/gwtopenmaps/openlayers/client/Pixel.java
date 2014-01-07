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
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 *
 */
public class Pixel extends OpenLayersObjectWrapper {

	protected Pixel(JSObject element) {
		super(element);
	}

	public static Pixel narrowToPixel(JSObject element)
	{
		return (element == null)? null: new Pixel(element);
	}

	public Pixel(int x, int y) {
		this(PixelImpl.create(x, y));
	}
	
	public Pixel(float x, float y) {
		this(PixelImpl.create(x, y));
	}
	public int x() {
		return PixelImpl.getX(this.getJSObject());
	}
	
	public int y() {
		return PixelImpl.getY(this.getJSObject());
	}
	
	public String toString() {
		return PixelImpl.toString(getJSObject());
	}
}
