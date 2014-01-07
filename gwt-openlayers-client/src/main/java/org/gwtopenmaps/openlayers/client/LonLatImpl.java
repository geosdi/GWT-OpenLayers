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
class LonLatImpl {

	public static native JSObject create(double lon, double lat)/*-{
    	return new $wnd.OpenLayers.LonLat(lon, lat);
    }-*/;
	
	public static native double lon(JSObject self)/*-{
		return self.lon;
	}-*/;
	
	public static native double lat(JSObject self)/*-{
		return self.lat;
	}-*/;

	public static native void transform(JSObject self, String src, String dst)/*-{
		self.transform(new $wnd.OpenLayers.Projection(src), new $wnd.OpenLayers.Projection(dst));
	}-*/;

}
