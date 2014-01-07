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
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 * Wrapper for OpenLayers.Layer.XYZ which is typically used to
 * add an ESRI Cached Map Service.
 *
 * @see XYZOptions
 * @author Andrew Hughes
 */
public class XYZ extends GridLayer {

	private static final double dEarthRadius = 6378137;
	
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

	/**
	 * Determines the ground resolution (in meters per pixel) at a specified latitude and level of detail.
	 * @param latitude latitude
	 * @param zoomLevel zoomlevel
	 * @return ground resolution
	 */
	private static double getGroundResolutionInMeters(double latitude, int zoomLevel)
	{
		return Math.cos(latitude * Math.PI / 180) * 2 * Math.PI * dEarthRadius / getMapSizeInPixels(zoomLevel);
	}

	/**
	 * Determines the map width and height (in pixels) at a specified level of detail.
	 * @param zoomLevel Level of detail, from 1 (lowest detail) to 23 (highest detail).
	 * @return The map width and height in pixels.
	 */
	private static double getMapSizeInPixels(int zoomLevel)
	{
		return ((double) (1 << zoomLevel)) * 256;
	}

    public XYZ narrowToXYZ(JSObject xyzLayer) {
        return (xyzLayer == null) ? null : new XYZ(xyzLayer);
    }
    
	/**
	 * Sets a range of zoomlevels.
	 * @param minZoomLevel minimum zoomlevel
	 * @param maxZoomLevel maximum zoomlevel
	 */
	public void setZoomLevelRange(int minZoomLevel, int maxZoomLevel)
	{
		setZoomOffset(minZoomLevel);

		int len = maxZoomLevel - minZoomLevel + 1;
		double[] resolutions = new double[len];
		double curRes = getGroundResolutionInMeters(0, minZoomLevel);
		for (int i = 0; i < len; i++)
		{
			resolutions[i] = curRes;
			curRes = curRes / 2;
		}

		// resolution setting seems to work only via options
		XYZOptions options = new XYZOptions();
		options.setResolutions(resolutions);
		this.addOptions(options);
	}

	/**
	 * If your cache has more zoom levels than you want to provide access to with this layer, supply a zoomOffset. This
	 * zoom offset is added to the current map zoom level to determine the level for a requested tile. For example, if
	 * you supply a zoomOffset of 3, when the map is at the zoom 0, tiles will be requested from level 3 of your cache.
	 * Default is 0 (assumes cache level and map zoom are equivalent). Using zoomOffset is an alternative to setting
	 * serverResolutions if you only want to expose a subset of the server resolutions.
	 * @param zoomOffset zoom offset
	 */
	public void setZoomOffset(int zoomOffset)
	{
		XYZImpl.setZoomOffset(this.getJSObject(), zoomOffset);
	}
}
