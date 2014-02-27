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

import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
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
import org.gwtopenmaps.openlayers.client.filter.ComparisonFilter;
import org.gwtopenmaps.openlayers.client.filter.ComparisonFilter.Types;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.popup.FramedCloud;
import org.gwtopenmaps.openlayers.client.popup.Popup;
import org.gwtopenmaps.openlayers.client.strategy.AnimatedClusterStrategy;
import org.gwtopenmaps.openlayers.client.strategy.AnimatedClusterStrategyOptions;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;
import org.gwtopenmaps.openlayers.client.style.Rule;
import org.gwtopenmaps.openlayers.client.style.SymbolizerPoint;
import org.gwtopenmaps.openlayers.client.util.Attributes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.HTML;

/**
 * Displays the usage of the Cluster Strategy.
 *
 * @author http://www.fks.be / Frank Wynants
 *
 */

public class AnimatedClusterWithPopup extends AbstractExample
{

    @Inject
    public AnimatedClusterWithPopup(ShowcaseExampleStore store)
    {
        super("Animated cluster with popup", "Demonstrates the use of the animated cluster strategy, in combination with a popup",
                new String[]
                { "WMS", "cluster", "animated", "treshold", "strategy", "style", "filter", "popup" }, store);
    }

    @Override
    public void buildPanel()
    {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326")); // causes
                                                                             // the
                                                                             // mouse
                                                                             // popup
                                                                             // to
                                                                             // display
                                                                             // coordinates
                                                                             // in
                                                                             // this
                                                                             // format
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        // Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://vmap0.tiles.osgeo.org/wms/vmap0";

        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        // Add the WMS to the map
        final Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);

        // create a semi-random grid of features to be clustered
        int dx = 3;
        int dy = 3;
        final List<Point> points = new ArrayList<Point>();

        for (int x = -45; x <= 45; x += dx)
        {
            for (double y = -22.5; y <= 22.5; y += dy)
            {
                double px = (x + (2 * dx * (Math.random() - 0.5)));
                double py = (y + (2 * dy * (Math.random() - 0.5)));

                Point point = new Point(px, py);
                points.add(point);
            }
        }

        Rule[] rules = new Rule[3];

        rules[0] = new Rule();
        ComparisonFilter filter0 = new ComparisonFilter();
        filter0.setType(Types.LESS_THAN);
        filter0.setProperty("count");
        filter0.setNumberValue(5);

        SymbolizerPoint symbolizer0 = new SymbolizerPoint();
        symbolizer0.setFillColor("green");
        symbolizer0.setFillOpacity(0.9);
        symbolizer0.setStrokeColor("green");
        symbolizer0.setStrokeOpacity(0.5);
        symbolizer0.setStrokeWidth(12);
        symbolizer0.setPointRadius(10);
        rules[0].setFilter(filter0);
        rules[0].setSymbolizer(symbolizer0);

        rules[1] = new Rule();
        ComparisonFilter filter1 = new ComparisonFilter();
        filter1.setType(Types.BETWEEN);
        filter1.setProperty("count");
        filter1.setNumberLowerBoundary(5);
        filter1.setNumberUpperBoundary(20);
        SymbolizerPoint symbolizer1 = new SymbolizerPoint();
        symbolizer1.setFillColor("orange");
        symbolizer1.setFillOpacity(0.9);
        symbolizer1.setStrokeColor("orange");
        symbolizer1.setStrokeOpacity(0.5);
        symbolizer1.setStrokeWidth(12);
        symbolizer1.setPointRadius(10);
        rules[1].setFilter(filter1);
        rules[1].setSymbolizer(symbolizer1);

        rules[2] = new Rule();
        ComparisonFilter filter2 = new ComparisonFilter();
        filter2.setType(Types.GREATER_THAN);
        filter2.setProperty("count");
        filter2.setNumberValue(20);
        SymbolizerPoint symbolizer2 = new SymbolizerPoint();
        symbolizer2.setFillColor("red");
        symbolizer2.setFillOpacity(0.9);
        symbolizer2.setStrokeColor("red");
        symbolizer2.setStrokeOpacity(0.5);
        symbolizer2.setStrokeWidth(12);
        symbolizer2.setPointRadius(10);
        rules[2].setFilter(filter2);
        rules[2].setSymbolizer(symbolizer2);

