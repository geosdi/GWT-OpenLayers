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
package org.gwtopenmaps.openlayers.client.protocol;



/**
 * WFSProtocolOptions
 *
 * @author davek<at>komacke<dot>com
 *
 */

public class WFSProtocolOptions extends ProtocolOptions
{

    /**
     * This constructor doesn't allow proper use of method <code>WFSProtocol.read()</code>.
     * Use <code>WFSProtocolOptions(String url, String featureNS, String featureType )</code> instead.
     */
    public WFSProtocolOptions()
    {
    }

    public WFSProtocolOptions(String url, String featureNS, String featureType)
    {
        setUrl(url);
        setFeatureNameSpace(featureNS);
        setFeatureType(featureType);
    }

    /**
     * @param geometryName - set the geometry name. Default is "the_geom".
     * @param geometryName - set the geometry name
     */
    public void setGeometryName(String geometryName)
    {
        getJSObject().setProperty("geometryName", geometryName);
    }

    /**
     * @param url - the url of the WFS
     */
    public void setUrl(String url)
    {
        getJSObject().setProperty("url", url);
    }

    /**
     * @param featureNS - the namespace of the feature schema
     */
    public void setFeatureNameSpace(String featureNS)
    {
        getJSObject().setProperty("featureNS", featureNS);
    }

    /**
     * @param featureType - the type of feature, for example: roads, lakes, cities
     */
    public void setFeatureType(String featureType)
    {
        getJSObject().setProperty("featureType", featureType);
    }

    /**
     * @param srsName- name of the spatial reference system (e.g., EPSG:4326)
     */
    public void setSrsName(String srsName)
    {
        getJSObject().setProperty("srsName", srsName);
    }

    /**
     * @param version - WFS version, defaults to 1.0.0
     */
    public void setVersion(String version)
    {
        getJSObject().setProperty("version", version);
    }
}
