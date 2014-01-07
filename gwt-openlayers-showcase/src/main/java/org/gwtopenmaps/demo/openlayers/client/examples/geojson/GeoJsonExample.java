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
package org.gwtopenmaps.demo.openlayers.client.examples.geojson;

import java.util.List;

import javax.inject.Inject;

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
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.EmptyLayer;
import org.gwtopenmaps.openlayers.client.layer.EmptyLayer.Options;
import org.gwtopenmaps.openlayers.client.layer.JsonLayerCreator;
import org.gwtopenmaps.openlayers.client.layer.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;

/**
 * Example showing how to use geojson
 * @author www.fks.be / Frank Wynants
 *
 */

public class GeoJsonExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public GeoJsonExample(ShowcaseExampleStore store) {
        super("Basic geojson example", "Shows a geojson example, and how to read properties from the json.",
              new String[]{"json", "geojson", "properties"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        //create some layers using geojson
        Options options = new Options();
        EmptyLayer emptyLayer = new EmptyLayer("Blanc", options);
        emptyLayer.setIsBaseLayer(true);
        final Vector lineLayer = JsonLayerCreator.createLayerFromJson("Line Layer", "data/line.json");
        final Vector polyLayer = JsonLayerCreator.createLayerFromJson("Polygon Layer", "data/poly.json");
        final Vector pointLayer = JsonLayerCreator.createLayerFromJson("Point Layer", "data/point.json");

        //In the json we have defined styles in the properties, here we set these properties
        final Style style = new Style();
        style.setFillColor("${fill}");
        style.setStrokeColor("${stroke}");

        final StyleMap styleMap = new StyleMap(style);
        polyLayer.setStyleMap(styleMap);

        polyLayer.redraw();

        Map map = mapWidget.getMap();

        //SelectFeature control to capture clicks on the vectors.
        //We use this to unSelect the selected feature
        final SelectFeature selectFeature = new SelectFeature(polyLayer);
        selectFeature.setAutoActivate(true);
        map.addControl(selectFeature);
        polyLayer.addVectorFeatureSelectedListener(new VectorFeatureSelectedListener()
        {
            public void onFeatureSelected(FeatureSelectedEvent eventObject)
            {
                final VectorFeature selectedFeature = eventObject.getVectorFeature();
                selectFeature.unSelect(eventObject.getVectorFeature());

                final List<String> attrNames = selectedFeature.getAttributes().getAttributeNames();
                String s = "";
                for (String attrName : attrNames)
                {
                    s += attrName + ": " + selectedFeature.getAttributes().getAttributeAsString(attrName) + "\n";
                }

                Window.alert("You clicked on a polygon with the following properties in the json file :\n " + s);
            }
        });

        map.addLayer(emptyLayer);
        map.addLayer(lineLayer);
        map.addLayer(pointLayer);
        map.addLayer(polyLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(0, 0);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 1);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a some geoJSON layers to GWT-OL.</p>" +
                "<p>You can click on the polygon layer, this will display the properties defined in the JSON file (these are accessible as Attributes in GWT-OL)</p>" +
                "<p>In this example we also defined some properties 'stroke' and 'fill' attributes to specify a style for one of the polygons. These attributes" +
                "are used in the Style (style.setFillColor(\"${fill}\"); and style.setStrokeColor(\"${stroke}\");) to make GWT-OL use the style defined in the geojson properties.</p>" +
                "<p>These are the displayed JSON files (in poly.json you can see the defined properties):" +
                "<UL>" +
                "<LI><A HREF=\"data/line.json\" TARGET=\"_BLANK\">line.json</A>" +
                "<LI><A HREF=\"data/poly.json\" TARGET=\"_BLANK\">poly.json</A>" +
                "<LI><A HREF=\"data/point.json\" TARGET=\"_BLANK\">point.json</A>" +
                "</UL>"));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/geojson/GeoJsonExample.txt";
    }
}
