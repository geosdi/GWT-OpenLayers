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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Francesco
 *
 */
class GMLImpl
{

    public static native JSObject create(String name, String url) /*-{
        return new $wnd.OpenLayers.Layer.GML(name, url);
    }-*/;

    public static native JSObject create(String name, String url, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.GML(name, url, options);
    }-*/;

    public static native void loadGML(JSObject jsObject) /*-{
        jsObject.loadGML();
    }-*/;

}
