/**
 *
 *   Copyright 2015 sourceforge.
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
package org.gwtopenmaps.test.openlayers.client.map;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.ZIndexBase;
import org.gwtopenmaps.openlayers.client.layer.Bing;
import org.gwtopenmaps.openlayers.client.layer.BingOptions;
import org.gwtopenmaps.openlayers.client.layer.BingType;
import org.gwtopenmaps.openlayers.client.layer.EmptyLayer;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3MapType;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3Options;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.Markers;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.WMTS;
import org.gwtopenmaps.openlayers.client.layer.WMTSOptions;
import org.gwtopenmaps.openlayers.client.layer.XYZ;
import org.gwtopenmaps.openlayers.client.layer.XYZOptions;
import org.gwtopenmaps.openlayers.client.protocol.ProtocolType;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;

public class MapOptionsTest extends BaseTestCase {

    private static final String url = "http://v2.suite.opengeo.org/geoserver/gwc/service/wmts";

    public void testMapOptions() {
        // MapOptions mapOptions = new MapOptions();
        ZIndexBase zIndexBase = new ZIndexBase();
        zIndexBase.setForBaseLayers(125);
        assertEquals(125, zIndexBase.getJSObject().getPropertyAsInt("BaseLayer"));
    }

    public void testLayersClassInstance() {
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        //Create some Bing layers
        final String key = "Apd8EWF9Ls5tXmyHr22OuL1ay4HRJtI4JG4jgluTDVaJdUXZV6lpSBpX-TwnoRDG"; //Bing key
        // configuring road options
        BingOptions bingOptionRoad = new BingOptions("Bing Road Layer", key,
                BingType.ROAD);
        bingOptionRoad.setProtocol(ProtocolType.HTTP);
        Bing road = new Bing(bingOptionRoad);

        // configuring hybrid options
        BingOptions bingOptionHybrid = new BingOptions("Bing Hybrid Layer", key,
                BingType.HYBRID);
        bingOptionRoad.setProtocol(ProtocolType.HTTP);
        Bing hybrid = new Bing(bingOptionHybrid);

        // configuring aerial options
        BingOptions bingOptionAerial = new BingOptions("Bing Aerial Layer", key,
                BingType.AERIAL);
        bingOptionRoad.setProtocol(ProtocolType.HTTP);
        Bing aerial = new Bing(bingOptionAerial);

        GoogleV3Options gHybridOptions = new GoogleV3Options();
        gHybridOptions.setIsBaseLayer(true);
        gHybridOptions.setType(GoogleV3MapType.G_HYBRID_MAP);
        GoogleV3 gHybrid = new GoogleV3("Google Hybrid", gHybridOptions);

        GoogleV3Options gNormalOptions = new GoogleV3Options();
        gNormalOptions.setIsBaseLayer(true);
        gNormalOptions.setType(GoogleV3MapType.G_NORMAL_MAP);
        GoogleV3 gNormal = new GoogleV3("Google Normal", gNormalOptions);

        GoogleV3Options gSatelliteOptions = new GoogleV3Options();
        gSatelliteOptions.setIsBaseLayer(true);
        gSatelliteOptions.setType(GoogleV3MapType.G_SATELLITE_MAP);
        GoogleV3 gSatellite = new GoogleV3("Google Satellite", gSatelliteOptions);

        GoogleV3Options gTerrainOptions = new GoogleV3Options();
        gTerrainOptions.setIsBaseLayer(true);
        gTerrainOptions.setType(GoogleV3MapType.G_TERRAIN_MAP);
        GoogleV3 gTerrain = new GoogleV3("Google Terrain", gTerrainOptions);

        OSM osm_1 = OSM.Mapnik("Mapnik");
        OSM osm_2 = OSM.CycleMap("CycleMap");

        EmptyLayer.Options emptyLayerOptions = new EmptyLayer.Options();
        emptyLayerOptions.setAttribution("EmptyLayer (c) GWT-Openlayers"); //lets set some copyright msg as attribution
        emptyLayerOptions.setIsBaseLayer(true); //make it a baselayer.
        EmptyLayer emptyLayer = new EmptyLayer("Empty layer", emptyLayerOptions);

        Markers layer = new Markers("Example Marker");

        XYZOptions weatherOption = new XYZOptions();
        weatherOption.setIsBaseLayer(false);
        weatherOption.setSphericalMercator(true);

        XYZ clouds = new XYZ("clouds",
                "http://${s}.tile.openweathermap.org/map/clouds/${z}/${x}/${y}.png",
                weatherOption);
        clouds.setOpacity(70);
        XYZ precipitation = new XYZ("precipitation",
                "http://${s}.tile.openweathermap.org/map/precipitation/${z}/${x}/${y}.png",
                weatherOption);
        precipitation.setOpacity(70);

        WMTSOptions wmtsOptions = new WMTSOptions(url, "usa:states",
                "_null", "EPSG:900913");
        wmtsOptions.setName("States of the USA");
        wmtsOptions.setLayerOpacity(0.7);
        wmtsOptions.setIsBaseLayer(Boolean.FALSE);
        wmtsOptions.setFormat("image/png");

        String[] args = new String[31];

        for (int i = 0; i < 31; i++) {
            args[i] = "EPSG:900913:" + i;
        }

        wmtsOptions.setMatrixIds(args);
        WMTS wmtsLayer = new WMTS(wmtsOptions);

        //And add them to the map
        Map map = mapWidget.getMap();
        map.addLayer(road);
        map.addLayer(hybrid);
        map.addLayer(aerial);
        map.addLayer(gHybrid);
        map.addLayer(gNormal);
        map.addLayer(gSatellite);
        map.addLayer(gTerrain);
        map.addLayer(osm_1);
        map.addLayer(osm_2);
        map.addLayer(emptyLayer);
        map.addLayer(layer);
        map.addLayer(clouds);
        map.addLayer(precipitation);
        map.addLayer(wmtsLayer);

        for (Layer l : map.getLayers()) {
            System.out.println("##############HERE THE LAYER CLASS : " + l);
        }
    }

}
