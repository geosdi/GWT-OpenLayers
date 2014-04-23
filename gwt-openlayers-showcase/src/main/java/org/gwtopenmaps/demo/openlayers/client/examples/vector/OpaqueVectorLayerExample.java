/*
 * Copyright 2014 geoSDI.
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
package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
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
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class OpaqueVectorLayerExample extends AbstractExample {

    private static final String[] opacityValues = {"0.1f", "0.5f", "1f"};

    @Inject
    public OpaqueVectorLayerExample(ShowcaseExampleStore store) {
        super("Opaque vector example",
                "Demonstrates how to add Vector data to the map and set transparency.",
                new String[]{"opaque", "transparency", "vector"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326"));
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

        final Vector vectorLayer = new Vector("Vectorlayer");
        map.addLayer(vectorLayer);

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

        Point point = new Point(146.7, -41.8);
        VectorFeature pointFeature = new VectorFeature(point);
        vectorLayer.addFeature(pointFeature);

        //Add a line
        Point[] linePoints = {new Point(145, -40), new Point(147, 42)};
        LineString ls = new LineString(linePoints);
        vectorLayer.addFeature(new VectorFeature(ls));

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(146.7, -41.8), 6);

        contentPanel.add(
                new HTML(
                        "<p>This example shows how to add a Vector to the map and set its transparency .</p>"));
        contentPanel.add(mapWidget);

        HorizontalPanel panel = new HorizontalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setSpacing(16);

        for (String v : opacityValues) {
            final RadioButton radio = new RadioButton("VECTOR_OPACITY", v,
                    HasDirection.Direction.LTR);

            /**
             * I DO THIS FIRST ADDING THE CLICK HANDLER *
             */
            if (v.equals("1f")) {
                radio.setValue(Boolean.TRUE);
            }

            radio.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    vectorLayer.setOpacity(Float.parseFloat(radio.getText()));
                    Window.alert("Changing Vector Opacity to value : " + radio.getText());
                }

            });

            panel.add(radio);
        }

        contentPanel.add(panel);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "OpaqueVectorLayerExample.txt";
    }

}
