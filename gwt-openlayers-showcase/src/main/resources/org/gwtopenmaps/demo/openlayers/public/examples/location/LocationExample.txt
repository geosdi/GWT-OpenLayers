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
package org.gwtopenmaps.demo.openlayers.client.examples.location;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
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
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;

public class LocationExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public LocationExample(ShowcaseExampleStore store) {
        super("GPS location example",
              "Demonstrates how to display the users current location on the map",
              new String[]{"gps", "location", "osm"}, store);
    }

    @Override
    public void buildPanel() {
        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget and add 2 OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm_1 = OSM.Mapnik("Mapnik");
        OSM osm_2 = OSM.CycleMap("CycleMap");
        osm_1.setIsBaseLayer(true);
        osm_2.setIsBaseLayer(true);
        final Map map = mapWidget.getMap();
        map.addLayer(osm_1);
        map.addLayer(osm_2);

        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        // Center and zoom to a location
        LonLat lonLat = new LonLat(6.95, 50.94);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); // transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 18);

        // Create a marker layer to the current location marker
        final Vector markerLayer = new Vector("Marker layer");
        map.addLayer(markerLayer);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to display a marker on the users current location.</p>"
                + "<p>This actually just uses the GWT GeoLocation class and displays a marker on the returned location."));
        contentPanel.add(
                new InfoPanel(
                "<p>Don't forget to add the following line to your html file if you want to use OSM :</p>"
                + "<p><b>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);
        Button locationButton = new Button("Go to current location",
                                           new ClickHandler() {
            public void onClick(ClickEvent event) {
                // Start GeoLocation stuff (note that the GeoLocation is just plain GWT stuff)
                Geolocation geoLocation = Geolocation.getIfSupported();
                if (geoLocation == null) {
                    Window.alert(
                            "No GeoLocation supprt available in this browser :-(");
                } else {
                    final Geolocation.PositionOptions geoOptions = new Geolocation.PositionOptions();
                    geoOptions.setHighAccuracyEnabled(true);

                    geoLocation.watchPosition(new Callback<Position, PositionError>() {
                        public void onFailure(final PositionError reason) {
                            Window.alert(
                                    "Something went wrong fetching the geolocation:\n" + reason);
                        }

                        public void onSuccess(final Position result) {
                            // put the received result in an openlayers LonLat
                            // object
                            final LonLat lonLat = new LonLat(
                                    result.getCoordinates().getLongitude(),
                                    result.getCoordinates().getLatitude());
                            lonLat.transform(
                                    DEFAULT_PROJECTION.getProjectionCode(),
                                    map.getProjection()); // transform lonlat to OSM coordinate system
                            // Center the map on the received location
                            map.setCenter(lonLat);

                            // lets create a vector point on the location
                            Style pointStyle = new Style();
                            pointStyle.setFillColor("red");
                            pointStyle.setStrokeColor("green");
                            pointStyle.setStrokeWidth(2);
                            pointStyle.setFillOpacity(0.9);

                            final Point point = new Point(
                                    result.getCoordinates().getLongitude(),
                                    result.getCoordinates().getLatitude());
                            point.transform(DEFAULT_PROJECTION,
                                            new Projection(map.getProjection())); // transform point to OSM coordinate system
                            final VectorFeature pointFeature = new VectorFeature(
                                    point, pointStyle);
                            markerLayer.destroyFeatures();
                            markerLayer.addFeature(pointFeature);
                        }
                    }, geoOptions);
                }
            }
        });
        contentPanel.add(locationButton);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/location/"
                + "LocationExample.txt";
    }
}
