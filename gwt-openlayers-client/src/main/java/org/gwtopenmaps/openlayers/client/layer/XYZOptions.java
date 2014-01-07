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

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 */
public class XYZOptions extends GridLayerOptions
{

    /**
     *
     * @param b
     */
    public void setSphericalMercator(boolean b)
    {
        getJSObject().setProperty("sphericalMercator", b);
    }

    /**
     *
     * @param zoomOffset
     */
    public void setZoomOffset(int zoomOffset)
    {
        getJSObject().setProperty("zoomOffset", zoomOffset);
    }

    /**
    *
    * @param b
    */
    public void setIsBaseLayer(boolean b)
    {
        getJSObject().setProperty("isBaseLayer", b);
    }

}
