/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.openlayers.client.format.wmts;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Zsolt Sandor
 */
class WMTSCapabilitiesImpl {

    public static native JSObject create()/*-{
     return new $wnd.OpenLayers.Format.WMTSCapabilities();
     }-*/;

    public static native JSObject read(JSObject self, String data)/*-{
     return self.read(data);
     }-*/;

    public static native JSObject create(JSObject options)/*-{
     return new $wnd.OpenLayers.Format.WMTSCapabilities(options);
     }-*/;

    public static native JSObject createLayer(JSObject self, JSObject capabilities, JSObject options)/*-{
     return self.createLayer(capabilities, options);
     }-*/;
    
    public static native String[] createMatrixIds(JSObject self, JSObject capabilities, String tileMatrixSet)/*-{
    	var matrixIds = [];                   
        var numOfTileMatrixSet = capabilities.contents.tileMatrixSets[tileMatrixSet].matrixIds.length;
  
        for (var i=0; i<numOfTileMatrixSet; ++i) {                   
			matrixIds[i] = capabilities.contents.tileMatrixSets[tileMatrixSet].matrixIds[i].identifier;
        }
                   
		return matrixIds;
    }-*/;

}
