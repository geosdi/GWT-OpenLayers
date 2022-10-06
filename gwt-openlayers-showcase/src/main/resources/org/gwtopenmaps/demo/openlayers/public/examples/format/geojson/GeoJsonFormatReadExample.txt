/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.demo.openlayers.client.examples.format.geojson;

import com.google.gwt.core.client.GWT;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.format.GeoJSON;
import org.gwtopenmaps.openlayers.client.layer.*;

import javax.inject.Inject;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GeoJsonFormatReadExample extends AbstractExample {

    private GeoJSON geoJsonFormat = new GeoJSON();

    @Inject
    public GeoJsonFormatReadExample(ShowcaseExampleStore store) {
        super("Read GeoJson Geometry and create a Vector Layer",
                "Demonstrates how to read a GeoJson Geometry and create a Vector Layer.",
                new String[]{"Geometry", "GeoJson Format"}, store);
    }

    @Override
    public void buildPanel() {
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget
        MapWidget mapWidget = new MapWidget("514px", "258px", defaultMapOptions);
        // Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://vmap0.tiles.osgeo.org/wms/vmap0";
        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        // Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);
        map.setCenter(new LonLat(5, 40), 3);

        // Create the Vector layer on which the user can draw new widgets
        final Vector vectorLayer = new Vector("Vector layer");
        map.addLayer(vectorLayer);

        String featureCollectionAsString = "{\n" +
                "              \"type\": \"FeatureCollection\", \n" +
                "              \"features\": [\n" +
                "                {\"geometry\": {\n" +
                "                    \"type\": \"GeometryCollection\", \n" +
                "                    \"geometries\": [\n" +
                "                        {\n" +
                "                            \"type\": \"LineString\", \n" +
                "                            \"coordinates\": \n" +
                "                                [[11.0878902207, 45.1602390564], \n" +
                "                                [15.01953125, 48.1298828125]]\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"type\": \"Polygon\", \n" +
                "                            \"coordinates\": \n" +
                "                                [[[11.0878902207, 45.1602390564], \n" +
                "                                  [14.931640625, 40.9228515625], \n" +
                "                                  [0.8251953125, 41.0986328125], \n" +
                "                                  [7.63671875, 48.96484375], \n" +
                "                                  [11.0878902207, 45.1602390564]]]\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"type\":\"Point\", \n" +
                "                            \"coordinates\":[15.87646484375, 44.1748046875]\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }, \n" +
                "                \"type\": \"Feature\", \n" +
                "                \"properties\": {}}\n" +
                "              ]\n" +
                "           }";

        vectorLayer.addFeatures(this.geoJsonFormat.read(featureCollectionAsString));
        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        contentPanel.add(mapWidget);
        initWidget(contentPanel);
        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/format/geojson/"
                + "GeoJsonFormatReadExample.txt";
    }
}
