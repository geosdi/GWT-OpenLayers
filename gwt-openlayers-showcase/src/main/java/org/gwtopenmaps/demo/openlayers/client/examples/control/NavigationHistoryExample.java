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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.control.Navigation;
import org.gwtopenmaps.openlayers.client.control.NavigationHistory;
import org.gwtopenmaps.openlayers.client.event.ControlActivateListener;
import org.gwtopenmaps.openlayers.client.event.ControlActivateListener.ControlActivateEvent;
import org.gwtopenmaps.openlayers.client.event.ControlDeactivateListener;
import org.gwtopenmaps.openlayers.client.event.ControlDeactivateListener.ControlDeactivateEvent;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class NavigationHistoryExample implements ShowcaseExample {

    private MapExample example;
    private WMS wmsLayer;
    private NavigationHistory nav;
    private Button next = new Button("next");
    private Button previous = new Button("previous");

    public NavigationHistoryExample() {
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

        example.getMap().addControl(new Navigation());

        nav = new NavigationHistory();

        example.getMap().addControl(nav);

        Control prev = nav.getPrevious();

        prev.addControlActivateListener(new ControlActivateListener() {

            public void onActivate(ControlActivateEvent eventObject) {
                // TODO Auto-generated method stub
                previous.setEnabled(true);
            }
        });

        prev.addControlDeactivateListener(new ControlDeactivateListener() {

            public void onDeactivate(ControlDeactivateEvent eventObject) {
                // TODO Auto-generated method stub
                previous.setEnabled(false);
            }
        });

        Control nextControl = nav.getNext();

        nextControl.addControlActivateListener(new ControlActivateListener() {

            public void onActivate(ControlActivateEvent eventObject) {
                // TODO Auto-generated method stub
                next.setEnabled(true);
            }
        });

        nextControl.addControlDeactivateListener(new ControlDeactivateListener() {

            public void onDeactivate(ControlDeactivateEvent eventObject) {
                // TODO Auto-generated method stub
                next.setEnabled(false);
            }
        });

        next.setEnabled(false);
        previous.setEnabled(false);

        next.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                // TODO Auto-generated method stub
                nav.nextTrigger();
            }
        });

        previous.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                // TODO Auto-generated method stub
                nav.previousTrigger();
            }
        });

        Grid buttonGrid = new Grid(1, 2);
        buttonGrid.setWidget(0, 0, previous);
        buttonGrid.setWidget(0, 1, next);
        example.add(buttonGrid, DockPanel.SOUTH);
    }

    public MapExample getMapExample() {
        return this.example;
    }
}
