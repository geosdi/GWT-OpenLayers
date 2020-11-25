/**
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
package org.gwtopenmaps.demo.openlayers.client.examples.basicbing;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.Bing;
import org.gwtopenmaps.openlayers.client.layer.BingOptions;
import org.gwtopenmaps.openlayers.client.layer.BingType;
import org.gwtopenmaps.openlayers.client.protocol.ProtocolType;

public class BasicBingExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public BasicBingExample(ShowcaseExampleStore store) {
        super("Basic Bing example", "Demonstrates the use of Bing layers.",
              new String[]{"Bing", "Microsoft", "Virtual Earth", "basic"},
              store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
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

        //And add them to the map
        Map map = mapWidget.getMap();
        map.addLayer(road);
        map.addLayer(hybrid);
        map.addLayer(aerial);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(6.95, 50.94);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 12);

        contentPanel.add(new HTML(
                "<p>This example shows how to add Bing layers to GWT-OL.</p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/basicbing/"
                + "BasicBingExample.txt";
    }
}
