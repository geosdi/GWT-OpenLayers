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
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * Implementation of the OpenLayers style object. nameed "OpenLayersStyle" just
 * because there is already a Style class in this package.
 * TODO: fix this
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public class OpenLayersStyle extends JSObjectWrapper
{

    protected OpenLayersStyle(JSObject jsObject)
    {
        super(jsObject);
    }
    
    public OpenLayersStyle(StyleRules rules, StyleOptions options) {
        this(OpenLayersStyleImpl.create(rules.getJSObject(), options.getJSObject()));
    }

}
