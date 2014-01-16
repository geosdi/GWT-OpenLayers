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
package org.gwtopenmaps.demo.openlayers.client.examples.filter;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.filter.ComparisonFilter;
import org.gwtopenmaps.openlayers.client.filter.ComparisonFilter.Types;
import org.gwtopenmaps.openlayers.client.filter.Filter;
import org.gwtopenmaps.openlayers.client.filter.LogicalFilter;
import org.gwtopenmaps.openlayers.client.filter.LogicalFilter.Logical;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolOptions;
import org.gwtopenmaps.openlayers.client.strategy.BBoxStrategy;
import org.gwtopenmaps.openlayers.client.strategy.RefreshStrategy;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * @author Frank Wynants/www.fks.be
 */
public class ComparisonAndLogicalFilterExample extends AbstractExample {
    @Inject
    public ComparisonAndLogicalFilterExample(ShowcaseExampleStore store) {
        super("WFS comparison and logical filter example", "Shows how to filter a wfs layer using a ComparisonFilter and a LogicalFilter.",
              new String[]{"WFS", "filter", "ComparisonFilter", "LogicalFilter"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        Map map = mapWidget.getMap();
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("topp:naturalearth");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://demo.opengeo.org/geoserver/wms";

        WMS wmsLayer = new WMS("Natural Earth", wmsUrl, wmsParams, wmsLayerParams);

        //Create a WFS layer
        WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
        wfsProtocolOptions.setUrl("http://demo.opengeo.org/geoserver/wfs");
        wfsProtocolOptions.setFeatureType("tasmania_roads");
        wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");
        //if your wms is in a different projection use wfsProtocolOptions.setSrsName(LAMBERT72);

        WFSProtocol wfsProtocol = new WFSProtocol(wfsProtocolOptions);

        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setProtocol(wfsProtocol);
        Style style = new Style();
        style.setStrokeWidth(3);
        style.setStrokeColor("#333333");
        vectorOptions.setStyle(style);
        final RefreshStrategy refreshStrategy = new RefreshStrategy(); //to refresh the map after the user has drawn a polygon
        refreshStrategy.setForce(true);
        vectorOptions.setStrategies(new Strategy[]{new BBoxStrategy(), refreshStrategy});
        //if your wms is in a different projection use vectorOptions.setProjection(LAMBERT72);

        final Vector wfsLayer = new Vector("WFS", vectorOptions);

        LogicalFilter logicalFilter = new LogicalFilter();
        logicalFilter.setType(Logical.OR); //we want highway OR road

        ComparisonFilter comparisonFilterRoad = new ComparisonFilter();
        comparisonFilterRoad.setType(Types.EQUAL_TO);
        comparisonFilterRoad.setProperty("TYPE"); //TYPE is the property as described in this WFS layer
        comparisonFilterRoad.setStringValue("road");

        ComparisonFilter comparisonFilterHighWay = new ComparisonFilter();
        comparisonFilterHighWay.setType(Types.EQUAL_TO);
        comparisonFilterHighWay.setProperty("TYPE"); //TYPE is the property as described in this WFS layer
        comparisonFilterHighWay.setStringValue("highway");

        logicalFilter.setFilters(new Filter[]{comparisonFilterRoad, comparisonFilterHighWay});

        wfsLayer.setFilter(logicalFilter);

        map.addLayer(wmsLayer);
        map.addLayer(wfsLayer);


        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(146.7, -41.8), 6);

        contentPanel
                .add(new HTML(
                        "<p>This example shows how you can filter out a WFS layer using a Filter. " +
                        "In this example a ComparisonFilter, and a LogicalFilter is used.</p> " +
                        "<p>This example requests all features that are TYPE 'highway' or 'road'.</p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/filter/"
                + "ComparisonAndLogicalFilterExample.txt";
    }
}
