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

import org.gwtopenmaps.openlayers.client.marker.Box;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
* @author Michel Vitor A Rodrigues
*/
public class BoxesImpl
{

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Boxes(name, options);
    }-*/;

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Boxes(name);
    }-*/;

    public static native void drawMarker(JSObject box, Box marker) /*-{
        box.drawMarker(marker);
    }-*/;

    public static native void removeMarker(JSObject box, Box marker) /*-{
        box.removeMarker(marker);
    }-*/;
}
