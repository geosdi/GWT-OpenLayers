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
package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Handler Base Class.
 *
 * @author Tino Desjardins - SRP
 *
 */
public class Handler extends OpenLayersObjectWrapper {

    public static final int MOD_NONE = 0;
    public static final int MOD_SHIFT = 1;
    public static final int MOD_CTRL = 2;
    public static final int MOD_ALT = 4;
    //
    public static final String CLICK_HANDLER_CLASS_NAME = "OpenLayers.Handler.Click";
    public static final String POINT_HANDLER_CLASS_NAME = "OpenLayers.Handler.Point";
    public static final String PATH_HANDLER_CLASS_NAME = "OpenLayers.Handler.Path";
    public static final String POLYGON_HANDLER_CLASS_NAME = "OpenLayers.Handler.Polygon";
    public static final String REGULAR_POLYGON_HANDLER_CLASS_NAME = "OpenLayers.Handler.RegularPolygon";

    public static Handler narrowToHandler(JSObject element) {
        return (element == null) ? null : new Handler(element);
    }

    protected Handler(JSObject element) {
        super(element);
    }

    /**
     * Activates the Handler.
     */
    public void activate() {
        HandlerImpl.activate(this.getJSObject());
    }

    /**
     * Deactivates the Handler.
     */
    public void deactivate() {
        HandlerImpl.deactivate(this.getJSObject());
    }
    
    public boolean checkModifiers(EventObject event) {
        return HandlerImpl.checkModifiers(this.getJSObject(), event.getJSObject());
    }
    
    public void setKeyMask(int... keyCodes) {

        int keyMask = 0;

        if (keyCodes != null) {
            for (int keyCode : keyCodes) {
                keyMask |= keyCode;
            }
        }

        HandlerImpl.setKeyMask(this.getJSObject(), keyMask);
    }

}
