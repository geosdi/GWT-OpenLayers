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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class MarkersImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Markers(name);
    }-*/;

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Markers(name, options);
    }-*/;

    public static native void addMarker(JSObject markers, JSObject marker) /*-{
        markers.addMarker(marker);
    }-*/;

    public static native void removeMarker(JSObject markers, JSObject marker) /*-{
        markers.removeMarker(marker);
    }-*/;

    public static native void clearMarkers(JSObject markers) /*-{
        markers.clearMarkers();
    }-*/;

    public static native JSObject getDataExtent(JSObject markers) /*-{
        return markers.getDataExtent();
    }-*/;

    public static native void destroy(JSObject markers) /*-{
        markers.destroy();
    }-*/;
}
