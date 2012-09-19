package org.gwtopenmaps.demo.openlayers.client.examples.linestring2multilinestring;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.DrawFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;

public class LineString2MultiLineStringExample extends AbstractExample {

    private DrawFeature drawLineFeatureControl = null;

    /**
     * Constructor.
     *
     * @param title The title of the example
     */
    public LineString2MultiLineStringExample(String title) {
        super(title);
    }

    @Override
    public void buildPanel() {
        // create controls
        final Label lblInfo = new Label(
                "When you draw lines on the map GWT-OL will normally create LINESTRING objects. If your server (like geoserver) however requires" +
                "MULTILINESTRING objects you can modify these objects using the convertLineStringToMultiLineString method on the org.gwtopenmaps.openlayers.client.feature.VectorFeature object. You can do this in an onFeatureAdded listener as shown in this example.<br/><br/>The actual saving to WFS-T is not included in the is example. Please look at other examples for this.");

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
        drawFeatureOptions.onFeatureAdded(new DrawFeature.FeatureAddedListener() //listen for the adding of features.
        {
            public void onFeatureAdded(final VectorFeature vectorFeature)
            {
                contentPanel.add(new Label("Before convert: " + vectorFeature.getGeometry().toString()));
                vectorFeature.convertLineStringToMultiLineString(); //do the actual converting
                contentPanel.add(new Label("After convert: " + vectorFeature.getGeometry().toString()));
                contentPanel.add(new Label("============================="));
                //when you now save vectorLayer using WFS-T, it will use the MULTILINESTRING objects
            }
        });

        drawLineFeatureControl = new DrawFeature(vectorLayer, new PathHandler(), drawFeatureOptions);
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
        return GWT.getModuleBaseURL() + "examples/linestring2multilinestring/"
                + "LineString2MultiLineStringExample.txt";
    }
}