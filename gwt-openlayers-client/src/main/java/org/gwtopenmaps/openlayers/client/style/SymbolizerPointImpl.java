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


public class SymbolizerPointImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Symbolizer.Point();
    }-*/;

    public static native void setPointRadius(JSObject self, double radius) /*-{
        self.pointRadius = radius;
    }-*/;

    public static native double getPointRadius(JSObject self) /*-{
        return self.pointRadius;
    }-*/;

    public static native void setExternalGraphic(JSObject self, String url) /*-{
        self.externalGraphic = url;
    }-*/;

    public static native String getExtenalGraphic(JSObject self) /*-{
        return self.externalGraphic;
    }-*/;

    public static native void setGraphicWidth(JSObject self, int width) /*-{
        self.graphicWidth = width;
    }-*/;

    public static native int getGraphicWidth(JSObject self) /*-{
        return self.graphicWidth;
    }-*/;

    public static native void setGraphicHeight(JSObject self, int height) /*-{
        self.graphicHeight = height;
    }-*/;

    public static native int getGraphicHeight(JSObject self) /*-{
        return self.graphicHeight;
    }-*/;

    public static native void setGraphicOpacity(JSObject self, double opacity) /*-{
        self.graphicOpacity = opacity;
    }-*/;

    public static native double getGraphicOpacity(JSObject self) /*-{
        return self.graphicOpacity;
    }-*/;

    public static native void setGraphicXOffset(JSObject self, int offset) /*-{
        self.graphicXOffset = offset;
    }-*/;

    public static native int getGraphicXOffset(JSObject self) /*-{
        return self.graphicXOffset;
    }-*/;

    public static native void setGraphicYOffset(JSObject self, int offset) /*-{
        self.graphicYOffset = offset;
    }-*/;

    public static native int getGraphicYOffset(JSObject self) /*-{
        return self.graphicYOffset;
    }-*/;

    public static native void setRotation(JSObject self, double rotation) /*-{
        self.rotation = rotation;
    }-*/;

    public static native double getRotation(JSObject self) /*-{
        return self.rotation;
    }-*/;

    public static native void setGraphicName(JSObject self, String name) /*-{
        self.graphicName = name;
    }-*/;

    public static native String getGraphicName(JSObject self) /*-{
        return self.graphicName;
    }-*/;
}
