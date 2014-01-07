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

import org.gwtopenmaps.openlayers.client.protocol.ProtocolType;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 * 
 * @author Francesco Izzi - CNR IMAA geoSDI Group
 * @email francesco.izzi@geosdi.org
 */
public class BingOptions extends XYZOptions {

    /**
     * Required configuration properties:
     *
     * key - {String} Bing Maps API key for your application. Get one at
     * http://bingmapsportal.com/.
     *
     * type - {String} The layer identifier. Any non-birdseye imageryType from
     * http://msdn.microsoft.com/en-us/library/ff701716.aspx can be used.
     *
     * @param name
     * @param key
     * @param type
     */
    public BingOptions(String name, String key, BingType type) {
        if (key == null) {
            throw new NullPointerException("PARAM Key must not be null.");
        }
        getJSObject().setProperty("name", name);
        getJSObject().setProperty("key", key);
        getJSObject().setProperty("type", type == null
                ? BingType.ROAD.toString() : type.toString());
    }

    /**
     *
     * @return Key Registration
     */
    public String getKey() {
        return getJSObject().getPropertyAsString("key");
    }

    /**
     *
     * @return Bing Layer Type
     */
    public String getType() {
        return getJSObject().getPropertyAsString("type");
    }

    /**
     *
     * @return Bing Layer Name
     */
    public String getName() {
        return getJSObject().getPropertyAsString("name");
    }

    @Override
    public void setAttribution(String attribution) {
        getJSObject().setProperty("attributionTemplate", attribution);
    }
    
    public String getProtocol(){
        return getJSObject().getPropertyAsString("protocol");
    }
    
    public void setProtocol(ProtocolType protocol){
        getJSObject().setProperty("protocol", protocol.toString());
    }
}
