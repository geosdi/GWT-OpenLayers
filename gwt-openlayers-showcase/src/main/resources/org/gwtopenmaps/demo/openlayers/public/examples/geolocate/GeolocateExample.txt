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
package org.gwtopenmaps.demo.openlayers.client.examples.geolocate;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import org.gwtopenmaps.openlayers.client.control.Geolocate;
import org.gwtopenmaps.openlayers.client.control.GeolocateOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.LocationFailedEvent;
import org.gwtopenmaps.openlayers.client.event.LocationFailedListener;
import org.gwtopenmaps.openlayers.client.event.LocationUncapableListener;
import org.gwtopenmaps.openlayers.client.event.LocationUpdateEvent;
import org.gwtopenmaps.openlayers.client.event.LocationUpdateListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GeolocateExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");
    private Style pointStyle;
    private Style circleStyle;
    private Vector vector;

    @Inject
    public GeolocateExample(ShowcaseExampleStore store) {
        super("Openlayers Geolocate example",
                "Demonstrates how to display the users current location on the map "
                + "using Openlayers.",
                new String[]{"gps", "locate", "geolocate", "osm"}, store);

        setUpPointStyle();
        setUpCircleStyle();
    }

    @Override
    public void buildPanel() {
        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget and add 2 OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM cycleMap = OSM.CycleMap("CycleMap");
        cycleMap.setIsBaseLayer(true);
        final Map map = mapWidget.getMap();
        map.addLayer(cycleMap);

        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new ScaleLine()); // Display the scaleline

        LonLat lonLat = new LonLat(-71.147, 42.472);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                map.getProjection());

        map.setCenter(lonLat, 16);

        this.vector = new Vector("Vector layer");

        map.addLayer(vector);

        GeolocateOptions geoLocateOptions = new GeolocateOptions();
        geoLocateOptions.setEnableHighAccuracy(false);
        geoLocateOptions.setMaximumAge(0);
        geoLocateOptions.setTimeout(7000);

        final Geolocate geolocate = new Geolocate(geoLocateOptions);
        geolocate.setBind(false);

        map.addControl(geolocate);

        geolocate.addLocationFailedListener(new LocationFailedListener() {

            public void onLocationFailed(LocationFailedEvent eventObject) {
                Window.alert("ERROR @@@@@@@@@@@@ " + eventObject.
                        getError());
            }

        });

        geolocate.addLocationUncapableListener(new LocationUncapableListener() {

            public void onLocationUncapable() {
                Window.alert("No GeoLocation support available "
                        + "in this browser.");
            }

        });

        geolocate.addLocationUpdateListener(new LocationUpdateListener() {

            public void onLocationUpdate(LocationUpdateEvent eventObject) {
                // lets create a vector point on the location

                Point p = eventObject.getPoint();

                VectorFeature circle = new VectorFeature(Polygon.
                        createRegularPolygon(p, eventObject.getPosition().
                        getCoords().getAccuracy() / 2, 40, 0), circleStyle);


                VectorFeature vectorFeature = new VectorFeature(p, pointStyle);

                vector.addFeatures(new VectorFeature[]{circle, vectorFeature});

                map.zoomToExtent(vector.getDataExtent());
            }

        });

        contentPanel.add(
                new HTML(
                "<p>This example shows how to display a marker on the users current location.</p>"
                + "<p>This actually uses the Openlayers Geolocate Control and displays a marker "
                + "on the returned location."));
        contentPanel.add(
                new InfoPanel(
                "<p>Don't forget to add the following line to your html file if you want to use OSM :</p>"
                + "<p><b>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        Button locate = new Button("Locate", new ClickHandler() {

            public void onClick(ClickEvent event) {
                geolocate.deactivate();
                vector.destroyFeatures();
                geolocate.activate();
            }

        });

        contentPanel.add(locate);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/geolocate/"
                + "GeolocateExample.txt";
    }

    private void setUpPointStyle() {
        this.pointStyle = new Style();
        pointStyle.setGraphicName("cross");
        pointStyle.setStrokeColor("#f00");
        pointStyle.setStrokeWidth(2);
        pointStyle.setFillOpacity(0);
        pointStyle.setPointRadius(10);
    }

    private void setUpCircleStyle() {
        this.circleStyle = new Style();
        circleStyle.setFillColor("#000");
        circleStyle.setFillOpacity(0.1);
        circleStyle.setStrokeWidth(0);
    }

}
