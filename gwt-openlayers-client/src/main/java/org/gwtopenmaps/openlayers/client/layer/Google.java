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

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class Google extends Layer
{

    // In OpenLayers this class inherits from both EventPane
    // and FixedZoomLevels

    protected Google(JSObject element)
    {
        super(element);
    }

    public Google(String name)
    {
        this(GoogleImpl.create(name));
    }

    public Google(String name, GoogleOptions params)
    {
        this(GoogleImpl.create(name, params.getJSObject()));
    }

    public Google narrowToGoogle(JSObject google)
    {
        return (google == null) ? null : new Google(google);
    }

    public LonLat forwardMercator(double lon, double lat)
    {
        return LonLat.narrowToLonLat(GoogleImpl.forwardMercator(getJSObject(), lon, lat));
    }

}
