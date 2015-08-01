/**
 *
 *   Copyright 2015 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.examples.sld;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.format.sld.SLD;
import org.gwtopenmaps.openlayers.client.format.sld.SLDResult;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.HTML;
import org.gwtopenmaps.demo.openlayers.client.examples.sld.resources.SldExampleResources;

public class SldExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:4326");
    private static final TextResource sldResource = SldExampleResources.INSTANCE.sldResource();

    private Map map;

    @Inject
    public SldExample(ShowcaseExampleStore store) {
        super("SLD Example", "Show how to use SLD for styling", new String[]{"sld", "style"}, store);
    }

    @Override
    public void buildPanel() {
        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // create a MapWidget and add an OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm = OSM.Mapnik("Mapnik");
        osm.setIsBaseLayer(true);
        map = mapWidget.getMap();
        map.addLayer(osm);

        // lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //display the scaleline

        // center and zoom to a location
        LonLat lonLat = new LonLat(14.450000, 50.018120);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        map.setCenter(lonLat, 17);

//         load the style and create a vector map 
        loadStyleAndDisplayVectorMap();
        contentPanel.add(new HTML("<p>This example shows how to use SLD layer for styling purposes</p>"));
        contentPanel
                .add(new InfoPanel(
                                "<p>Don't forget to add the following line to your html file if you want to use OSM :</p>"
                                + "<p><b>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0);
    }

    /**
     * This method loads a style map, creates a vector map, assigns the style to
     * the vector map, and adds a new point to the vector map, which will be
     * styled according to the SLD
     */
    private void loadStyleAndDisplayVectorMap() {
        String document = sldResource.getText();
        SLD sld = new SLD();
        SLDResult result = sld.read(document);
        StyleMap userStyleMap = result.getUserStyleMap();

        // create a vector layer, and set the received style
        Vector vectorLayer = new Vector("My Vector Layer");
        vectorLayer.setStyleMap(userStyleMap);

        // create a new vector feature from a point 
        LonLat lonLat1 = new LonLat(14.450000, 50.018120);
        lonLat1.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        VectorFeature feature = new VectorFeature(new Point(lonLat1.lon(), lonLat1.lat()));

        // add this new point to the vector layer
        vectorLayer.addFeature(feature);

        // add this vector layer to the map
        map.addLayer(vectorLayer);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/sld/" + "SldExample.txt";
    }

}
