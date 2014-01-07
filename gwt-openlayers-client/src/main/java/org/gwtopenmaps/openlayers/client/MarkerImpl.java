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
 * @author Erdem Gunay
 * @author Michel Vitor - Intec
 * @author Sandor Forrai
 */
class MarkerImpl {


	public static native JSObject create(JSObject lonlat)/*-{
        return new $wnd.OpenLayers.Marker(lonlat);
    }-*/;

	public static native void setIcon(JSObject self, JSObject icon)/*-{
        self.icon = icon;
        self.events = new $wnd.OpenLayers.Events(self, self.icon.imageDiv, null);
    }-*/;

	public static native void setLonLat(JSObject self, JSObject lonlat)/*-{
        self.lonlat = lonlat;
    }-*/;

	public static native JSObject create(JSObject lonlat, JSObject icon)/*-{
        return new $wnd.OpenLayers.Marker(lonlat, icon);
    }-*/;

	public static native JSObject getLonLat(JSObject self)/*-{
        return self.lonlat;
    }-*/;

	public static native void setImageUrl(JSObject self, String imageUrl)/*-{
        self.icon.url = imageUrl;
    }-*/;

	public static native JSObject getIcon(JSObject self)/*-{
        return self.icon;
    }-*/;

	public static native void moveTo(JSObject self, JSObject where)/*-{
        self.moveTo(where);
    }-*/;
}

