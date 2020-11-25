/**
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
 *
 * @author Erdem Gunay
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GoogleImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Google(name);
    }-*/;

    public static native JSObject create(String name, JSObject params)
    /*-{
       return new $wnd.OpenLayers.Layer.Google(name, params);
    }-*/;

    public static native JSObject forwardMercator(JSObject google, double lon, double lat) /*-{
        return google.forwardMercator(lon, lat);
    }-*/;
}
