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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author davek<at>komacke<dot>com
 *
 */
class GetFeatureImpl {

    public static native JSObject create() /*-{
     return new $wnd.OpenLayers.Control.GetFeature();
     }-*/;

    public static native JSObject create(JSObject options) /*-{
     return new $wnd.OpenLayers.Control.GetFeature(options);
     }-*/;

    public static native void unselectAll(JSObject self) /*-{
     self.unselectAll();
     }-*/;

    public static native void selectBox(JSObject self, JSObject bounds) /*-{
     self.selectBox(bounds);
     }-*/;

    @Deprecated
    public static native JSObject getBounds(JSObject self) /*-{
     return self.bounds;
     }-*/;

}
