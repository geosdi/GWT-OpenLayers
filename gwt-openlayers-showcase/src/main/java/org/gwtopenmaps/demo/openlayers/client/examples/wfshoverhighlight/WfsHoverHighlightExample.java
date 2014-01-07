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
package org.gwtopenmaps.demo.openlayers.client.examples.wfshoverhighlight;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature;
import org.gwtopenmaps.openlayers.client.control.ModifyFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeatureOptions;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolOptions;
import org.gwtopenmaps.openlayers.client.strategy.BBoxStrategy;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;

public class WfsHoverHighlightExample extends AbstractExample {

    @Inject
    public WfsHoverHighlightExample(ShowcaseExampleStore store) {
        super("WMS with an editable WFS overlay, WFS gets highlighted on hover.",
              "Demonstrates how you can use highlight on hover, to help the user see when he is exactly on top of the feature. This makes it easier for " +
              "the user to select the feature he wants to edit",
              new String[]{"WFS", "hover", "highlight", "WMS", "click", "WFS-T", "WFST", "WFS T", "save", "overlay", "edit", "modify"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("650px", "500px", defaultMapOptions);
        //Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("topp:tasmania_state_boundaries");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://demo.opengeo.org/geoserver/wms";

        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        //Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);

        //Create a WFS layer
        WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
        wfsProtocolOptions.setUrl("http://demo.opengeo.org/geoserver/wfs");
        wfsProtocolOptions.setFeatureType("tasmania_roads");
        wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");
        //if your wms is in a different projection use wfsProtocolOptions.setSrsName(LAMBERT72);

        WFSProtocol wfsProtocol = new WFSProtocol(wfsProtocolOptions);

        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setProtocol(wfsProtocol);
        vectorOptions.setStrategies(new Strategy[]{new BBoxStrategy()});
        //if your wms is in a different projection use vectorOptions.setProjection(LAMBERT72);

        Vector wfsLayer = new Vector("wfsExample", vectorOptions);
        map.addLayer(wfsLayer);

        //Create some styles for the wfs
        final Style normalStyle = new Style(); //the normal style
        normalStyle.setStrokeWidth(3);
        normalStyle.setStrokeColor("#FF0000");
        normalStyle.setFillColor("#FFFF00");
        normalStyle.setFillOpacity(0.8);
        normalStyle.setStrokeOpacity(0.8);
        final Style selectedStyle = new Style(); //the style when a feature is selected,
        selectedStyle.setStrokeWidth(3);
        selectedStyle.setStrokeColor("#FFFF00");
        selectedStyle.setFillColor("#FF0000");
        selectedStyle.setFillOpacity(0.8);
        selectedStyle.setStrokeOpacity(0.8);
        final StyleMap styleMap = new StyleMap(normalStyle, selectedStyle, selectedStyle);
        wfsLayer.setStyleMap(styleMap);

        //Create a ModifyFeature control that enables WFS modification
        final ModifyFeatureOptions modifyFeatureControlOptions = new ModifyFeatureOptions();
        modifyFeatureControlOptions.setMode(ModifyFeature.RESHAPE); //options are RESHAPE, RESIZE, ROTATE and DRAG
        final ModifyFeature modifyFeatureControl = new ModifyFeature(wfsLayer,
                                                                     modifyFeatureControlOptions);

        final SelectFeatureOptions selectFeatureOptions = new SelectFeatureOptions();
        selectFeatureOptions.setHighlightOnly(true);
        selectFeatureOptions.setHover();
        final SelectFeature selectFeatureControl = new SelectFeature(wfsLayer, selectFeatureOptions);
        selectFeatureControl.setClickOut(false);

        //selectFeatureControl.

        map.addControl(selectFeatureControl);
        map.addControl(modifyFeatureControl);

        selectFeatureControl.activate();
        modifyFeatureControl.activate();


        /*
         * Note that for saving back to the WFS you can use
         * final SaveStrategy saveStrategy = new SaveStrategy();
         * saveStrategy.setAuto(true);
         * vectorOptions.setStrategies(new Strategy[] {new BBoxStrategy(), saveStrategy }); // (instead of only BBOXStrategy)
         */

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(146.7, -41.8), 7);

        contentPanel.add(
                new HTML(
                "<p>This example shows how highlight a feature on hover, so that after a click this highlighted feature gets selected.<p>" +
                "<p>Using this technique you can circumvent the fact that users have click exactly on a feature to select it.</p>"));
        contentPanel.add(
                new InfoPanel(
                "For WFS it is adviced to use a proxy to avoid cross reference problems. See the gwt-openlayers-server code for more info."));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/wfshoverhighlight/"
                + "WfsHoverHighlightExample.txt";
    }
}
