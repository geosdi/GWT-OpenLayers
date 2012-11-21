/*
 * Copyright 2012 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.examples.dragfeature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextArea;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.DragFeature;
import org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener;
import org.gwtopenmaps.openlayers.client.control.DragFeatureOptions;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class DragFeatureExample extends AbstractExample {

    private Map map;
    private TextArea reportArea = new TextArea() {
        {
            this.setHeight("100px");
            this.setWidth("500px");
        }
    };

    @Inject
    public DragFeatureExample(ShowcaseExampleStore store) {
        super("Drag Vector Feature",
                "Demonstrates how drag a Vector Feature",
                new String[]{"Drag", "Feature"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        // Defining a WMSLayer and adding it to a Map
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        Layer wmsLayer = new WMS("Basic WMS", "http://labs.metacarta."
                + "com/wms/vmap0", wmsParams, wmsLayerParams);

        //Add the WMS to the map
        map = mapWidget.getMap();

        map.addLayers(new Layer[]{wmsLayer});

        map.addLayer(createLayer());

        map.setCenter(new LonLat(-111.04, 45.68), 4);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to Drag A Vector Feature.</p>"));
        contentPanel.add(mapWidget);

        contentPanel.add(reportArea);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/dragfeature/"
                + "DragFeatureExample.txt";
    }

    private Style createStyle() {
        Style style = new Style();
        style.setStrokeColor("#000000");
        style.setStrokeWidth(3);
        style.setFillColor("#FF0000");
        style.setFillOpacity(0.5);
        style.setPointRadius(10);
        style.setStrokeOpacity(1.0);

        return style;
    }

    private Layer createLayer() {
        // Create the vectorOptions
        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setStyle(createStyle());

        // Create the layer
        Vector layer = new Vector("Vector Layer", vectorOptions);

        // create a point feature
        Point point = new Point(-111.04, 45.68);
        VectorFeature pointFeature = new VectorFeature(point);

        // create a polygon feature from a linear ring of points
        VectorFeature polygonFeature = createPolygon(point);

        layer.addFeature(polygonFeature);
        layer.addFeature(pointFeature);

        DragFeature dragFeature = createDragFeature(layer);
        map.addControl(dragFeature);
        dragFeature.activate();

        return layer;

    }

    private DragFeature createDragFeature(Vector layer) {
        DragFeatureOptions dragFeatureOptions = new DragFeatureOptions();
        dragFeatureOptions.onDrag(createDragFeatureListener("onDrag"));
        dragFeatureOptions.onStart(createDragFeatureListener("onStart"));
        dragFeatureOptions.onComplete(createDragFeatureListener("onComplete"));

        DragFeature dragFeature = new DragFeature(layer, dragFeatureOptions);
        return dragFeature;
    }

    private DragFeatureListener createDragFeatureListener(final String type) {
        return new DragFeatureListener() {
            public void onDragEvent(VectorFeature vectorFeature,
                    Pixel pixel) {
                report(vectorFeature, type, pixel);

            }
        };
    }

    private VectorFeature createPolygon(Point point) {
        Point[] pointList = new Point[7];
        for (int p = 0; p < 6; ++p) {
            double a = p * (2 * Math.PI) / 7;
            double r = 3;
            Point newPoint = new Point(point.getX() + 5 + (r * Math.cos(a)),
                    point.getY() + 5 + (r * Math.sin(a)));
            pointList[p] = newPoint;
        }
        pointList[6] = pointList[0];

        LinearRing linearRing = new LinearRing(pointList);
        VectorFeature polygonFeature = new VectorFeature(new Polygon(
                new LinearRing[]{linearRing}));
        return polygonFeature;

    }

    protected void report(VectorFeature vectorFeature,
            String message,
            Pixel pixel) {
        reportArea.setText(vectorFeature.getFeatureId() + " " + message
                + " (X;Y)=(" + pixel.x() + ";" + pixel.y() + ")\n\n");

    }
}
