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
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * Properties to be initialized for any GML2 by passing this object to the constructor
 *
 * @author Mikael Couzic
 */
public class GML2Options extends JSObjectWrapper
{

    protected GML2Options(JSObject jsObject)
    {
        super(jsObject);
    }

    /**
     * There is no no-argument constructor for this class.
     * The unique constructor takes arguments that are absolutely required for the GML parser to work.
     * @param featureNS
     *                                              Feature namespace. For example : "http://www.openplans.org/topp"
     * @param featureType
     *                                              Local (without prefix) feature typeName. For example : "states"
     * @author Mikael Couzic
     */
    public GML2Options(String featureNS, String featureType)
    {
        this(JSObject.createJSObject());
        setFeatureNS(featureNS);
        setFeatureType(featureType);
    }

    public void setFeatureNS(String featureNS)
    {
        getJSObject().setProperty("featureNS", featureNS);
    }

    public void setFeatureType(String featureType)
    {
        getJSObject().setProperty("featureType", featureType);
    }

    public void setGeometryName(String geometryName)
    {
        getJSObject().setProperty("geometryName", geometryName);
    }

}
