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
package org.gwtopenmaps.openlayers.client.format.sld;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Zsolt Sandor
 */
public class SLDResult extends OpenLayersEObjectWrapper {

    protected SLDResult(JSObject openLayersObject) {
        super(openLayersObject);
    }

    public String getVersion() {
        return getJSObject().getPropertyAsString("version");
    }

    /**
     * This method returns a style map usable in layers and features
     *
     * @return {@link StyleMap} style
     */
    public StyleMap getUserStyleMap() {
        return StyleMap.narrowToOpenLayersStyleMap(getUserStyle(getJSObject()));
    }

    /**
     * Get the user style map from an SLD object
     *
     * @param sld
     * @return
     */
    public static native JSObject getUserStyle(JSObject sld)/*-{
     for ( var l in sld.namedLayers) {
     var styles = sld.namedLayers[l].userStyles;
     return styles[0];
     }
     }-*/;

}
