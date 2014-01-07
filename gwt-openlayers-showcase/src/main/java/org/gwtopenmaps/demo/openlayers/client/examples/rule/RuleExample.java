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
package org.gwtopenmaps.demo.openlayers.client.examples.rule;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.filter.ComparisonFilter;
import org.gwtopenmaps.openlayers.client.filter.ComparisonFilter.Types;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.style.Rule;
import org.gwtopenmaps.openlayers.client.style.SymbolizerPoint;
import org.gwtopenmaps.openlayers.client.util.Attributes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * Rule Based Styling example
 * @author www.fks.be / Frank Wynatns
 *
 */

public class RuleExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public RuleExample(ShowcaseExampleStore store) {
        super("Rule Based Style", "Use rule based styling to use different symbolizers for different feature groups.",
              new String[]{"openstreetmap", "OSM", "rule", "style", "styling"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget and add a OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm_1 = OSM.Mapnik("Mapnik");
        osm_1.setIsBaseLayer(true);
        Map map = mapWidget.getMap();
        map.addLayer(osm_1);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Create 25 random features
        VectorFeature[] feature = new VectorFeature[25];
        for (int i = 0; i < 25; i++) {
            Point point = new Point((340 * Math.random()) - 170, (160 * Math.random()) - 80);
            VectorFeature pointFeature = new VectorFeature(point);
            feature[i] = pointFeature;
            Attributes attributes = new Attributes();
            attributes.setAttribute("foo", (int)(100 * Math.random()));
            feature[i].setAttributes(attributes);
        }

        //Here we create a new style object with rules that determine
        //which symbolizer will be used to render each feature.
        Style style = new Style();
        style.setGraphicSize(21, 25);
        style.setGraphicOffset(0, -28);
        style.setLabel("${foo}"); //label will be foo attribute value

        //Create rules
        Rule[] rules = new Rule[4];

        //rule 0
        rules[0] = new Rule();
        ComparisonFilter filter0 = new ComparisonFilter();
        filter0.setType(Types.LESS_THAN);
        filter0.setProperty("foo");
        filter0.setNumberValue(25);

        SymbolizerPoint symbolizer0 = new SymbolizerPoint();
        symbolizer0.setExternalGraphic("http://openlayers.org/dev/img/marker-blue.png");
        rules[0].setFilter(filter0);
        rules[0].setSymbolizer(symbolizer0);

        //rule 1
        rules[1] = new Rule();
        ComparisonFilter filter1 = new ComparisonFilter();
        filter1.setType(Types.BETWEEN);
        filter1.setProperty("foo");
        filter1.setNumberLowerBoundary(25);
        filter1.setNumberUpperBoundary(50);

        SymbolizerPoint symbolizer1 = new SymbolizerPoint();
        symbolizer1.setExternalGraphic("http://openlayers.org/dev/img/marker-gold.png");
        rules[1].setFilter(filter1);
        rules[1].setSymbolizer(symbolizer1);

        //rule 2
        rules[2] = new Rule();
        ComparisonFilter filter2 = new ComparisonFilter();
        filter2.setType(Types.BETWEEN);
        filter2.setProperty("foo");
        filter2.setNumberLowerBoundary(50);
        filter2.setNumberUpperBoundary(75);

        SymbolizerPoint symbolizer2 = new SymbolizerPoint();
        symbolizer2.setExternalGraphic("http://openlayers.org/dev/img/marker-green.png");
        rules[2].setFilter(filter2);
        rules[2].setSymbolizer(symbolizer2);

        //rule 3
        rules[3] = new Rule();

        rules[3].setElseFilter(true);
        SymbolizerPoint symbolizer3 = new SymbolizerPoint();
        symbolizer3.setExternalGraphic("http://openlayers.org/dev/img/marker.png");
        rules[3].setSymbolizer(symbolizer3);

        //apply the rules to the style

        final StyleMap styleMap = new StyleMap(style);
        styleMap.addRules(rules, "default");

        //create and add a vector layer containing the features
        Vector vectorLayer = new Vector("Points");
        vectorLayer.setStyleMap(styleMap);
        vectorLayer.addFeatures(feature);

        map.addLayer(vectorLayer);

        //Center and zoom to a location
        LonLat lonLat = new LonLat(0, 0);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 17);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to use Rule to style your features. " +
                "Depenending on the value of a random Attribute 'foo' the markers " +
                "will get become green, red, gold or blue.</p>"));
        contentPanel.add(
                new InfoPanel(
                "<p>Don't forget to add the following line to your html file if you want to use OSM :</p>"
                + "<p><b>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</b></p>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/rule/"
                + "RuleExample.txt";
    }
}
