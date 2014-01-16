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
package org.gwtopenmaps.demo.openlayers.client.examples.variablewfsstyle;

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
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.LayerLoadEndListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
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
import org.gwtopenmaps.openlayers.client.util.Attributes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;

public class VariableWfsStyle extends AbstractExample {

    @Inject
    public VariableWfsStyle(ShowcaseExampleStore store) {
        super("Variable style WFS using attributes.",
              "Demonstrates how the style of a WFS can be made variable using attributes.",
              new String[]{"WFS", "style", "attribute", "variable"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
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

        final Vector wfsLayer = new Vector("wfsExample", vectorOptions);
        //give a style to the WFS layer
        final String[] colors = new String[]{"blue", "red", "green"}; //just some possible colors
        final double[] opacitys = new double[] {0.3, 0.6, 0.9}; //some possible opacity values


        final Style style = new Style();
        style.setStrokeWidth(3);
        //set some variable styles using ${attributename}. Later we set an attribute on each Feature with the name defined here (see method randomizeStyles).
        style.getJSObject().setProperty("strokeOpacity", "${variableopacity}"); // we can't use style.setStrokeOpacity(double d) cause this expects a double and "${variableopacity}" isn't a double
        style.setStrokeColor("${variablecolor}");

        wfsLayer.setStyleMap(new StyleMap(style));

        wfsLayer.addLayerLoadEndListener(new LayerLoadEndListener()
        {
            public void onLoadEnd(LoadEndEvent eventObject)
            {
                randomizeStyles(wfsLayer, opacitys, colors); //initialize
            }
        });

        final Button butGo = new Button("Randomize style !", new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                randomizeStyles(wfsLayer, opacitys, colors);
            }
        });

        map.addLayer(wfsLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(146.7, -41.8), 6);

        contentPanel.add(
                new HTML(
                "<p>This example shows how you can have a variable style that depends on attributes set to the features.</p>Click on the <b>'Randomize style !'</b> button to generate new styles."));
        contentPanel.add(
                new InfoPanel(
                "For WFS it is adviced to use a proxy to avoid cross reference problems. See the gwt-openlayers-server code for more info."));
        contentPanel.add(butGo);
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    /**
     * Modify the attributes of the features to modify the styles (because the styles are defined with the same names as the attributes).
     *
     * @param wfsLayer The layer which we want to randomize
     * @param opacitys Some opacity values we choose a random one from
     * @param colors Some color value whe choose a random one from
     */
    private void randomizeStyles(Vector wfsLayer, double[] opacitys, String[] colors)
    {
        final VectorFeature[] features = wfsLayer.getFeatures();
        for (VectorFeature feature : features)
        {
            final Attributes attr = feature.getAttributes();
            String newOpacity = "" + opacitys[Random.nextInt(3)];
            attr.setAttribute("variableopacity", "" + newOpacity);
            attr.setAttribute("variablecolor", colors[Random.nextInt(3)]);
        }
        wfsLayer.redraw();

    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/variablewfsstyle/"
                + "VariableWfsStyle.txt";
    }
}
