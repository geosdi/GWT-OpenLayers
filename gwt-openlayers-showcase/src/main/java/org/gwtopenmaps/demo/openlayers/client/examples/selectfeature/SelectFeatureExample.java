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
package org.gwtopenmaps.demo.openlayers.client.examples.selectfeature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeatureOptions;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.handler.PointHandler;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

public class SelectFeatureExample extends AbstractExample {

    private final RadioButton rbNavigate = new RadioButton("grp", "navigate");
    private final RadioButton rbDrawPoint = new RadioButton("grp", "draw point");
    private final RadioButton rbDrawLine = new RadioButton("grp", "draw line");
    private final RadioButton rbDrawPolygon = new RadioButton("grp",
                                                              "draw polygon");
    private final RadioButton rbSelectOnHover = new RadioButton("grp",
                                                                "select features on hover");
    private final RadioButton rbSelectFeatures = new RadioButton("grp",
                                                                 "select feature (0 features selected)");
    private final RadioButton rbSelectBox = new RadioButton("grp",
                                                            "select features in a box");
    private final CheckBox cbClickOut = new CheckBox(
            "click out to unselect features");
    private DrawFeature drawPointFeatureControl = null;
    private DrawFeature drawLineFeatureControl = null;
    private DrawFeature drawPolygonFeatureControl = null;
    private SelectFeature clickSelectFeature = null;
    private SelectFeature boxSelectFeature = null;
    private SelectFeature hoverSelectFeature = null;

    @Inject
    public SelectFeatureExample(ShowcaseExampleStore store) {
        super("Select and edit feature example",
              "Demonstrates on how to create new features, and select features "
                + "(on click, on hover and by selecting them in a box)",
              new String[]{"features", "drawing", "geometry", "select",
                    "vector", "point", "line", "polygon", "edit"}, store);
    }

    @Override
    public void buildPanel() {
        // create controls
        final Label lblInfo = new Label(
                "Use the shift key to select multiple features. Use the ctrl key to toggle selection on features one at a time. Note: the \"clickout\" option has no effect when \"hover\" is selected.");
        rbNavigate.setValue(true); // default navigate

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

        vectorLayer.addVectorFeatureSelectedListener(new VectorFeatureSelectedListener() //update label that shows the number of selected features
        {
            public void onFeatureSelected(FeatureSelectedEvent eventObject) {
                int length = 0;
                if (vectorLayer.getSelectedFeatures() != null) {
                    length = vectorLayer.getSelectedFeatures().length;
                }
                rbSelectFeatures.setText(
                        "select feature (" + length + " features selected)");
            }
        });
        vectorLayer.addVectorFeatureUnselectedListener(new VectorFeatureUnselectedListener() {
            public void onFeatureUnselected(FeatureUnselectedEvent eventObject) {
                int length = 0;
                if (vectorLayer.getSelectedFeatures() != null) {
                    length = vectorLayer.getSelectedFeatures().length;
                }
                rbSelectFeatures.setText(
                        "select feature (" + length + " features selected)");
            }
        });

        // Create the draw controls
        drawPointFeatureControl = new DrawFeature(vectorLayer,
                                                  new PointHandler());
        map.addControl(drawPointFeatureControl);
        drawLineFeatureControl = new DrawFeature(vectorLayer, new PathHandler());
        map.addControl(drawLineFeatureControl);
        drawPolygonFeatureControl = new DrawFeature(vectorLayer,
                                                    new PolygonHandler());
        map.addControl(drawPolygonFeatureControl);

        // Create the select controls
        clickSelectFeature = new SelectFeature(vectorLayer); //no options needed because no hover is needed
        clickSelectFeature.setClickOut(false); //do not deselect on click out
        clickSelectFeature.setToggle(false); //do not toggle when reclicked
        clickSelectFeature.setMultiple(false); //do not select multiple when clicked normally
        clickSelectFeature.setToggleKey("ctrlKey"); //Do toggle the selection when user holds CTRL key
        clickSelectFeature.setMultipleKey("shiftKey"); //Do select multiple features when user holds SHIFT key
        map.addControl(clickSelectFeature);

        SelectFeatureOptions boxSelectFeatureOptions = new SelectFeatureOptions();
        boxSelectFeatureOptions.setBox(true);
        boxSelectFeature = new SelectFeature(vectorLayer,
                                             boxSelectFeatureOptions);
        boxSelectFeature.setClickOut(false); //do not deselect on click out
        boxSelectFeature.setToggle(false); //do not toggle when reclicked
        boxSelectFeature.setMultiple(false); //do not select multiple when clicked normally
        boxSelectFeature.setToggleKey("ctrlKey"); //Do toggle the selection when user holds CTRL key
        boxSelectFeature.setMultipleKey("shiftKey"); //Do select multiple features when user holds SHIFT key
        map.addControl(boxSelectFeature);

        SelectFeatureOptions hoverSelectFeatureOptions = new SelectFeatureOptions();
        hoverSelectFeatureOptions.setHover();
        hoverSelectFeature = new SelectFeature(vectorLayer,
                                               hoverSelectFeatureOptions);
        map.addControl(hoverSelectFeature);

        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 5);

        contentPanel.add(mapWidget);

        contentPanel.add(rbNavigate);
        contentPanel.add(rbDrawPoint);
        contentPanel.add(rbDrawLine);
        contentPanel.add(rbDrawPolygon);
        contentPanel.add(rbSelectOnHover);
        contentPanel.add(rbSelectFeatures);
        contentPanel.add(rbSelectBox);
        final HorizontalPanel hpCbClickOut = new HorizontalPanel();
        hpCbClickOut.add(new HTML(
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
        hpCbClickOut.add(cbClickOut);
        contentPanel.add(hpCbClickOut);
        contentPanel.add(lblInfo);

        rbNavigate.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });
        rbDrawPoint.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });
        rbDrawLine.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });
        rbDrawPolygon.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });
        rbSelectOnHover.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });
        rbSelectFeatures.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });

        rbSelectBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                activateControls();
            }
        });

        cbClickOut.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                clickSelectFeature.setClickOut(cbClickOut.getValue());
                boxSelectFeature.setClickOut(cbClickOut.getValue());
            }
        });

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    /**
     * Activates the correct controls based on which radiobuttons are pressed.
     */
    private void activateControls() {
        if (rbDrawPoint.getValue()) {
            drawPointFeatureControl.activate();
        } else {
            drawPointFeatureControl.deactivate();
        }

        if (rbDrawLine.getValue()) {
            drawLineFeatureControl.activate();
        } else {
            drawLineFeatureControl.deactivate();
        }

        if (rbDrawPolygon.getValue()) {
            drawPolygonFeatureControl.activate();
        } else {
            drawPolygonFeatureControl.deactivate();
        }

        if (rbSelectFeatures.getValue()) {
            clickSelectFeature.activate();
        } else {
            clickSelectFeature.deactivate();
        }

        if (rbSelectOnHover.getValue()) {
            hoverSelectFeature.activate();
        } else {
            hoverSelectFeature.deactivate();
        }

        if (rbSelectBox.getValue()) {
            boxSelectFeature.activate();
        } else {
            boxSelectFeature.deactivate();
        }
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/selectfeature/"
                + "SelectFeatureExample.txt";
    }
}