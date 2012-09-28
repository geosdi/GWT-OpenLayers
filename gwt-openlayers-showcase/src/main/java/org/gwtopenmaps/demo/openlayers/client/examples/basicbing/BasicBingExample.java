package org.gwtopenmaps.demo.openlayers.client.examples.basicbing;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.config.GwtOpenlayersExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.Bing;
import org.gwtopenmaps.openlayers.client.layer.BingOptions;
import org.gwtopenmaps.openlayers.client.layer.BingType;

@GwtOpenlayersExample
public class BasicBingExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    public BasicBingExample() {
        super("Basic Bing example", "Demonstrates the use of Bing layers.",
              new String[]{"Bing", "Microsoft", "Virtual Earth", "basic"});
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        //Create some Bing layers
        final String key = "Apd8EWF9Ls5tXmyHr22OuL1ay4HRJtI4JG4jgluTDVaJdUXZV6lpSBpX-TwnoRDG"; //Bing key
        Bing road = new Bing(new BingOptions("Road Layer", key, BingType.ROAD));
        Bing hybrid = new Bing(new BingOptions("Hybrid Layer", key,
                                               BingType.HYBRID));
        Bing aerial = new Bing(new BingOptions("Aerial Layer", key,
                                               BingType.AERIAL));

        //And add them to the map
        Map map = mapWidget.getMap();
        map.addLayer(road);
        map.addLayer(hybrid);
        map.addLayer(aerial);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(6.95, 50.94);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 12);

        contentPanel.add(new HTML(
                "<p>This example shows how to add Bing layers to GWT-OL.</p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/basicbing/"
                + "BasicBingExample.txt";
    }
}
