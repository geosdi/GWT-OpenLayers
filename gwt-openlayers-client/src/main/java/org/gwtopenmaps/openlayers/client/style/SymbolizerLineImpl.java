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
package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerLineImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Symbolizer.Line();
    }-*/;

    public static native void setStrokeColor(JSObject self, String color) /*-{
        self.strokeColor = color;
    }-*/;

    public static native String getStrokeColor(JSObject self) /*-{
        return self.strokeColor;
    }-*/;

    public static native void setStrokeOpacity(JSObject self, double opacity) /*-{
        self.strokeOpacity = opacity;
    }-*/;

    public static native double getStrokeOpacity(JSObject self) /*-{
        return self.strokeOpacity;
    }-*/;

    public static native void setStrokeWidth(JSObject self, int width) /*-{
        self.strokeWidth = width;
    }-*/;

    public static native int getStrokeWidth(JSObject self) /*-{
        return self.strokeWidth;
    }-*/;

    /**
     *
     * @param linecap Stroke cap type (“butt�?, “round�?, or “square�?).
     */
    public static native void setLinecap(JSObject self, String linecap) /*-{
        self.strokeLinecap = linecap;
    }-*/;

    public static native String getLinecap(JSObject self) /*-{
        return self.strokeLinecap;
    }-*/;


    /**
     * Stroke dash style according to the SLD spec.  Note that the OpenLayers values for strokeDashstyle (“dot�?, “dash�?, “dashdot�?, “longdash�?, “longdashdot�?, or “solid�?) will not work in SLD, but most SLD patterns will render correctly in OpenLayers
     * @param dashstyle
     */
    public static native void setDashstyle(JSObject self, String dashstyle) /*-{
        self.strokeDashstyle = dashstyle;
    }-*/;

    public static native String getDashstyle(JSObject self) /*-{
        return self.strokeDashstyle;
    }-*/;
}
