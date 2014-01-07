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
package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Lukas Johansson
 */
public class FeatureImpl
{

    public static native void destroy(JSObject self) /*-{
        self.destroy();
    }-*/;

    public static native String getFeatureId(JSObject self) /*-{
        return self.id;
    }-*/;

    public static native String getFID(JSObject self) /*-{
        return self.fid;
    }-*/;

    public static native void setPopup(JSObject feature, JSObject inputPopup) /*-{
        feature.popup = inputPopup;
    }-*/;

    public static native JSObject getPopup(JSObject feature) /*-{
        return feature.popup;
    }-*/;

    public static native void resetPopup(JSObject feature) /*-{
        feature.popup.destroy();
        feature.popup = null;
    }-*/;

    public static native JSObject createPopup(JSObject feature, boolean closeBox) /*-{
        return feature.createPopup(closeBox);
    }-*/;

    public static native JSObject getBounds(JSObject feature) /*-{
        return feature.geometry.getBounds();
    }-*/;

    public static native void setStyle(JSObject feature, JSObject newStyle) /*-{
        feature.style = newStyle;
    }-*/;

    public static native JSObject getStyle(JSObject self) /*-{
        return self.style;
    }-*/;

    public static native JSObject getLayer(JSObject feature) /*-{
        return feature.layer;
    }-*/;

}
