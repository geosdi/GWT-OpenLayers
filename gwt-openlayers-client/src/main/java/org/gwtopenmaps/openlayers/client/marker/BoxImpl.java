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
package org.gwtopenmaps.openlayers.client.marker;

import org.gwtopenmaps.openlayers.client.util.JSObject;


class BoxImpl
{

    public static native JSObject create(JSObject bounds, String borderColor, int borderWidth) /*-{
        return new $wnd.OpenLayers.Marker.Box(bounds, borderColor, borderWidth);
    }-*/;

    public static native void setBorder(JSObject object, String borderColor, int borderWidth) /*-{
        object.setBorder(borderColor, borderWidth);
    }-*/;

    public static native void setZIndex(JSObject self, int zIndex) /*-{
        self.div.style.zIndex = zIndex;
    }-*/;

    public static native String getZIndex(JSObject self) /*-{
        return self.div.style.zIndex;
    }-*/;

    public static native JSObject getBounds(JSObject self) /*-{
        return self.bounds;
    }-*/;

}
