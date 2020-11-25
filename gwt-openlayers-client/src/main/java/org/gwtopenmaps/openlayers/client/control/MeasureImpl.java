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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class MeasureImpl
{

    public static native JSObject create(JSObject handler) /*-{
        return new $wnd.OpenLayers.Control.Measure(handler);
    }-*/;

    public static native JSObject create(JSObject handler, JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Measure(handler, options);
    }-*/;

    public static native boolean getPersist(JSObject self) /*-{
        return self.persist;
    }-*/;

    public static native void setPersist(JSObject self, boolean persist) /*-{
	    self.persist = persist;
	}-*/;

    public static native boolean getImmediate(JSObject self) /*-{
	    return self.immediate;
	}-*/;

    public static native void setImmediate(JSObject self, boolean immediate) /*-{
	    self.setImmediate(immediate);
	}-*/;
}
