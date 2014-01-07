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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SnappingImpl
{

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Snapping(options);
    }-*/;

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Snapping();
    }-*/;

    public static native boolean activate(JSObject self) /*-{
        return self.activate();
    }-*/;

    public static native boolean deactivate(JSObject self) /*-{
        return self.deactivate();
    }-*/;

    public static native void setLayer(JSObject self, JSObject vector) /*-{
        self.setLayer(vector);
    }-*/;

    public static native void addTargetLayer(JSObject self, JSObject vector) /*-{
        self.addTargetLayer(vector);
    }-*/;

    public static native void removeTargetLayer(JSObject self, JSObject vector) /*-{
        self.removeTargetLayer(vector);
    }-*/;

    public static native void addTarget(JSObject self, JSObject target) /*-{
        self.addTarget(target);
    }-*/;

    public static native void removeTarget(JSObject self, JSObject target) /*-{
        self.removeTarget(target);
    }-*/;

}
