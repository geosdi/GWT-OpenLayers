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
package org.gwtopenmaps.demo.openlayers.client.examples.rotatevector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

public class RotateVectorExample extends AbstractExample {

    @Inject
    public RotateVectorExample(ShowcaseExampleStore store) {
        super("Rotate vector features",
              "Details on how to create and rotate vector "
                + "features programmatically.",
              new String[]{"features", "rotate", "geometry"}, store);
    }

    @Override
    public void buildPanel() {

        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        //Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://vmap0.tiles.osgeo.org/wms/vmap0";

        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        //Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);

        //Add some vectors
        final Vector vectorLayer = new Vector("Simple Geometry");
        map.addLayer(vectorLayer);

        //create a point feature
        final Point point = new Point(-110, 45); //we need a Point object because this has the rotate method
        Style pointStyle = new Style();
        pointStyle.setFillColor("blue");
        pointStyle.setStrokeColor("blue");
        pointStyle.setStrokeWidth(3);
        pointStyle.setPointRadius(6);
        pointStyle.setFillOpacity(0.6);
        final VectorFeature pointFeature = new VectorFeature(point, pointStyle); //create a VectorFeature from the rotatable Polygon
        vectorLayer.addFeature(pointFeature);

        //create a line feature
        Point[] linePoints = {new Point(-120, 40), new Point(-115, 45), new Point(
            -110, 40)};
        final LineString lineString = new LineString(linePoints);//we need a LineString object because this has the rotate method
        final Style lineStyle = new Style();
        lineStyle.setStrokeColor("#339933");
        lineStyle.setStrokeWidth(3);
        lineStyle.setPointRadius(6);
        final VectorFeature lineFeature = new VectorFeature(lineString,
                                                            lineStyle); //create a VectorFeature from the rotatable LineString
        vectorLayer.addFeature(lineFeature);

        // create a polygon feature from a linear ring of points
        Point[] pointList = new Point[6];
        for (int p = 0; p < 6; p++) {
            double a = p * (2 * Math.PI) / 7;
            double r = Math.random() + 1;
            Point newPoint = new Point(point.getX() + (r * Math.cos(a)),
                                       point.getY() + (r * Math.sin(a)));
            pointList[p] = newPoint;
        }
        LinearRing linearRing = new LinearRing(pointList);
        final Polygon polygon = new Polygon(new LinearRing[]{linearRing}); //we need a Polygon object because this has the rotate method
        final VectorFeature polygonFeature = new VectorFeature(polygon,
                                                               lineStyle); //create a VectorFeature from the rotatable Polygon
        vectorLayer.addFeature(polygonFeature);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        map.setCenter(new LonLat(point.getX(), point.getY()), 5);

        //start the actual rotating
        final Point origin = new Point(-111.04, 45.68);

        final Timer t = new Timer() //we just use a GWT timer to have animation, no need for special OpenLayer timer stuff...
        {
            @Override
            public void run() {
                polygon.rotate(-360 / 20, origin);
                vectorLayer.drawFeature(polygonFeature, lineStyle);

                lineString.rotate(360 / 40, origin);
                vectorLayer.drawFeature(lineFeature, lineStyle);

                point.rotate(360 / 20, origin);
                vectorLayer.drawFeature(pointFeature, lineStyle);
            }
        };
        t.scheduleRepeating(100);

        contentPanel.add(
                new HTML(
                "<p>This example shows a few features rotating. There is not yet a control built that provides a tool for rotating, but the geometry.rotate method can be accessed to rotate programmatically.</p>"));

        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/rotatevector/"
                + "RotateVectorExample.txt";
    }
}
