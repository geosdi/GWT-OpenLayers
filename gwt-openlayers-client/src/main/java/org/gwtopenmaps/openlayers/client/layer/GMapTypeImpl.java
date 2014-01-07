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
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GMapTypeImpl
{
// Constants
// Constants Description

    /*
     * G_NORMAL_MAP  This is the normal street map type.
     */
    public static native JSObject G_NORMAL_MAP() /*-{
        return $wnd.G_NORMAL_MAP ? $wnd.G_NORMAL_MAP : null;
    }-*/;

    /*
     * G_SATELLITE_MAP  This map type shows Google Earth satellite images.
     */
    public static native JSObject G_SATELLITE_MAP() /*-{
        return $wnd.G_SATELLITE_MAP ? $wnd.G_SATELLITE_MAP : null;
    }-*/;

    /*
     * G_HYBRID_MAP  This map type shows transparent street maps over Google Earth satellite images.
     */
    public static native JSObject G_HYBRID_MAP() /*-{
        return $wnd.G_HYBRID_MAP ? $wnd.G_HYBRID_MAP : null;
    }-*/;
}
