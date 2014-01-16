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
package org.gwtopenmaps.demo.openlayers.client.examples.scale;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextArea;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.Scale;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.MapLayerChangedListener;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 * @author Francesco Izzi - CNR IMAA geoSDI Group
 * @email francesco.izzi@geosdi.org
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class ScaleExample extends AbstractExample {

    private final TextArea reportArea = new TextArea() {

        {
            this.setHeight("100px");
            this.setWidth("500px");
        }

    };

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public ScaleExample(ShowcaseExampleStore store) {
        super("Scale Example", "minScale and maxScale.",
                new String[]{"minScale", "maxScale", "scale"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget and add 2 OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm_1 = OSM.Mapnik("Mapnik");
        OSM osm_2 = OSM.CycleMap("CycleMap");
        osm_1.setIsBaseLayer(true);
        osm_2.setIsBaseLayer(true);
        Map map = mapWidget.getMap();
        map.addLayer(osm_1);
        map.addLayer(osm_2);

        final WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("topp:states");
        wmsParams.setStyles("");

        wmsParams.setTransparent(true);

        WMSOptions wmsOptions = new WMSOptions();
        wmsOptions.setTileSize(new Size(256, 256));
        wmsOptions.setProjection("EPSG:900913");

        wmsOptions.setIsBaseLayer(false);

        wmsOptions.setMaxScale((float) 13000000);
        wmsOptions.setMinScale((float) 56000000);

        String wmsUrl = "http://demo.opengeo.org/geoserver/wms";

        final WMS wmsLayer = new WMS("Usa Population", wmsUrl, wmsParams,
                wmsOptions);

        map.addLayer(wmsLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher

        map.addControl(new ScaleLine()); //Display the scaleline
        map.addControl(new Scale());

        map.addMapLayerChangedListener(new MapLayerChangedListener() {

            public void onLayerChanged(
                    MapLayerChangedListener.MapLayerChangedEvent eventObject) {
                String STATUS = (eventObject.getLayer().isInRange())
                        ? "ON" : "OFF";
                reportArea.setText("Layer : " + eventObject.getLayer().getName()
                        + " - Property Change : " + eventObject.getProperty()
                        + " - " + STATUS);
            }

        });

        //Center and zoom to a location
        LonLat lonLat = new LonLat(-100, 40);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 2);

        contentPanel.add(
                new HTML(
                        "<p>This example shows how to set min and max scale values. The Usa Population layer is visible from 56M to 13M</p>"));
        contentPanel.add(
                new InfoPanel(
                        "<p>Don't forget to add the following line to your html file if you want to use OSM :</p>"
                        + "<p><b>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        contentPanel.add(reportArea);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/scale/"
                + "ScaleExample.txt";
    }

}
