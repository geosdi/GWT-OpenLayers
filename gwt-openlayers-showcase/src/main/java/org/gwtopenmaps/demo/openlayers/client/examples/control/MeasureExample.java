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
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ToggleButton;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.Measure;
import org.gwtopenmaps.openlayers.client.control.MeasureOptions;
import org.gwtopenmaps.openlayers.client.control.Navigation;
import org.gwtopenmaps.openlayers.client.event.MeasureEvent;
import org.gwtopenmaps.openlayers.client.event.MeasureListener;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class MeasureExample implements ShowcaseExample {

    private MapExample example;
    private WMS wmsLayer;
    private ToggleButton distanceButton = new ToggleButton(
            "Activate Distance Measurement");
    private ToggleButton areaButton = new ToggleButton(
            "Activate Area Measurement");
    private TextArea measureResult = new TextArea() {

        {
            this.setHeight("2em");
            this.setWidth("100%");
            this.setEnabled(false);
        }
    };
    private Measure measure;
    private Measure measureArea;

    public MeasureExample() {
        example = new MapExample();

        // Add a WMS layer for a little background
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        // Center and Zoom
        double lon = 4.0;
        double lat = 5.0;
        int zoom = 5;

        wmsLayer = new WMS("Basic WMS", BasicWMS.WMS_URL, wmsParams);

        example.getMap().addLayers(new Layer[]{wmsLayer});
        example.getMap().setCenter(new LonLat(lon, lat), zoom);

        MeasureOptions measOpts = new MeasureOptions();
        measOpts.setPersist(true);

        this.measure = new Measure(new PathHandler(), measOpts);
        this.measureArea = new Measure(new PolygonHandler(), measOpts);

        example.getMap().addControl(measure);
        example.getMap().addControl(measureArea);
        example.getMap().addControl(new Navigation());
        example.add(measureResult, DockPanel.SOUTH);

        this.measure.addMeasureListener(new MeasureListener() {

            public void onMeasure(MeasureEvent eventObject) {
                // TODO Auto-generated method stub
                System.out.println("TEST ************ " + wmsLayer.getZIndex());
                measureResult.setText("Distance is " + eventObject.getMeasure()
                        + " " + eventObject.getUnits());
            }
        });

        this.measureArea.addMeasureListener(new MeasureListener() {

            public void onMeasure(MeasureEvent eventObject) {
                // TODO Auto-generated method stub

                measureResult.setText(
                        "Area is " + eventObject.getMeasure() + " " + eventObject.getUnits() + "^2");
            }
        });

        distanceButton.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent arg0) {
                // TODO Auto-generated method stub
                if (distanceButton.isDown()) {
                    measure.activate();
                    measureArea.deactivate();
                    areaButton.setDown(false);
                } else {
                    measure.deactivate();
                }
            }
        });

        areaButton.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent arg0) {
                // TODO Auto-generated method stub
                if (areaButton.isDown()) {
                    measureArea.activate();
                    measure.deactivate();
                    distanceButton.setDown(false);
                } else {
                    measureArea.deactivate();
                }
            }
        });

        // Adding the button to the example
        Grid buttonGrid = new Grid(2, 2);
        buttonGrid.setWidget(0, 0, distanceButton);
        buttonGrid.setWidget(0, 1, areaButton);
        example.add(buttonGrid, DockPanel.SOUTH);

    }

    public MapExample getMapExample() {
        // TODO Auto-generated method stub
        return example;
    }
}
