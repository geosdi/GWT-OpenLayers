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

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class GMapType extends OpenLayersObjectWrapper
{

    /**
     * This map type shows Google Earth satellite images.
     */
    public static final GMapType G_SATELLITE_MAP = narrowToGMapType(
            GMapTypeImpl.G_SATELLITE_MAP());

    /**
     * Normal street map type.
     */
    public static final GMapType G_NORMAL_MAP = narrowToGMapType(
            GMapTypeImpl.G_NORMAL_MAP());

    /**
     * This map type transposes street maps and labels over satellite images.
     */
    public static final GMapType G_HYBRID_MAP = narrowToGMapType(
            GMapTypeImpl.G_HYBRID_MAP());

    protected static GMapType narrowToGMapType(JSObject element)
    {
        return (element == null) ? null : new GMapType(element);
    }

    protected GMapType(JSObject element)
    {
        super(element);
    }
}
