package org.gwtopenmaps.demo.openlayers.client.examples.layers;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.layer.Bing;
import org.gwtopenmaps.openlayers.client.layer.BingOptions;
import org.gwtopenmaps.openlayers.client.layer.BingType;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class BingExample implements ShowcaseExample {

    private final String key = "Apd8EWF9Ls5tXmyHr22OuL1ay4HRJtI4JG4jgluTDVaJdUXZV6lpSBpX-TwnoRDG";
    private MapExample example;

    public BingExample() {
        this.example = new MapExample(new MapOptions());

        this.example.getMap().addControl(new LayerSwitcher());

        Bing road = new Bing(new BingOptions("Road Layer",
                key, BingType.ROAD));

        Bing hybrid = new Bing(new BingOptions("Hybrid Layer",
                key, BingType.HYBRID));

        Bing aerial = new Bing(new BingOptions("Aerial Layer",
                key, BingType.AERIAL));

        example.getMap().addLayer(road);
        example.getMap().addLayer(hybrid);
        example.getMap().addLayer(aerial);

        example.getMap().setCenter(new LonLat(-110, 45), 3);
    }

    public MapExample getMapExample() {
        return this.example;
    }
}
