/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.demo.openlayers.client.examples.wmts;

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
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.WMTS;
import org.gwtopenmaps.openlayers.client.layer.WMTSOptions;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 * @author Francesco Izzi - CNR IMAA geoSDI Group
 * @email francesco.izzi@geosdi.org
 */
public class WMTSModisTerra extends AbstractExample {

    private static final String[] urlArrayModis
            = {
                "https://map1a.vis.earthdata.nasa.gov/wmts-webmerc/wmts.cgi",
                "https://map1b.vis.earthdata.nasa.gov/wmts-webmerc/wmts.cgi",
                "https://map1c.vis.earthdata.nasa.gov/wmts-webmerc/wmts.cgi"
            };

    @Inject
    public WMTSModisTerra(ShowcaseExampleStore store) {
        super("Basic Modis Terra WMTS example", "Show WMTS Modis Terra Layer on map.",
                new String[]{"Web Map Tile Service",
                    "WMTS", "wmts", "modis"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setProjection("EPSG:3857");

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
       

        WMTSOptions wmtsOptions = new WMTSOptions(urlArrayModis, "MODIS_Terra_CorrectedReflectance_TrueColor",
                "", "GoogleMapsCompatible_Level9");
        wmtsOptions.setName("MODIS_Terra_CorrectedReflectance_TrueColor");
        wmtsOptions.setIsBaseLayer(Boolean.TRUE);
        wmtsOptions.setFormat("image/jpeg");
        wmtsOptions.setNumZoomLevels(9);
        
        WMTS wmtsLayer = new WMTS(wmtsOptions);

        Map map = mapWidget.getMap();
        map.addLayer(wmtsLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        map.setCenter(new LonLat(-13677832, 5213272), 3);

        contentPanel.add(
                new HTML(
                        "<p>This example shows how to add a Modis WMTS layers to GWT-OL.</p>"));
        contentPanel.add(
                new InfoPanel(
                        "<p>Don't forget to add the following line to your html file if you want to use OSM :</p>"
                        + "<p><b>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/wmts/"
                + "WMTSModisTerra.txt";
    }

}
