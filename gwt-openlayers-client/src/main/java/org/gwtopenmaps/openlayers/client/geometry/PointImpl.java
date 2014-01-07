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
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PointImpl
{

    public static native JSObject create(double x, double y) /*-{
        return new $wnd.OpenLayers.Geometry.Point(x, y);
    }-*/;

    public static native double getX(JSObject self) /*-{
        return self.x;
    }-*/;

    public static native double getY(JSObject self) /*-{
        return self.y;
    }-*/;

    public static native String getId(JSObject self) /*-{
        return self.id;
    }-*/;

    public static native void setX(JSObject self, double x) /*-{
        self.x = x;
    }-*/;

    public static native void setY(JSObject self, double y) /*-{
        self.y = y;
    }-*/;

    public static native boolean equals(JSObject self, JSObject geom) /*-{
        return self.equals(geom);
    }-*/;

    public static native void transform(JSObject self, JSObject source, JSObject dest) /*-{
        self.transform(source, dest);
    }-*/;

    public static native void rotate(JSObject self, float angle, JSObject origin) /*-{
        self.rotate(angle, origin);
    }-*/;

    public static native JSObject getCentroid(JSObject self) /*-{
    return self.getCentroid();
    }-*/;
}