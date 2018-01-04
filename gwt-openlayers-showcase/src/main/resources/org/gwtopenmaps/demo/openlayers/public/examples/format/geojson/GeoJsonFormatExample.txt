package org.gwtopenmaps.demo.openlayers.client.examples.format.geojson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.*;
import org.gwtopenmaps.openlayers.client.format.GeoJSON;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.layer.*;

import javax.inject.Inject;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GeoJsonFormatExample extends AbstractExample {

    private DrawFeature drawLineFeatureControl;
    private GeoJSON geoJsonFormat = new GeoJSON();

    @Inject
    public GeoJsonFormatExample(ShowcaseExampleStore store) {
        super("Convert a Geometry to GeoJson Geometry",
                "Demonstrates how to convert a Geometry to GeoJson Format.",
                new String[]{"Geometry", "GeoJson Format"}, store);
    }

    @Override
    public void buildPanel() {
        // create controls
        final Label lblInfo = new Label("When you draw lines on the map GWT-OL will normally create Polygon objects.\n" +
                "In this Example we convert Polygon in GeoJson Geometry.");
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

        // Create the drawline control
        final DrawFeatureOptions drawFeatureOptions = new DrawFeatureOptions(); //create DrawFeatureOptions to listen on
        drawFeatureOptions.onFeatureAdded(vectorFeature -> { //listen for the adding of features.
            {
                contentPanel.add(
                        new Label("Convert Geometry : " + geoJsonFormat.write(vectorFeature.getGeometry(), Boolean.TRUE)));
                contentPanel.add(new Label("============================="));
            }
        });

        drawLineFeatureControl = new DrawFeature(vectorLayer, new PolygonHandler(), drawFeatureOptions);
        map.addControl(drawLineFeatureControl);
        drawLineFeatureControl.activate();

        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 5);

        contentPanel.add(lblInfo);
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/format/geojson/"
                + "GeoJsonFormatExample.txt";
    }
}
