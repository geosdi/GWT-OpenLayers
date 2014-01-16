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
package org.gwtopenmaps.demo.openlayers.client.examples.cluster;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.strategy.ClusterStrategy;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * Displays the usage of the Cluster Strategy.
 * @author http://www.fks.be / Frank Wynants
 *
 */

public class ClusterStrategyTreshHoldExample extends AbstractExample {

    @Inject
    public ClusterStrategyTreshHoldExample(ShowcaseExampleStore store) {
        super("Cluster Strategy Threshold",
              "Demonstrates the use of the cluster strategy threshold property",
              new String[]{"WMS", "cluster", "treshold", "strategy"}, store);
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

        String wmsUrl = "http://vmap0.tiles.osgeo.org/wms/vmap0";

        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        //Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);

        //create a semi-random grid of features to be clustered
        int dx = 3;
        int dy = 3;
        final List<Point> points = new ArrayList<Point>();

        for (int x = -45; x <= 45; x += dx) {
            for (double y = -22.5; y <=22.5 ; y += dy) {
                double px = (x + (2 * dx * (Math.random() - 0.5)));
                double py = (y + (2 * dy * (Math.random() - 0.5)));

                points.add(new Point(px, py));
            }
        }

        ClusterStrategy clusterStrategy = new ClusterStrategy();
        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setStrategies(new Strategy[]{clusterStrategy});
        Vector vectorLayer = new Vector("Clusters", vectorOptions);
        clusterStrategy.setDistance(20);
        clusterStrategy.setThreshold(10);

        VectorFeature[] features = new VectorFeature[points.size()];
        for (int i = 0 ; i< points.size() ; i++) {
            features[i] = new VectorFeature(points.get(i));
        }

        clusterStrategy.setFeatures(features);
        for (Point point : points) vectorLayer.addFeature(new VectorFeature(point));

        map.addLayer(vectorLayer);


        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 2);

        contentPanel.add(
                new HTML(
                "<p>This the usage of the Cluster strategy.</p>In this example distance is set on 20, treshold on 10.<br/>When zooming in/out you will see more or less features."));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/cluster/"
                + "ClusterStrategyTreshHoldExample.txt";
    }
}
