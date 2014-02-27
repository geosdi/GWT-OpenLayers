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
package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.RenderIntent;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.DragFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeatureOptions;
import org.gwtopenmaps.openlayers.client.event.FeatureHighlightedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureUnhighlightedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.EmptyLayer;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.popup.FramedCloud;
import org.gwtopenmaps.openlayers.client.popup.Popup;

import com.google.gwt.core.client.GWT;

public class HoverAndDragExample extends AbstractExample {

    @Inject
    public HoverAndDragExample(ShowcaseExampleStore store) {
        super(
                "Hover and drag vector example",
                "Demonstrates how to show a popup when hovering a feature, while the feature is still dragable.",
                new String[]{"popup", "feature", "selectable", "vector",
                    "hover", "drag", "draggable"}, store);
    }

    @Override
    public void buildPanel() {
        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget
        final MapWidget mapWidget = new MapWidget("500px", "500px",
                defaultMapOptions);

        // Create an EmptyLayer as base layer
        EmptyLayer.Options emptyLayerOptions = new EmptyLayer.Options();
        emptyLayerOptions.setAttribution("EmptyLayer (c) GWT-Openlayers");
        emptyLayerOptions.setIsBaseLayer(true); // make it a baselayer.
        EmptyLayer emptyLayer = new EmptyLayer("Empty layer", emptyLayerOptions);
        mapWidget.getMap().addLayer(emptyLayer);

		// Add a clickable vectors to the map
        // create a layer to add the vectors to
        final Vector vectorLayer = new Vector("Vectorlayer");
        mapWidget.getMap().addLayer(vectorLayer);

        // SelectFeature control to capture hover on the vectors
        DragFeature dragFeature = new DragFeature(vectorLayer);
        dragFeature.setAutoActivate(true);
        
        SelectFeatureOptions selectFeatureHoverOptions = new SelectFeatureOptions();
        // use the tempory style to be defined in the StyleMap		
        selectFeatureHoverOptions.setRenderIntent(RenderIntent.TEMPORARY);
        selectFeatureHoverOptions.setHighlightOnly(true);
        selectFeatureHoverOptions.setHover();
        SelectFeature selectHoverFeature = new SelectFeature(vectorLayer,
                selectFeatureHoverOptions);
        selectHoverFeature.setClickOut(false);
        selectHoverFeature.setAutoActivate(true);

        mapWidget.getMap().addControl(dragFeature);
        mapWidget.getMap().addControl(selectHoverFeature);
        //mapWidget.getMap().addControl(selectFeature);

        // Define a style for the vectors
        Style style = new Style();
        style.setFillColor("red");
        style.setStrokeColor("green");
        style.setStrokeWidth(2);
        style.setFillOpacity(0.9);
        style.setPointRadius(30);

        Style selectedStyle = new Style();
        selectedStyle.setFillColor("yellow");
        selectedStyle.setStrokeColor("yellow");
        selectedStyle.setStrokeWidth(2);
        selectedStyle.setFillOpacity(0.9);
        selectedStyle.setPointRadius(30);

        Style hoverStyle = new Style();
        hoverStyle.setFillColor("blue");
        hoverStyle.setStrokeColor("pink");
        hoverStyle.setStrokeWidth(2);
        hoverStyle.setFillOpacity(0.9);
        hoverStyle.setPointRadius(30);

        StyleMap styleMap = new StyleMap(style, selectedStyle, hoverStyle);
        vectorLayer.setStyleMap(styleMap);

        // Add a point
        Point point = new Point(146.7, -41.8);
        final VectorFeature pointFeature = new VectorFeature(point);
        vectorLayer.addFeature(pointFeature);

		// Attach a popup to the point, we use null as size cause we set
        // autoSize to true
        // Note that we use FramedCloud... This extends a normal popup and
        // creates is styled as a baloon
        // We want to display this popup on hover, and hide it when hovering
        // ends
        final Popup popup = new FramedCloud("id1",
                pointFeature.getCenterLonLat(), null,
                "<h1>Some popup text</H1><BR/>And more text", null, false);
        popup.setPanMapIfOutOfView(true); // this set the popup in a strategic
        // way, and pans the map if needed.
        popup.setAutoSize(true);
        pointFeature.setPopup(popup);
        
		// capture hover by adding a listener to the control, and display the
        // popup
        selectHoverFeature
                .addFeatureHighlightedListener(new FeatureHighlightedListener() {

                    public void onFeatureHighlighted(VectorFeature vectorFeature) {
                    	vectorFeature.getPopup().setLonLat(vectorFeature.getCenterLonLat());
                        mapWidget.getMap().addPopup(vectorFeature.getPopup());
                    }

                });

        // capture unhover, and remove popup
        selectHoverFeature
                .addFeatureUnhighlightedListener(new FeatureUnhighlightedListener() {

                    public void onFeatureUnhighlighted(
                            VectorFeature vectorFeature) {
                                mapWidget.getMap()
                                .removePopup(vectorFeature.getPopup());
                            }

                });

        // Center and zoom to a location
        mapWidget.getMap().setCenter(new LonLat(146.7, -41.8), 6);

        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "HoverAndDragExample.txt";
    }

}
