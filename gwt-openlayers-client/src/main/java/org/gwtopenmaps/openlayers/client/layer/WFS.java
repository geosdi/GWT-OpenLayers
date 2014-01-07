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
 * For displaying FeatureCollection data requested from a Web Feature Service (WFS)
 * server.
 *
 * Link to Open Geospatial Consortium website and WFS info.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4, OL 2.2
 *
 */
public class WFS extends Vector
{

    protected WFS(JSObject element)
    {
        super(element);
    }

    public WFS(String name, String url, WFSParams params, WFSOptions options)
    {
        this(WFSImpl.create(name, url, params.getJSObject(), options.getJSObject()));
    }

}
