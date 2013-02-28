/**
 *
 *   Copyright 2013 sourceforge.
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
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 * Wrapper for OpenLayers.Layer.XYZ which is typically used to
 * add an ESRI Cached Map Service.
 *
 * @see XYZOptions
 * @author Andrew Hughes
 */
public class XYZ extends GridLayer {

    protected XYZ(JSObject xyzLayer) {
        super(xyzLayer);
    }

    /**
     * Constructor with specified options.
     * @param name the layer name
     * @param url example http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Portland/ESRI_LandBase_WebMercator/MapServer/tile/${z}/${y}/${x}
     * @param options constructor options
     */
    public XYZ(String name, String url, XYZOptions options) {
        this(XYZImpl.create(name, url, options.getJSObject()));
    }

    /**
     * Constructor with specified options.
     * @param name the layer name
     * @param urls urls in the form <code>http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Portland/ESRI_LandBase_WebMercator/MapServer/tile/${z}/${y}/${x}</code>
     * @param options constructor options
     */
    public XYZ(String name, String[] urls, XYZOptions options)
    {
            this(XYZImpl.create(name, new JStringArray(urls).getJSObject(), options.getJSObject()));
    }

    public XYZ narrowToXYZ(JSObject xyzLayer) {
        return (xyzLayer == null) ? null : new XYZ(xyzLayer);
    }
}
