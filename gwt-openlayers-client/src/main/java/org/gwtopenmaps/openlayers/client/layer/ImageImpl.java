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
 * See {@link Image}
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class ImageImpl
{

    public static native JSObject create(String name, String url, JSObject extent, JSObject size, JSObject params) /*-{
        return new $wnd.OpenLayers.Layer.Image(name, url, extent, size, params);
    }-*/;

    public static native JSObject getExtent(JSObject self) /*-{
        return self.extent;
    }-*/;

    public static native JSObject getSize(JSObject self) /*-{
        return self.size;
    }-*/;

    public static native String getUrl(JSObject self) /*-{
        return self.url;
    }-*/;

    public static native void setUrl(JSObject self, String url) /*-{
        self.url = url;
    }-*/;
}
