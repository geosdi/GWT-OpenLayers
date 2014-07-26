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
package org.gwtopenmaps.demo.openlayers.client.examples.format.wmc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextArea;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.demo.openlayers.client.examples.format.wmc.resources.WMCThemeResources;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.format.format.WMC;
import org.gwtopenmaps.openlayers.client.format.format.WMCOptions;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WMCFormatExample extends AbstractExample {

    private static final WMC wmcFormat = new WMC();
    //
    private Map map;

    @Inject
    public WMCFormatExample(ShowcaseExampleStore store) {
        super("WMC Format Example", "Shows how to use WMC Format.",
                new String[]{"WMC", "Format"}, store);

        StyleInjector.inject(WMCThemeResources.RESOURCES.wmcCSS().getText());
    }

    @Override
    public void buildPanel() {
        OpenLayers.setImageReloadAttempts(2);
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px",
                defaultMapOptions);

        WMSParams gwcParams = new WMSParams();
        gwcParams.setLayers("bluemarble");
        Layer gwc = new WMS("Global Imagery",
                "http://maps.opengeo.org/geowebcache/service/wms", gwcParams);

        WMSParams vmapParam = new WMSParams();
        vmapParam.setLayers("basic");
        vmapParam.setFormat("image/png");

        WMSOptions vmapOptions = new WMSOptions();
        vmapOptions.setMaxExtent(new Bounds(-130, 14, -60, 55));
        vmapOptions.setMaxResolution(0.1f);
        vmapOptions.setNumZoomLevels(4);
        vmapOptions.setMinResolution(0.02f);

        Layer vmap = new WMS("OpenLayers WMS",
                "http://vmap0.tiles.osgeo.org/wms/vmap0", vmapParam,
                vmapOptions);

        WMSParams roadsParam = new WMSParams();
        roadsParam.setLayers("na_road:CCRS");
        roadsParam.setFormat("image/png");
        roadsParam.setTransparent(Boolean.TRUE);

        WMSOptions roadsOptions = new WMSOptions();
        roadsOptions.setIsBaseLayer(Boolean.FALSE);
        roadsOptions.setMaxExtent(new Bounds(-166.532, 4.05046,
                -0.206818, 70.287));
        roadsOptions.setDisplayInLayerSwitcher(Boolean.FALSE);
        roadsOptions.setLayerOpacity(0.6);
        roadsOptions.setMinScale(32000000);
        roadsOptions.setMaxScale(6200000);
        roadsOptions.setNumZoomLevels(4);

        Layer roads = new WMS("Transportation Network",
                "http://lioapp.lrc.gov.on.ca/cubeserv/cubeserv.pl",
                roadsParam, roadsOptions);

        WMSParams nexradParams = new WMSParams();
        nexradParams.setFormat("image/png");
        nexradParams.setLayers("Radar 3:1");

        WMSOptions nexradOptions = new WMSOptions();
        nexradOptions.setIsBaseLayer(Boolean.FALSE);
        nexradOptions.setMaxExtent(new Bounds(-131.029495239, 14.5628967285,
                -61.0295028687, 54.562896728));
        nexradOptions.setLayerOpacity(0.8);
        nexradOptions.setSingleTile(Boolean.TRUE);
        nexradOptions.setMaxResolution(0.1f);
        nexradOptions.setMinResolution(0.02f);
        nexradOptions.setNumZoomLevels(4);

        Layer nexrad = new WMS("Radar 3:1",
                "http://columbo.nrlssc.navy.mil/ogcwms/servlet"
                + "/WMSServlet/AccuWeather_Maps.wms", nexradParams,
                nexradOptions);

        map = mapWidget.getMap();
        map.addLayers(new Layer[]{gwc, vmap, roads, nexrad});

        map.addControl(new LayerSwitcher());

        map.setCenter(new LonLat(-95, 34.5), 4);

        contentPanel.add(new HTML(
                "<p>Shows parsing of Web Map Context documents.</p>"));
        contentPanel.add(mapWidget);

        final TextArea output = new TextArea();
        output.setStyleName("wmc");
        output.setText("paste WMC doc here");

        contentPanel.add(new Button("write", new ClickHandler() {

            public void onClick(ClickEvent event) {
                String wmcString = wmcFormat.write(map);
                output.setText(wmcString);
            }
        }));

        contentPanel.add(new Button("read and merge", new ClickHandler() {

            public void onClick(ClickEvent event) {
                if ((output.getText() != null)
                        && (output.getText().contains("ViewContext"))) {
                    WMCOptions wmcOptions = new WMCOptions();
                    wmcOptions.setMap(map);
                    wmcFormat.setWmcOptions(wmcOptions);
                    map = wmcFormat.read(output.getText());
                }
            }
        }));

        contentPanel.add(output);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups

        contentPanel.add(new HTML("<p>This is an example of parsing WMC documents. <br>\n"
                + "The format class has a layerOptions property, which can be used\n"
                + "to control the default options of the layer when it is created\n"
                + "by the parser.</p>"));
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/format/wmc/"
                + "WMCFormatExample.txt";
    }

}
