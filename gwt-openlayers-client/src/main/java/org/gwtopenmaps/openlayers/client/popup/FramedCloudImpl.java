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
package org.gwtopenmaps.openlayers.client.popup;

import com.google.gwt.dom.client.Element;

import org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis Information Systems
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class FramedCloudImpl
{

    /*
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     * Added by Digpro.
     */
    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html,
        JSObject anchor, boolean closeBox, CloseListener closeBoxCallback) /*-{
        function callback(evt) {
        closeBoxCallback.@org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener::onPopupClose(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(evt);
        }
        
        var framedCloud = new $wnd.OpenLayers.Popup.FramedCloud(id, lonlat, size, html, anchor, closeBox, callback);
        //if (size == null)
        //  anchored.autoSize = true;
        return framedCloud;
    }-*/;

    public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor,
        boolean closeBox) /*-{
        var framedCloud = new $wnd.OpenLayers.Popup.FramedCloud(id, lonlat, size, html, anchor, closeBox);
        //if (size == null)
        //  anchored.autoSize = true;
        return framedCloud;
    }-*/;

    public static native Element getContentDiv(JSObject popup) /*-{
        return popup.contentDiv;
    }-*/;
}
