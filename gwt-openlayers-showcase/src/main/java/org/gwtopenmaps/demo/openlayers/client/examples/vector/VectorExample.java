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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
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
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

public class VectorExample extends AbstractExample {

    @Inject
    public VectorExample(ShowcaseExampleStore store) {
        super("Selectable vector example",
              "Demonstrates how to add Vector data to the map and make it selectable. Also shows how to have a different style for a selected feature.",
              new String[]{"marker", "feature", "selectable", "vector", "style", "stylemap",
                  "line", "VectorFeatureSelectedListener"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326")); //causes the mouse popup to display coordinates in this format
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        //Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://labs.metacarta.com/wms/vmap0";

        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        //Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);

        //Add a clickable vectors to the map

        //create a layer to add the vectors to
        final Vector vectorLayer = new Vector("Vectorlayer");
        map.addLayer(vectorLayer);

        //SelectFeature control to capture clicks on the vectors
        SelectFeature selectFeature = new SelectFeature(vectorLayer);
        selectFeature.setAutoActivate(true);
        map.addControl(selectFeature);

        //Define a style for the vectors
        Style style = new Style();
        style.setFillColor("red");
        style.setStrokeColor("green");
        style.setStrokeWidth(2);
        style.setFillOpacity(0.9);
        Style selectedStyle = new Style();
        selectedStyle.setFillColor("yellow");
        selectedStyle.setStrokeColor("yellow");
        selectedStyle.setStrokeWidth(2);
        selectedStyle.setFillOpacity(0.9);

        StyleMap styleMap = new StyleMap(style, selectedStyle, style);
        vectorLayer.setStyleMap(styleMap);

        /* or if you want to use an image
         pointStyle.setExternalGraphic("http://photo-dictionary.com/photofiles/list/3020/4043yellow_marker.jpg");
         pointStyle.setGraphicSize(50, 50);
         */

        //Add a point
        Point point = new Point(146.7, -41.8);
        VectorFeature pointFeature = new VectorFeature(point);
        vectorLayer.addFeature(pointFeature);

        //Add a line
        Point[] linePoints = {new Point(145, -40), new Point(147, 42)};
        LineString ls = new LineString(linePoints);
        vectorLayer.addFeature(new VectorFeature(ls));

        //capture clicks on the vectorlayer
        vectorLayer.addVectorFeatureSelectedListener(new VectorFeatureSelectedListener() {
            public void onFeatureSelected(FeatureSelectedEvent eventObject) {
                Window.alert("selected a vector");
            }
        });

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(146.7, -41.8), 6);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a Vector marker, and a line to the map.</p>" +
                "<p>Note that you can also use the Marker class to add markers, but it is advised to use this method instead.<p>" +
                "<p>Click on a vector to select it.<BR/>" +
                "<UL><LI>Click outside a vector to deselect it." +
                "<LI>When a feature gets selected a Window.alert pops up, and the feature turns yellow." +
                "<LI>Note that a feature doesn't get reselected when clicking on it when it was allready selected. So clicking multiple times on the same feature will not show multiple Window.alert popups." +
                "</UL></p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "VectorExample.txt";
    }
}
