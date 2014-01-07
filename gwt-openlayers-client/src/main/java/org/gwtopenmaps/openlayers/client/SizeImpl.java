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
 *
 */
class SizeImpl {

	public static native JSObject create(int w, int h)/*-{
		return new $wnd.OpenLayers.Size(w, h);
	}-*/;

	public static native JSObject create(float w, float h)/*-{
		return new $wnd.OpenLayers.Size(w, h);
	}-*/;

	public static native float getWidth(JSObject self)/*-{
		return self.w;
	}-*/;

	public static native void setWidth(JSObject self, float width)/*-{
		self.w = width;
	}-*/;

	public static native float getHeight(JSObject self)/*-{
		return self.h;
	}-*/;

	public static native void setHeight(JSObject self, float height)/*-{
		self.h = height;
	}-*/;

	//uses OL equals implementation
	public static native boolean equals(JSObject self, JSObject size)/*-{
		return self.equals(size);
	}-*/;

	public static native String toString(JSObject self)/*-{
		return self.toString();
	}-*/;
}
