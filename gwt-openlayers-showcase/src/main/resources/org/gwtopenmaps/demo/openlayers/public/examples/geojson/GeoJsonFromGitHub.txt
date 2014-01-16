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
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.SelectFeatureOptions;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.popup.FramedCloud;
import org.gwtopenmaps.openlayers.client.popup.Popup;

/**
 * Example showing how to use geojson from GitHub
 * @author Francesco Izzi - http://www.geosdi.org
 * @email  francesco.izzi@geosdi.org
 */

public class GeoJsonFromGitHub extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public GeoJsonFromGitHub(ShowcaseExampleStore store) {
        super("geojson from GitHub example", "Shows a geojson example, and how to read properties from the json.",
              new String[]{"json", "geojson", "properties", "github"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        //create some layers using geojson
        Options options = new Options();
        EmptyLayer emptyLayer = new EmptyLayer("Blanc", options);
        emptyLayer.setIsBaseLayer(true);
        final Vector polyLayer = JsonLayerCreator.createLayerFromJson("GitHub GeoJSON", "https://raw.github.com/fizzi/geoJson/master/test.geojson");


        //In the json we have defined styles in the properties, here we set these properties
        final Style style = new Style();
        style.setFillColor("#FA58F4");
        style.setFillOpacity(0.7);
        style.setStrokeColor("#000");
        
        final Style selectedStyle = new Style(); //the style when a feature is selected,

        selectedStyle.setStrokeColor("#000");
        selectedStyle.setFillColor("#FFFF00");
        selectedStyle.setFillOpacity(0.7);
        

        final StyleMap styleMap = new StyleMap(style, selectedStyle, selectedStyle);
        polyLayer.setStyleMap(styleMap);

        polyLayer.redraw();

        final Map map = mapWidget.getMap();

        //SelectFeature control to capture clicks on the vectors.
        //We use this to unSelect the selected feature
        final SelectFeatureOptions selectFeatureOptions = new SelectFeatureOptions();
//        selectFeatureOptions.setHighlightOnly(true);
        selectFeatureOptions.setHover();
        final SelectFeature selectFeatureControl = new SelectFeature(polyLayer, selectFeatureOptions);
        selectFeatureControl.setClickOut(false);
        selectFeatureControl.setAutoActivate(true);
        
        map.addControl(selectFeatureControl);

        polyLayer.addVectorFeatureSelectedListener(new VectorFeatureSelectedListener()
        {
            public void onFeatureSelected(FeatureSelectedEvent eventObject)
            {
                GWT.log("onFeatureSelected");
                final VectorFeature selectedFeature = eventObject.getVectorFeature();
                
                final List<String> attrNames = selectedFeature.getAttributes().getAttributeNames();
                String s = "";
                for (String attrName : attrNames)
                {
                    s += "<b>"+attrName+ "</b>" + ": <i>" + selectedFeature.getAttributes().getAttributeAsString(attrName) + "</i><BR />";
                }
                //Attach a popup to the point, we use null as size cause we set autoSize to true
                //Note that we use FramedCloud... This extends a normal popup and creates is styled as a baloon
                Popup popup = new FramedCloud(selectedFeature.getFeatureId(), selectedFeature.getCenterLonLat(), null, "<h1>"+ selectedFeature.getFeatureId()+"</H1><BR/>"+ s, null, false);
                popup.setPanMapIfOutOfView(true); //this set the popup in a strategic way, and pans the map if needed.
                popup.setAutoSize(true);
                selectedFeature.setPopup(popup);
                
                //And attach the popup to the map
                map.addPopup(eventObject.getVectorFeature().getPopup());
                
            }
        });
        
        polyLayer.addVectorFeatureUnselectedListener(new VectorFeatureUnselectedListener()
        {
            public void onFeatureUnselected(VectorFeatureUnselectedListener.FeatureUnselectedEvent eventObject)
            {
                GWT.log("onFeatureUnselected");
                map.removePopup(eventObject.getVectorFeature().getPopup());
                eventObject.getVectorFeature().resetPopup();
            }
        });

        map.addLayer(emptyLayer);
        map.addLayer(polyLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline
        map.addControl(new MousePosition());

        //Center and zoom to a location
        LonLat lonLat = new LonLat(14.77, 40.68);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 9);

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a geoJSON layer from GitHub to GWT-OL.</p>" +
                "<p>You can click on the polygon layer, this will display the properties defined in the JSON file (these are accessible as Attributes in GWT-OL)</p>" +
                ""));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/geojson/GeoJsonFromGitHub.txt";
    }
}
