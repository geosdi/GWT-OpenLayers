/*
 * Copyright 2011 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.examples.control;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.EditingToolbar;
import org.gwtopenmaps.openlayers.client.control.MouseDefaults;
import org.gwtopenmaps.openlayers.client.control.Snapping;
import org.gwtopenmaps.openlayers.client.control.SnappingOptions;
import org.gwtopenmaps.openlayers.client.control.SnappingTarget;
import org.gwtopenmaps.openlayers.client.format.GeoJSON;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.protocol.HTTPProtocol;
import org.gwtopenmaps.openlayers.client.protocol.HTTPProtocolOptions;
import org.gwtopenmaps.openlayers.client.strategy.FixedStrategy;
import org.gwtopenmaps.openlayers.client.strategy.FixedStrategyOptions;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class SnappingExample implements ShowcaseExample {

    private MapExample example;
    private Vector pointLayer;
    private Vector lineLayer;
    private Vector polyLayer;
    private CheckBox polyCheck = new CheckBox("Snap to poly");
    private CheckBox pointCheck = new CheckBox("Snap to point");
    private CheckBox lineCheck = new CheckBox("Snap to line");

    public SnappingExample() {
        example = new MapExample();

        // Center and Zoom
        double lon = 0.0;
        double lat = 0.0;
        int zoom = 1;

        pointLayer = JsonLayerCreator.createLayerFromJson("Point Layer",
                "data/point.json", true);
        lineLayer = JsonLayerCreator.createLayerFromJson("Line Layer",
                "data/line.json", false);
        polyLayer = JsonLayerCreator.createLayerFromJson("Polygon Layer",
                "data/poly.json", false);
        Vector drawLayer = new Vector("Drawing Layer");

        // Vector[] targets = new Vector[]{polyLayer,lineLayer,pointLayer};

        final SnappingTarget poly = new SnappingTarget();
        final SnappingTarget line = new SnappingTarget();
        final SnappingTarget point = new SnappingTarget();

        poly.setLayer(polyLayer);
        line.setLayer(lineLayer);
        point.setLayer(pointLayer);

        SnappingTarget[] targets = new SnappingTarget[]{poly, line, point};

        SnappingOptions snappingOpts = new SnappingOptions();
        snappingOpts.setGreedy(true);
        snappingOpts.setLayer(drawLayer);
        snappingOpts.setTargets(targets);

        final Snapping snap = new Snapping(snappingOpts);
        snap.activate();

        example.getMap().addLayers(
                new Layer[]{pointLayer, lineLayer, polyLayer, drawLayer});

        example.getMap().setCenter(new LonLat(lon, lat), zoom);
        example.getMap().addControl(new MouseDefaults());
        example.getMap().addControl(snap);
        example.getMap().addControl(new EditingToolbar(drawLayer));

        polyCheck.setValue(Boolean.TRUE);
        lineCheck.setValue(Boolean.TRUE);
        pointCheck.setValue(Boolean.TRUE);

        polyCheck.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent arg0) {
                // TODO Auto-generated method stub
                if (polyCheck.getValue()) {
                    snap.addTarget(poly);
                } else {
                    snap.removeTarget(poly);
                }
            }
        });

        lineCheck.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent arg0) {
                // TODO Auto-generated method stub
                if (lineCheck.getValue()) {
                    snap.addTarget(line);
                } else {
                    snap.removeTarget(line);
                }
            }
        });

        pointCheck.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent arg0) {
                // TODO Auto-generated method stub
                if (pointCheck.getValue()) {
                    snap.addTarget(point);
                } else {
                    snap.removeTarget(point);
                }
            }
        });

        Grid buttonGrid = new Grid(3, 3);
        buttonGrid.setWidget(0, 0, polyCheck);
        buttonGrid.setWidget(1, 0, pointCheck);
        buttonGrid.setWidget(2, 0, lineCheck);
        example.add(buttonGrid, DockPanel.SOUTH);
    }

    public MapExample getMapExample() {
        return this.example;
    }

    public static class JsonLayerCreator {

        public static Vector createLayerFromJson(String layerName, String url,
                boolean isBaseLayer) {

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
            options.setIsBaseLayer(isBaseLayer);

            return new Vector(layerName, options);
        }
    }
}
