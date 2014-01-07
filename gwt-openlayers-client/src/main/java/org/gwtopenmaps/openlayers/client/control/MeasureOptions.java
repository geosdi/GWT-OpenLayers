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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.handler.HandlerOptions;


/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class MeasureOptions extends ControlOptions
{

    /**
     * Keep the temporary measure sketch or not.
     *
     * @param persist - Set to true to keep the temporary measurement sketch drawn after
     *     the measurement is complete.  The geometry will persist until a new
     *     measurement is started, the control is deactivated, or <cancel> is called.
     *     Default is false.
     */
    public void setPersist(boolean persist)
    {
        getJSObject().setProperty("persist", persist);
    }

    /**
     * Set non-default handler options. An example is setting a {@link org.gwtopenmaps.openlayers.client.StyleMap}.
     * <pre>
     *
     * control.setHandlerOptions(new BaseGeometryHandlerOptions()
     *   .setLayerOptions(new HandlerLayerOptions().setStyleMap(styleMap)))
     *
     * </pre>
     *
     * @param options - {@link org.gwtopenmaps.openlayers.client.handler.BaseGeometryHandlerOptions} or a subclass
     */
    public void setHandlerOptions(HandlerOptions options)
    {
        getJSObject().setProperty("handlerOptions", options.getJSObject());
    }

    /**
    * Property: geodesic
    * {Boolean} Calculate geodesic metrics instead of planar metrics.  This
    *     requires that geometries can be transformed into Geographic/WGS84
    *     (if that is not already the map projection).  Default is false.
    */
    public void setGeodesic(boolean geodesic)
    {
        getJSObject().setProperty("geodesic", geodesic);
    }
}
