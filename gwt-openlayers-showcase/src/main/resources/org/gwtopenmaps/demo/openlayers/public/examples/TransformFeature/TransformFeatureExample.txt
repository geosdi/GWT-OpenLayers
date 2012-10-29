package org.gwtopenmaps.demo.openlayers.client.examples.TransformFeature;

import com.google.gwt.core.client.GWT;
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
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.TransformFeature;
import org.gwtopenmaps.openlayers.client.control.TransformFeatureOptions;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 * @author Lorenzo Amato <lorenzo.amato@geosdi.org>
 *
 */
public class TransformFeatureExample extends AbstractExample {

    @Inject
    public TransformFeatureExample(ShowcaseExampleStore store) {
        super("Transform vector features",
              "Details on how to create and transform vector features."
                + " Use the small Handels to transform and the greater "
                + "ones to rotate.",
              new String[]{"features", "transform", "geometry"}, store);
    }

    @Override
    public void buildPanel() {

        OpenLayers.setProxyHost("olproxy?targetURL=");

        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
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


        Map map = mapWidget.getMap();

        //Add some control to the map
        LayerSwitcher layerSwitcher = new LayerSwitcher();
        map.addControl(layerSwitcher); //Display the LayerSwitcher
        map.addControl(new ScaleLine()); //Display the scaleline

        // Add the WMS to the map
        map.addLayer(wmsLayer);

        // Add some vectors
        final Point point = new Point(-110, 45);

        final Vector vectorLayer = new Vector("Features to Transform");

        //Style for the vector
        final Style featureStyle = new Style();
        featureStyle.setFillColor("#eeeeff");
        featureStyle.setStrokeColor("#3300ff");
        featureStyle.setStrokeWidth(2);
        featureStyle.setPointRadius(3);

        //Style for the rotation Handle
        final Style rotationHandlerStyle = new Style();
        rotationHandlerStyle.setFillColor("#eeeeee");
        rotationHandlerStyle.setFillOpacity(1);
        rotationHandlerStyle.setPointRadius(12);

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
        final Polygon polygon = new Polygon(new LinearRing[]{linearRing});

        final VectorFeature polygonFeature = new VectorFeature(polygon,
                                                               featureStyle); // create a VectorFeature from the polygon



        vectorLayer.addFeature(polygonFeature);

        // Create Options For the Transform Control
        TransformFeatureOptions transformFeatureOptions = new TransformFeatureOptions();

        transformFeatureOptions.setRotate(true);
        transformFeatureOptions.setRotation(0);
        transformFeatureOptions.setRederIntent("transform");
        transformFeatureOptions.setRotationHandleSymbolizer(rotationHandlerStyle);

        // Create The Transform Control
        TransformFeature transformFeature = new TransformFeature(vectorLayer,
                                                                 transformFeatureOptions);

        map.setCenter(new LonLat(point.getX(), point.getY()), 7);
        map.addLayer(vectorLayer);
        //Add and activate the control
        map.addControl(transformFeature);
        transformFeature.activate();


        contentPanel.add(new HTML(
                "<p>This example shows the transformation of a Feature.</p>"));


        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/TransformFeature/"
                + "TransformFeatureExample.txt";
    }
}
