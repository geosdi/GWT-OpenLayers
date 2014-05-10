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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.SelectFeature.ClickFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.SelectFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.UnselectFeatureListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * See {@link SelectFeature}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Lorenzo Amato <lorenzo.amato@geosdi.org>
 *
 */
class SelectFeatureImpl {

    public static native JSObject create(JSObject layer) /*-{
     return new $wnd.OpenLayers.Control.SelectFeature(layer);
     }-*/;

    public static native JSObject create2(JSObject layers) /*-{
     return new $wnd.OpenLayers.Control.SelectFeature($wnd.gwt_openlayers_util.convertToArray(layers));
     }-*/;

    public static native JSObject create(JSObject layer, JSObject options) /*-{
     return new $wnd.OpenLayers.Control.SelectFeature(layer, options);
     }-*/;

    public static native JSObject create2(JSObject layers, JSObject options) /*-{
     return new $wnd.OpenLayers.Control.SelectFeature($wnd.gwt_openlayers_util.convertToArray(layers), options);
     }-*/;

    public static native void setClickOut(JSObject self, boolean clickout) /*-{
     self.clickout = clickout;
     }-*/;

    public static native void setHover(JSObject self, boolean hover) /*-{
     self.hover = hover;
     }-*/;

    public static native void setMultiple(JSObject self, boolean multiple) /*-{
     self.multiple = multiple;
     }-*/;

    public static native void setToggle(JSObject self, boolean toggle) /*-{
     self.toggle = toggle;
     }-*/;

    public static native JSObject createSelectFeatureCallback(
            SelectFeatureListener listener) /*-{
     var callback = function(obj){
     var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
     listener.@org.gwtopenmaps.openlayers.client.control.SelectFeature.SelectFeatureListener::onFeatureSelected(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
     }
     return callback;
     }-*/;

    public static native JSObject createUnselectFeatureCallback(
            UnselectFeatureListener listener) /*-{
     var callback = function(obj){
     var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
     listener.@org.gwtopenmaps.openlayers.client.control.SelectFeature.UnselectFeatureListener::onFeatureUnselected(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
     }
     return callback;
     }-*/;

    public static native JSObject createClickFeatureCallback(
            ClickFeatureListener listener) /*-{
     var callback = function(obj){
     var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
     listener.@org.gwtopenmaps.openlayers.client.control.SelectFeature.ClickFeatureListener::onFeatureClicked(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
     }
     return callback;
     }-*/;

    public static native void unselect(JSObject selectFeature, JSObject feature) /*-{
     selectFeature.unselect(feature);
     }-*/;

    public static native void select(JSObject vectorLayer, JSObject feature) /*-{
     vectorLayer.select(feature);
     }-*/;

    public static native void unselectAll(JSObject selectFeature,
            JSObject options)/*-{
     selectFeature.unselectAll(options);
     }-*/;

    public static native void setToggleKey(JSObject selectFeature,
            String keyName) /*-{
     selectFeature["toggleKey"] = keyName;
     }-*/;

    public static native void setLayers(JSObject self, JSObject layers) /*-{
        self.setLayer(layers);
    }-*/;

    public static native void setMultipleKey(JSObject selectFeature,
            String keyName) /*-{
     selectFeature["multipleKey"] = keyName;
     }-*/;
    
    public static native void setSelectStopDown(JSObject self, boolean stopDown) /*-{
    	self.handlers['feature'].stopDown = stopDown;
    }-*/;
}
