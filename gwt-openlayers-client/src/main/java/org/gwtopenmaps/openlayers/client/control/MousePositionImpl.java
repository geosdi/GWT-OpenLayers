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

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
class MousePositionImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.MousePosition();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.MousePosition(options);
    }-*/;

    public static native JSObject formatOutput(MousePositionOutput output) /*-{
        var outputFn = function(lonLat){
        var out = ""
        var lonLatObj = @org.gwtopenmaps.openlayers.client.LonLat::narrowToLonLat(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(lonLat);
        var mapObj = @org.gwtopenmaps.openlayers.client.Map::narrowToMap(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(this.map);
        
        out = output.@org.gwtopenmaps.openlayers.client.control.MousePositionOutput::format(Lorg/gwtopenmaps/openlayers/client/LonLat;Lorg/gwtopenmaps/openlayers/client/Map;)(lonLatObj,mapObj);
        
        return out;
        }
        return outputFn;
    }-*/;

}
