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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
*
* @author Erdem Gunay
* @author Edwin Commandeur - Atlis EJS
* @author Curtis Jensen
* @author Lukas Johansson
*
*/
class VectorImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Vector(name);
    }-*/;

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Vector(name, options);
    }-*/;

    public static native void addFeature(JSObject self, JSObject feature) /*-{
        self.addFeatures(feature);
    }-*/;

    public static native void addFeatures(JSObject self, JSObject features) /*-{
        self.addFeatures(features);
    }-*/;

    public static native JSObject getFeature(JSObject self, int index) /*-{
        return self.features[index];
    }-*/;

    public static native int getNumberOfFeatures(JSObject self) /*-{
        if(self.features){
        return self.features.length;
        } else {
        return -1;
        }
    }-*/;

    public static native int getNumberOfSelectedFeatures(JSObject self) /*-{
        if(self.selectedFeatures){
        return self.selectedFeatures.length;
        } else {
        return -1;
        }
    }-*/;

    public static native void destroyFeatures(JSObject self) /*-{
        self.destroyFeatures();
    }-*/;

    public static native JSObject getFeatureById(JSObject self, String id) /*-{
        return self.getFeatureById(id);
    }-*/;

    public static native boolean redraw(JSObject vector) /*-{
        return vector.redraw();
    }-*/;

    public static native void drawFeature(JSObject vector, JSObject feature) /*-{
        vector.drawFeature(feature);
    }-*/;

    public static native void drawFeature(JSObject vector, JSObject feature,
        JSObject style) /*-{
        vector.drawFeature(feature, style);
    }-*/;

    public static native void eraseFeatures(JSObject vector) /*-{
        vector.eraseFeatures();
    }-*/;

    public static native void removeFeature(JSObject vector, JSObject feature) /*-{
        vector.removeFeatures(feature);
    }-*/;

    public static native JSObject getDataExtentImp(JSObject vector) /*-{
        return vector.getDataExtent();
    }-*/;

    public static native void setStyle(JSObject self, JSObject style) /*-{
        self.style = style;
    }-*/;

    public static native JSObject getStyle(JSObject self) /*-{
        return self.style;
    }-*/;

    public static native void setStyleMap(JSObject self, JSObject styleMap) /*-{
        self.styleMap = styleMap;
    }-*/;

    public static native JSObject getStyleMap(JSObject self) /*-{
        return self.styleMap;
    }-*/;

    public static native JSObject getSelectedFeature(JSObject self, int index) /*-{
       return self.selectedFeatures[index];
    }-*/;
    
    public static native JSObject getFeatureByFid(JSObject self, String featureFID) /*-{
       return self.getFeatureByFid(featureFID);
    }-*/;
    
    public static native void removeAllFeatures(JSObject self) /*-{
       self.removeAllFeatures();
    }-*/;

}
