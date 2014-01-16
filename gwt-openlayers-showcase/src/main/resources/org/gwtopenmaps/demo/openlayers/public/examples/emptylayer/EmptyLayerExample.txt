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
package org.gwtopenmaps.demo.openlayers.client.examples.emptylayer;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.EmptyLayer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.Style;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * Demonstrates the use of EmptyLayer to create a blank background layer.
 * @author www.fks.be/Frank Wynants
 */

public class EmptyLayerExample extends AbstractExample {

    @Inject
    public EmptyLayerExample(ShowcaseExampleStore store) {
        super("Blank background baselayer with EmptyLayer",
              "Demonstrates the use EmptyLayer to create a blank background baselayer.",
              new String[]{"Empty", "Blank", "layer", "EmptyLayer", "marker"}, store);
    }

    @Override
    public void buildPanel() {
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

        //And now lets create an EmptyLayer and add it to the map.
        EmptyLayer.Options emptyLayerOptions = new EmptyLayer.Options();
        emptyLayerOptions.setAttribution("EmptyLayer (c) GWT-Openlayers"); //lets set some copyright msg as attribution
        emptyLayerOptions.setIsBaseLayer(true); //make it a baselayer.
        EmptyLayer emptyLayer = new EmptyLayer("Empty layer", emptyLayerOptions);
        map.addLayer(emptyLayer);
        
        //Add an overlay vector layer
        final Vector vectorLayer = new Vector("Vectorlayer");
        Point point = new Point(146.7, -41.8);
        Style pointStyle = new Style();
        pointStyle.setExternalGraphic("kangaroomarker.png");
        pointStyle.setGraphicSize(32, 37);
        pointStyle.setGraphicOffset(-16, -37); //anchor on bottom center
        pointStyle.setFillOpacity(1.0);
        VectorFeature pointFeature = new VectorFeature(point, pointStyle);
        vectorLayer.addFeature(pointFeature);
        map.addLayer(vectorLayer);
        
        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(146.7, -41.8), 6);

        contentPanel.add(new HTML("<p>This example shows how to add an empty baselayer to a map.</p>" +
        		"<p>This map shows a WMS layer and a EmptyLayer as baselayers, and a Vector layer as overlay.<BR/>" +
        		"Use the layer switcher to switch between a WMS layer, and the blank EmptyLayer.</p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/emptylayer/"
                + "EmptyLayerExample.txt";
    }
}
