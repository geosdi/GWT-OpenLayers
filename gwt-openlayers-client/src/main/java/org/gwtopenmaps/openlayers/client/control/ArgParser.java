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
 * Parses arguments passed to the url at which the application is located. For example:
 *
 * http://www.mydomain.org/myapp.html?lat=-13.08191&lon=-38.73143&zoom=12&layers=0BF
 *
 * The ArgParser control will parse the lat, lon, zoom, and layers arguments on page load/refresh.
 * This can be used to initialize the map from the url.
 *
 * This control is added to OpenLayers maps by default.
 *
 * Other controls that are added by default are the {@link PanZoom},
 * Navigation, and {@link Attribution}.
 *
 * @author Edwin Commandeur - Atlis Information Systems
 * @since GWT-OL 0.4, OL ...
 */
public class ArgParser extends Control
{

    protected ArgParser(JSObject element)
    {
        super(element);
    }

    public ArgParser()
    {
        this(ArgParserImpl.create());
    }

    public ArgParser(ArgParserOptions options)
    {
        this(ArgParserImpl.create(options.getJSObject()));
    }
}
