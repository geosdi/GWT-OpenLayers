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
package org.gwtopenmaps.demo.openlayers.client.examples.snap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.control.Snapping;
import org.gwtopenmaps.openlayers.client.event.FeatureHighlightedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Frank Wynants
 */
public class SnapFeatureExample extends AbstractExample {

    private final ToggleButton butDraw = new ToggleButton("Draw Feature");
    private final ToggleButton butDelete = new ToggleButton("Delete feature");
    private final ToggleButton butSnap = new ToggleButton("Enable snapping",
                                                          "Disable snapping");
    //the DrawFeature, Snapping and DeleteFeature controls
    private DrawFeature drawLineFeatureControl = null;
    private Snapping snapControl = null;
    private SelectFeature deleteFeatureControl = null; //deleting is realized using a SelectFeature control

    @Inject
    public SnapFeatureExample(ShowcaseExampleStore store) {
        super("Snap, edit and delete features example",
              "Demonstrates on how to create new features and delete features. "
                + "In this example snapping on the features is enabled.",
              new String[]{"features", "drawing", "geometry", "edit", "vector",
                    "line", "polygon", "snapping", "snap", "delete"}, store);
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
        final VectorOptions vectorOptions = new VectorOptions();
        final Style style = new Style();
        style.setStrokeWidth(5);
        vectorOptions.setStyle(style);
        final Vector vectorLayer = new Vector("Vector layer", vectorOptions);
        map.addLayer(vectorLayer);

        // Create the drawline control
        drawLineFeatureControl = new DrawFeature(vectorLayer, new PathHandler());
        map.addControl(drawLineFeatureControl);

        // Create the snap control
        snapControl = new Snapping();
        snapControl.setLayer(vectorLayer); //The editable layer.  Features from this layer that are digitized or modified may have vertices snapped to features from the target layer
        snapControl.setTargetLayer(vectorLayer); //Editing will snap to features from this layer.
        map.addControl(snapControl);

        //Create the delete control
        deleteFeatureControl = new SelectFeature(vectorLayer);
        map.addControl(deleteFeatureControl);
        deleteFeatureControl.addFeatureHighlightedListener(new FeatureHighlightedListener() {
            public void onFeatureHighlighted(VectorFeature vectorFeature) {
                //if you want to do WFS-T do the following :
                //vectorFeature.toState(State.Unknown);
                //vectorFeature.toState(State.Delete);

                vectorFeature.destroy(); //don't do this if you want to use WFS-T
            }
        });

        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 5);

        contentPanel.add(mapWidget);

        final HorizontalPanel hpButtons = new HorizontalPanel();
        hpButtons.setSpacing(3);
        hpButtons.add(butDraw);
        hpButtons.add(butDelete);
        hpButtons.add(butSnap);
        contentPanel.add(hpButtons);

        butDraw.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (butDraw.isDown()) {
                    butDelete.setValue(false);
                    deleteFeatureControl.deactivate();

                    drawLineFeatureControl.activate();
                } else {
                    drawLineFeatureControl.deactivate();
                }
            }
        });

        butDelete.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (butDelete.isDown()) {
                    butDraw.setValue(false);
                    drawLineFeatureControl.deactivate();

                    deleteFeatureControl.activate();
                } else {
                    deleteFeatureControl.deactivate();
                }
            }
        });

        butSnap.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (butSnap.isDown()) {
                    snapControl.activate();
                } else {
                    snapControl.deactivate();
                }
            }
        });

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/snap/"
                + "SnapFeatureExample.txt";
    }
}