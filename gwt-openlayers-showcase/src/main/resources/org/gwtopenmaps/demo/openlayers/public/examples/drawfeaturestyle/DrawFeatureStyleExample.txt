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
package org.gwtopenmaps.demo.openlayers.client.examples.drawfeaturestyle;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.DrawFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.handler.PathHandlerOptions;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

public class DrawFeatureStyleExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public DrawFeatureStyleExample(ShowcaseExampleStore store) {
        super("DrawFeature style example", "Show how to change the style of the DrawFeature",
              new String[]{"style", "drawfeature"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget and add 2 OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm_1 = OSM.Mapnik("Mapnik");
        osm_1.setIsBaseLayer(true);
        Map map = mapWidget.getMap();
        map.addLayer(osm_1);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(6.95, 50.94);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 7);
        
        // Create the Vector layer on which the user can draw new widgets
        final Vector vectorLayer = new Vector("Vector layer");
        map.addLayer(vectorLayer);
        
        //Create a style. We want a blue dashed line.
        final Style drawStyle = new Style(); //create a Style to use
        drawStyle.setFillColor("white");
        drawStyle.setGraphicName("x");
        drawStyle.setPointRadius(4);
        drawStyle.setStrokeWidth(3);
        drawStyle.setStrokeColor("#66FFFF");
        drawStyle.setStrokeDashstyle("dash");
        
        //create a StyleMap using the Style
        StyleMap drawStyleMap = new StyleMap(drawStyle);
        
        //Create PathHanlderOptions using this StyleMap
        PathHandlerOptions phOpt = new PathHandlerOptions();
        phOpt.setStyleMap(drawStyleMap);   
        
        //Create DrawFeatureOptions and set the PathHandlerOptions (that have the StyleMap, that have the Style we wish)
        DrawFeatureOptions drawFeatureOptions = new DrawFeatureOptions();
        drawFeatureOptions.setHandlerOptions(phOpt);
        
        PathHandler pathHanlder = new PathHandler();

        // Create the DrawFeature control to draw on the map, and pass the DrawFeatureOptions to control the style of the sketch
        final DrawFeature drawLine = new DrawFeature(vectorLayer, pathHanlder, drawFeatureOptions);
        map.addControl(drawLine);
        drawLine.activate();


        contentPanel.add(
                new HTML(
                "<p>This example shows style the DrawFeature</p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/drawfeaturestyle/"
                + "DrawFeatureStyleExample.txt";
    }
}