        Style style = new Style();
        style.setLabel("${count}");
        style.setFontColor("#FFFFFF");
        style.setFontSize("20px");

        final StyleMap styleMap = new StyleMap(style);
        styleMap.addRules(rules, "default");

        AnimatedClusterStrategy animatedClusterStrategy = new AnimatedClusterStrategy(new AnimatedClusterStrategyOptions());
        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setStrategies(new Strategy[]
        { animatedClusterStrategy });
        vectorOptions.setRenderers(new String[]
        { "Canvas", "SVG" });
        Vector vectorLayer = new Vector("Clusters", vectorOptions);
        animatedClusterStrategy.setDistance(20);
        animatedClusterStrategy.setThreshold(10);

        VectorFeature[] features = new VectorFeature[points.size()];
        for (int i = 0; i < points.size(); i++)
        {
            features[i] = new VectorFeature(points.get(i));
            Attributes attributes = new Attributes();
            attributes.setAttribute("examplenumber", Random.nextInt(10));
            features[i].setAttributes(attributes);
        }

        animatedClusterStrategy.setFeatures(features);
        for (Point point : points)
            vectorLayer.addFeature(new VectorFeature(point));

        vectorLayer.setStyleMap(styleMap);
        map.addLayer(vectorLayer);

        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner
                                             // to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to
                                           // display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 1);

        // now we want a popup to appear when user clicks
        // First create a select control and make sure it is actived
        SelectFeature selectFeature = new SelectFeature(vectorLayer);
        selectFeature.setAutoActivate(true);
        map.addControl(selectFeature);

        // Secondly add a VectorFeatureSelectedListener to the feature
        vectorLayer.addVectorFeatureSelectedListener(new VectorFeatureSelectedListener()
        {
            public void onFeatureSelected(FeatureSelectedEvent eventObject)
            {
                GWT.log("onFeatureSelected");

                // Attach a popup to the point, we use null as size cause we set
                // autoSize to true
                // Note that we use FramedCloud... This extends a normal popup
                // and creates is styled as a baloon
                int count = eventObject.getVectorFeature().getAttributes().getAttributeAsInt("count");

                int totalNumber = 0;
                VectorFeature[] clusters = eventObject.getVectorFeature().getCluster();
                for (int i = 0; i < clusters.length; i++)
                {
                    GWT.log("examplenumber = " + clusters[i].getAttributes().getAttributeAsInt("examplenumber"));
                    totalNumber += clusters[i].getAttributes().getAttributeAsInt("examplenumber");
                }

                Popup popup = new FramedCloud("id1", eventObject.getVectorFeature().getCenterLonLat(), null, "<h1>Hello</H1>Here are "
                        + count + " features.<br/>The sum of all examplenumber attributes is " + totalNumber, null, true);
                popup.setPanMapIfOutOfView(true); // this set the popup in a
                                                  // strategic way, and pans the
                                                  // map if needed.
                popup.setAutoSize(true);
                eventObject.getVectorFeature().setPopup(popup);

                // And attach the popup to the map
                map.addPopup(eventObject.getVectorFeature().getPopup());
            }
        });

        contentPanel
                .add(new HTML(
                        "<p>This example demonstrates the use of the Animated Cluster Strategy, and the use of styles and filters to dynamicly style the features.</p>"));

        contentPanel
                .add(new InfoPanel(
                        "<P>This example makes use of the AnimatedCluster strategy. This strategy is no part of the default OpenLayers library.</P>"
                                + "<P>To make this work you must"
                                + "<UL>"
                                + "<LI>download this AnimatedCluster strategy from <A HREF=\"https://github.com/acanimal/AnimatedCluster/blob/master/AnimatedCluster.js\">github</A></LI>"
                                + "<LI>Add it to your projects war folder and add the needed tag to your html file (for example &lt;script src=\"AnimatedCluster.js\"&gt;&lt;/script&gt;)</LI>"
                                + "</UL></P>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force
                                                                               // the
                                                                               // map
                                                                               // to
                                                                               // fall
                                                                               // behind
                                                                               // popups
    }

    @Override
    public String getSourceCodeURL()
    {
        return GWT.getModuleBaseURL() + "examples/cluster/" + "AnimatedClusterWithPopup.txt";
    }
}
