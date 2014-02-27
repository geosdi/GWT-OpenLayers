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
package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

public class WellKnownGraphicExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");


    @Inject
    public WellKnownGraphicExample(ShowcaseExampleStore store) {
        super("Well known graphic example",
              "Demonstrates the use off well known graphics, and how to add a graphic to the well known graphics",
              new String[]{"feature", "vector", "style", "stylemap", "graphic", "well-known", "wellknown"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        //Create a OSM layer as base layer
        OSM osm = OSM.Mapnik("Mapnik");
        osm.setIsBaseLayer(true);

        //Add the OSM to the map
        Map map = mapWidget.getMap();
        map.addLayer(osm);

        //create a layer to add the vectors to
        final Vector vectorLayer = new Vector("Vectorlayer");
        map.addLayer(vectorLayer);

        //Define a style for point 1, this is a well-known built in graphic with the name star
        Style style = new Style();
        style.setGraphicName("star");
        style.setStrokeColor("green");
        style.setStrokeWidth(1);
        style.setFillOpacity(0.9);
        style.setPointRadius(20);

        //Add a point
        LonLat ll1 = new LonLat(140, -41.8);
        ll1.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        Point point = new Point(ll1.lon(), ll1.lat());
        VectorFeature pointFeature = new VectorFeature(point, style);
        vectorLayer.addFeature(pointFeature);

        //For the second point, we manually create a well-known graphic, and then use it.
        int[] points = new int[]{0, 0, 4, 2, 6, 0, 10, 5, 6, 3, 4, 5, 0, 0};
        OpenLayers.addWellKnownGraphic(points, "kaboom");
        Style style2 = new Style();
        style2.setGraphicName("kaboom");
        style2.setStrokeColor("green");
        style2.setStrokeWidth(1);
        style2.setFillOpacity(0.9);
        style2.setPointRadius(20);

        LonLat ll2 = new LonLat(150, -41.8);
        ll2.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        Point point2 = new Point(ll2.lon(), ll2.lat());
        VectorFeature pointFeature2 = new VectorFeature(point2, style2);
        vectorLayer.addFeature(pointFeature2);


        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat llCenter = (new LonLat(146.7, -41.8));
        llCenter.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        map.setCenter(llCenter, 4);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a Vector to the map with a pre-defined well-known graphic, and with a newly created well-known graphic</p>" +
                "<p>For more info about how to draw well-known graphic object check " +
                "<A TARGET='_BLANK' HREF='https://plus.google.com/104715080777872762852/posts/baRGTS2yFbh'>" +
                		"https://plus.google.com/104715080777872762852/posts/baRGTS2yFbh" +
        		"</A></p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "WellKnownGraphicExample.txt";
    }
}
