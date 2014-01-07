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

import org.gwtopenmaps.openlayers.client.format.GeoJSON;
import org.gwtopenmaps.openlayers.client.protocol.HTTPProtocol;
import org.gwtopenmaps.openlayers.client.protocol.HTTPProtocolOptions;
import org.gwtopenmaps.openlayers.client.strategy.FixedStrategy;
import org.gwtopenmaps.openlayers.client.strategy.FixedStrategyOptions;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;

/**
 * This class can be used to create a layer from a geojson file.
 * @author http://www.fks.be / Frank Wynants
 *
 */
public class JsonLayerCreator
{
    /**
     * Create a Vector layer from a geoJSOn file.
     * @param layerName The name you want to give to this layer.
     * @param url The URL to the geoJSON file you want to create a layer from.
     * @return A Vector layouer
     */
    public static Vector createLayerFromJson(String layerName, String url) {

        FixedStrategyOptions fOptions = new FixedStrategyOptions();
        FixedStrategy fStrategy = new FixedStrategy(fOptions);

        GeoJSON geoJson = new GeoJSON();

        HTTPProtocolOptions httpProtOptions = new HTTPProtocolOptions();
        httpProtOptions.setUrl(url);
        httpProtOptions.setFormat(geoJson);

        HTTPProtocol httpProt = new HTTPProtocol(httpProtOptions);

        VectorOptions options = new VectorOptions();
        options.setStrategies(new Strategy[]{fStrategy});
        options.setProtocol(httpProt);

        return new Vector(layerName, options);
    }
}
