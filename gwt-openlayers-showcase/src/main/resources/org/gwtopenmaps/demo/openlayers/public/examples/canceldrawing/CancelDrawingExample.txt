package org.gwtopenmaps.demo.openlayers.client.examples.canceldrawing;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.config.GwtOpenlayersExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

/**
 *
 * @author Frank Wynants
 *
 */
@GwtOpenlayersExample
public class CancelDrawingExample extends AbstractExample {

    private DrawFeature drawLineFeatureControl = null;

    public CancelDrawingExample() {
        super("Cancel drawing",
              "Demonstrates the use of the cancel method on DrawFeature "
                + "to cancel a current sketch.",
              new String[]{"cancel", "vector", "feature", "drawing", "sketch"});
    }

    @Override
    public void buildPanel() {
        // create controls
        final HTML htmlInfo = new HTML(
                "<p>This example shows how you can cancel a current sketch while drawing.</p><p>Draw some lines on the map, but <B>don't end the drawing by double clicking</B>. Then use the CANCEL button.</p><p>This button simply calls the cancel() method on the DrawFeature control.");

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
        drawLineFeatureControl = new DrawFeature(vectorLayer, new PathHandler());
        map.addControl(drawLineFeatureControl);
        drawLineFeatureControl.activate();

        final Button butCancel = new Button("CANCEL");

        butCancel.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                drawLineFeatureControl.cancel(); //the actual cancel action
            }
        });

        // Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); // + sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); // + sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); // Display the scaleline

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 5);

        contentPanel.add(htmlInfo);
        contentPanel.add(mapWidget);
        contentPanel.add(butCancel);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/canceldrawing/"
                + "CancelDrawingExample.txt";
    }
}