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

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.Marker;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * <p>
 * Markers is the non-preferred way to create marker layers.
 * Alternatively, use Vector Layers, as explained
 * <a href="http://docs.openlayers.org/library/overlays.html">here</a>.
 * </p>
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class Markers extends Layer
{

    protected Markers(JSObject markersLayer)
    {
        super(markersLayer);
    }

    public Markers(String name)
    {
        this(MarkersImpl.create(name));
    }

    public Markers(String name, MarkersOptions options)
    {
        this(MarkersImpl.create(name, options.getJSObject()));
    }

    public void addMarker(Marker marker)
    {
        MarkersImpl.addMarker(getJSObject(), marker.getJSObject());
    }

    public void removeMarker(Marker marker)
    {
        MarkersImpl.removeMarker(getJSObject(), marker.getJSObject());
    }

    public void clearMarkers()
    {
        MarkersImpl.clearMarkers(getJSObject());
    }

    public JSObject[] getMarkers()
    {
        return getJSObject().getPropertyAsArray("markers");
    }

    public Bounds getDataExtent()
    {
        return Bounds.narrowToBounds(MarkersImpl.getDataExtent(getJSObject()));
    }

    public void destroy()
    {
        MarkersImpl.destroy(getJSObject());
    }
}
