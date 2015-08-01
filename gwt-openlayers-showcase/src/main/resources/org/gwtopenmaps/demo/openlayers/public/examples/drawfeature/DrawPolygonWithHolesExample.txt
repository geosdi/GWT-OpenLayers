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
package org.gwtopenmaps.demo.openlayers.client.examples.drawfeature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ToggleButton;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.DrawFeatureOptions;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandlerOptions;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandlerOptions.HoleModifier;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author T. Desjardins - SRP
 */
public class DrawPolygonWithHolesExample extends AbstractExample {

    @Inject
    public DrawPolygonWithHolesExample(ShowcaseExampleStore store) {
        super("Draw hole in Polygon Example", "A Basic Example to show the use of hole modifier to draw holes in polygons", new String[]{"features", "drawing",
            "geometry", "vector", "polygon", "hole"}, store);
    }

    @Override
    public void buildPanel() {
        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget
        MapWidget mapWidget = new MapWidget("514px", "258px", defaultMapOptions);
        // Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://vmap0.tiles.osgeo.org/wms/vmap0";
        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        // Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);

        // Create the Vector layer on which the user can draw new widgets
        final Vector vectorLayer = new Vector("Vector layer");
        map.addLayer(vectorLayer);

        DrawFeatureOptions drawFeatureOptions = new DrawFeatureOptions();
        PolygonHandlerOptions polygonHandlerOptions = new PolygonHandlerOptions();
        polygonHandlerOptions.setHoleModifier(HoleModifier.ctrlKey);
        drawFeatureOptions.setHandlerOptions(polygonHandlerOptions);
        
        final DrawFeature drawPolygonControl = new DrawFeature(vectorLayer,
                new PolygonHandler(), drawFeatureOptions);

        map.addControl(drawPolygonControl);

        drawPolygonControl.activate();

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 5);

        ToggleButton b = new ToggleButton("Navigate", new ClickHandler() {

            public void onClick(ClickEvent event) {
                if (((ToggleButton) event.getSource()).isDown()) {
                    drawPolygonControl.deactivate();
                } else {
                    drawPolygonControl.activate();
                }
            }

        });
        b.setSize("80px", "20px");
        contentPanel.add(new HTML(
                        "<p>This example shows how to draw a polygon with one or more holes.</p>"
                        + "<p>"
                        + "<li>Draw a polygon.</li>"
                        + "<li>Press key Control (Ctrl), hold it and draw a hole.</li>"));
        contentPanel.add(mapWidget);
        contentPanel.add(b);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/drawfeature/"
                + "DrawPolygonWithHolesExample.txt";
    }

}
