/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.demo.openlayers.client.examples.click;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
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
import org.gwtopenmaps.openlayers.client.event.MapClickListener;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3MapType;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3Options;

public class ClickExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public ClickExample(ShowcaseExampleStore store) {
        super("Get coordinates on click example",
                "Demonstrates the use of a click event handler, and how to convert pixels to coordinates.",
                new String[]{"click", "event", "coordinates"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        //Create some Google Layers
        GoogleV3Options gNormalOptions = new GoogleV3Options();
        gNormalOptions.setIsBaseLayer(true);
        gNormalOptions.setType(GoogleV3MapType.G_NORMAL_MAP);
        GoogleV3 gNormal = new GoogleV3("Google Normal", gNormalOptions);

        //And add them to the map
        final Map map = mapWidget.getMap();
        map.addLayer(gNormal);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(6.95, 50.94);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 12);

        map.addMapClickListener(new MapClickListener() {

            public void onClick(MapClickListener.MapClickEvent mapClickEvent) {
                LonLat lonLat = mapClickEvent.getLonLat();

                lonLat.transform(map.getProjection(), DEFAULT_PROJECTION.getProjectionCode()); //transform lonlat to more readable format

                Window.alert("LonLat = (" + lonLat.lon() + " ; " + lonLat.lat() + ")");
            }

        });

        contentPanel.add(
                new HTML(
                        "<p>This example shows how to listen for clicks on the map, and display the clicked coordinates.</p>"));
        contentPanel.add(
                new InfoPanel(
                        "<p>Don't forget to add the following line to your HTML if you want to use Google V3. :</p>"
                        + "<p><b>&lt;script src=\"http://maps.google.com/maps/api/js?v=3&amp;sensor=false\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/click/"
                + "ClickExample.txt";
    }

}
