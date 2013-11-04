/*
 * Copyright 2013 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.examples.basicgooglev3;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3MapType;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3Options;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class IssueWynamp extends AbstractExample {

    @Inject
    public IssueWynamp(ShowcaseExampleStore store) {
        super("Issue Wynamp", "Issue Wynamp",
                new String[]{"Google", "Wynamp"}, store);
    }

    @Override
    public void buildPanel() {
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        final MapWidget mapWidget = new MapWidget("500px", "500px",
                defaultMapOptions);

        GoogleV3Options gSatelliteOptions = new GoogleV3Options();
        gSatelliteOptions.setIsBaseLayer(true);
        gSatelliteOptions.setType(GoogleV3MapType.G_SATELLITE_MAP);
        gSatelliteOptions.setNumZoomLevels(22);
        GoogleV3 gSatellite = new GoogleV3("Google Satellite", gSatelliteOptions);

        mapWidget.getMap().addLayer(gSatellite);

        VectorOptions options = new VectorOptions();
        Vector vector = new Vector("layer1", options);

        mapWidget.getMap().addControl(new LayerSwitcher());

        final Point p1 = new Point(151.304485, -33.808831);
        p1.transform(new Projection("EPSG:4326"),
                new Projection(mapWidget.getMap().getProjection()));

        VectorFeature point1 = new VectorFeature(p1);

        final Point p2 = new Point(-106.356183, 35.842721);
        p2.transform(new Projection("EPSG:4326"),
                new Projection(mapWidget.getMap().getProjection()));

        VectorFeature point2 = new VectorFeature(p2);

        final Point p3 = new Point(0.24, 49.68);
        p3.transform(new Projection("EPSG:4326"),
                new Projection(mapWidget.getMap().getProjection()));

        VectorFeature point3 = new VectorFeature(p3);

        vector.addFeatures(new VectorFeature[]{point1, point2, point3});

        mapWidget.getMap().addLayer(vector);

        contentPanel.add(
                new HTML(
                        "<p>This example try to resolve Wynamp Issue</p>"));
        contentPanel.add(
                new InfoPanel(
                        "<p>Don't forget to add the following line to your HTML if you want to use Google V3. :</p>"
                        + "<p><b>&lt;script src=\"http://maps.google.com/maps/api/js?v=3&amp;sensor=false\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        mapWidget.getMap().setCenter(new LonLat(p1.getX(), p1.getY()), 17);

        final ListBox combo = new ListBox();
        combo.addItem("Point 1");
        combo.addItem("Point 2");
        combo.addItem("Point 3");

        combo.addChangeHandler(new ChangeHandler() {

            public void onChange(ChangeEvent event) {
                String selectedValue = combo.getValue(combo.getSelectedIndex());
                if (selectedValue.equals("Point 1")) {
                    mapWidget.getMap().panTo(new LonLat(p1.getX(), p1.getY()));
                } else if (selectedValue.equals("Point 2")) {
                    Bounds b = new Bounds();
                    b.extend(new LonLat(p2.getX(), p2.getY()));
                    mapWidget.getMap().zoomToExtent(b);
                } else {
                    mapWidget.getMap().panTo(new LonLat(p3.getX(), p3.getY()));
                }
            }

        });

        contentPanel.add(combo);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/basicgooglev3/"
                + "IssueWynamp.txt";
    }

}
