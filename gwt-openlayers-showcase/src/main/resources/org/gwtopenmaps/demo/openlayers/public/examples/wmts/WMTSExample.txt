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
 */
public class WMTSExample extends AbstractExample {

    private static final String url = "http://v2.suite.opengeo.org/geoserver/gwc/service/wmts";

    @Inject
    public WMTSExample(ShowcaseExampleStore store) {
        super("Basic WMTS example", "Show WMTS Layer on map.",
                new String[]{"Web Map Tile Service",
            "WMTS", "wmts"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setProjection("EPSG:900913");

        //Create a MapWidget and add OSM layer
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm = OSM.Mapnik("Mapnik");
        osm.setIsBaseLayer(true);

        WMTSOptions wmtsOptions = new WMTSOptions(url, "medford:buildings",
                "_null", "EPSG:900913");
        wmtsOptions.setName("Medford Buildings");
        wmtsOptions.setLayerOpacity(0.7);
        wmtsOptions.setIsBaseLayer(false);
        wmtsOptions.setFormat("image/png");

        String[] args = new String[26];

        for (int i = 0; i < 26; i++) {
            args[i] = "EPSG:900913:" + i;
        }

        wmtsOptions.setMatrixIds(args);


        WMTS wmtsLayer = new WMTS(wmtsOptions);

        Map map = mapWidget.getMap();
        map.addLayer(osm);
        map.addLayer(wmtsLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        map.setCenter(new LonLat(-13677832, 5213272), 13);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a WMTS layers to GWT-OL.</p>"));
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
                + "WMTSExample.txt";
    }

}
