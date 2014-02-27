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

import org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;

class DragFeatureImpl {

    public static native JSObject create(JSObject vectorLayer) /*-{
     return new $wnd.OpenLayers.Control.DragFeature(vectorLayer);
     }-*/;

    public static native JSObject create(JSObject vectorLayer, JSObject options) /*-{
     return new $wnd.OpenLayers.Control.DragFeature(vectorLayer,options);
     }-*/;

    public static native JSObject createDragCallback(
            DragFeatureListener listener) /*-{
     var callback = function(vectorFeature,pixel){
     var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(vectorFeature);
     var pixelObj = @org.gwtopenmaps.openlayers.client.Pixel::narrowToPixel(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(pixel);
     listener.@org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener::onDragEvent(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;Lorg/gwtopenmaps/openlayers/client/Pixel;)(vectorFeatureObj,pixelObj);
     }
     return callback;
     }-*/;

    public static native void setDragStopDown(JSObject self, boolean stopDown) /*-{
     self.handlers['drag'].stopDown = stopDown;
     }-*/;

    public static native void setDragStopUp(JSObject self, boolean stopUp) /*-{
     self.handlers['drag'].stopUp = stopUp;
     }-*/;

    public static native void setDragStopClick(JSObject self, boolean stopClick) /*-{
     self.handlers['drag'].stopClick = stopClick;
     }-*/;

    public static native void setFeatureStopDown(JSObject self, boolean stopDown) /*-{
     self.handlers['feature'].stopDown = stopDown;
     }-*/;

    public static native void setFeatureStopUp(JSObject self, boolean stopUp) /*-{
     self.handlers['feature'].stopUp = stopUp;
     }-*/;

    public static native void setFeatureStopClick(JSObject self, boolean stopClick) /*-{
     self.handlers['feature'].stopClick = stopClick;
     }-*/;

}
