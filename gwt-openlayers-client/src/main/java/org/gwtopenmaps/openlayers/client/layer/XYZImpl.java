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
 * JSNI wrapper to create and wrap access to the OpenLayers.Layer.XYZ JSObject
 * @author Andrew Hughes
 * @see XYZ
 * @see XYZOptions
 */
class XYZImpl
{

    public static native JSObject create(String name, String url, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.XYZ(name, url, options);
    }-*/;

    public static native JSObject create(String name, JSObject urls, JSObject layerParams)/*-{
        // JavaScript can loose the type of objects.
        // the Array that was created in JArrayBaseImpl is reported as an "object"
        // when the OpenLayers code checks for instanceof Array.  Converting the passed in urls Array to a new Array corrects this problem.
        // There may be a better way, until it is figured out, this is what is done.

        var tmsURLs = new $wnd.Array(urls.length);
            for (i = 0; i < urls.length; i++) {
              tmsURLs[i] = urls[i];
            }

            return new $wnd.OpenLayers.Layer.XYZ(name, tmsURLs, layerParams);
    }-*/;
    
	/**
	 * If your cache has more zoom levels than you want to provide access to with this layer, supply a zoomOffset. This
	 * zoom offset is added to the current map zoom level to determine the level for a requested tile. For example, if
	 * you supply a zoomOffset of 3, when the map is at the zoom 0, tiles will be requested from level 3 of your cache.
	 * Default is 0 (assumes cache level and map zoom are equivalent). Using zoomOffset is an alternative to setting
	 * serverResolutions if you only want to expose a subset of the server resolutions.
	 * @param layer layer
	 * @param zoomOffset zoom offset
	 */
   public static native void setZoomOffset(JSObject layer, int zoomOffset) /*-{
	    layer["zoomOffset"] = zoomOffset;
	}-*/;
}
