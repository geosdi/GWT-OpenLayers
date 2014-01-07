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

class CollectionImpl {

    public static native JSObject create(JSObject geometries) /*-{
        return new $wnd.OpenLayers.Geometry.Collection($wnd.gwt_openlayers_util.convertToArray(geometries));
    }-*/;

    public static native int getNumberOfComponents(JSObject self) /*-{
        return self.components.length;
    }-*/;

    public static native JSObject getComponent(JSObject self,
            int index) /*-{
        return self.components[index];
    }-*/;

    public static native void transform(JSObject self,
            JSObject source,
            JSObject dest) /*-{
        self.transform(source, dest);
    }-*/;

    public static native boolean equals(JSObject self,
            JSObject geom) /*-{
        return self.equals(geom);
    }-*/;

    public static native double getLength(JSObject self) /*-{
        return self.getLength();
    }-*/;

    public static native void move(JSObject self,
            double x,
            double y) /*-{
        self.move(x, y);
    }-*/;

    public static native void rotate(JSObject self,
            double angle,
            JSObject origin) /*-{
        self.rotate(angle, origin);		
    }-*/;

    public static native void resize(JSObject self,
            double scale,
            JSObject origin,
            double ratio) /*-{
        self.resize(scale, origin, ratio);
    }-*/;

    public static native void resize(JSObject self,
            double scale,
            JSObject origin) /*-{ 
        self.resize(scale, origin);
    }-*/;

    public static native boolean addComponent(JSObject self,
            JSObject component,
            int index) /*-{
        return self.addComponent(component,index);
    }-*/;

    public static native void addComponents(JSObject self,
            JSObject components) /*-{
        self.addComponents($wnd.gwt_openlayers_util.convertToArray(components));
    }-*/;

    public static native boolean removeComponent(JSObject self,
            JSObject component) /*-{
        return self.removeComponent(component);
    }-*/;

    public static native boolean removeComponents(JSObject self,
            JSObject components) /*-{
        return self.removeComponents($wnd.gwt_openlayers_util.convertToArray(components));
    }-*/;
    
    public static native String getComponentsString(JSObject self) /*-{
        return self.getComponentsString();
    }-*/;
}
