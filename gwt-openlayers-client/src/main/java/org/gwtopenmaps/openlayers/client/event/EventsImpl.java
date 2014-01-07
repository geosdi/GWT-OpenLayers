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
package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Edwin Commandeur - Atlis EJS
 *
 *
 */
class EventsImpl
{

    public static native JSObject register(JSObject self, String type, JSObject obj, JSObject handler) /*-{
        self.register(type, obj, handler);
    }-*/;

    public static native JSObject on(JSObject self, JSObject object) /*-{
        self.on(object);
    }-*/;

    public static native void unregister(JSObject self, String type, JSObject obj, JSObject handler) /*-{
        self.unregister(type, obj, handler);
    }-*/;

    public static native JSObject getMousePosition(JSObject self, JSObject evt) /*-{
        return self.getMousePosition(evt);
    }-*/;

    public static native JSObject stop(JSObject evt, boolean allowDefault) /*-{
        $wnd.OpenLayers.Event.stop(evt, allowDefault);
    }-*/;

}
