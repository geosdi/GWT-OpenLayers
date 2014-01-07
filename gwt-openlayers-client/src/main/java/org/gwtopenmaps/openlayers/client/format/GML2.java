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
package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Wraps OpenLayers.Format.GML.v2
 *
 * Brief explanation of Geographic Markup Language (GML) vector format here.
 *
 * Reference to GML specification. GML is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Mikael Couzic
 */
public class GML2 extends VectorFormat
{

    protected GML2(JSObject gmlFormat)
    {
        super(gmlFormat);
    }

    /**
     * Unique constructor taking required options as a parameter.
     * @param options
     *                              required options
     */
    public GML2(GML2Options options)
    {
        this(GML2Impl.create(options.getJSObject()));
    }

}
