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
package org.gwtopenmaps.demo.openlayers.client.examples.featurepopup;

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
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.popup.FramedCloud;
import org.gwtopenmaps.openlayers.client.popup.Popup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * Shows how to add a feature to a popup.
 * @author www.fks.be / Frank Wynants
 *
 */

public class FeaturePopupExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public FeaturePopupExample(ShowcaseExampleStore store) {
        super("Feature popup example", "Show how to add a popup to a feature. Also adds a styled label to the feature.",
              new String[]{"feature", "popup", "label", "style"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget and add an OSM layers
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm = OSM.Mapnik("Mapnik");
        osm.setIsBaseLayer(true);
        final Map map = mapWidget.getMap();
        map.addLayer(osm);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(14.450000, 50.018120);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        map.setCenter(lonLat, 17);

        //Add a point feature
        Vector vectorLayer = new Vector("Vector Layer");
        map.addLayer(vectorLayer);
        Point p = new Point(14.450000, 50.018120);
        p.transform(DEFAULT_PROJECTION, new Projection(map.getProjection()));

        //Give the point an icon
        Style stStandard = new Style();
        stStandard.setGraphicSize(32, 32);
        stStandard.setExternalGraphic("http://icongal.com/gallery/image/98728/map_pin_location_push_pin_gps_pushpin.png");
        stStandard.setFillOpacity(1.0);

        //Create a style that we will use for the point, this style also contains a label
        Style st = new Style();
        st.setLabel("This is a styled label");
        st.setLabelXOffset(10);
        st.setLabelYOffset(10);
        st.setLabelAlign("lb");
        st.setFontColor("#0000FF");
        st.setGraphicSize(32, 32);
        st.setExternalGraphic("http://www.kyreneinternalmedicine.com/images/location.png");
        st.setFillOpacity(1.0);

        //Create the vectorfeature
        final VectorFeature pointFeature = new VectorFeature(p, st);
        pointFeature.setFeatureId("DEPO_DIGITECH");
        LonLat pLonLat = new LonLat(14.450000, 50.018120);
        pLonLat.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());
        vectorLayer.addFeature(pointFeature);

        //We want to display the popup when the user clicks the feature.
        //So we add a VectorFeatureSelectedListener to the feature.

        //First create a select control and make sure it is actived
        SelectFeature selectFeature = new SelectFeature(vectorLayer);
        selectFeature.setAutoActivate(true);
        map.addControl(selectFeature);

        //Secondly add a VectorFeatureSelectedListener to the feature
        vectorLayer.addVectorFeatureSelectedListener(new VectorFeatureSelectedListener() {
            public void onFeatureSelected(FeatureSelectedEvent eventObject) {
                GWT.log("onFeatureSelected");

                //Attach a popup to the point, we use null as size cause we set autoSize to true
                //Note that we use FramedCloud... This extends a normal popup and creates is styled as a baloon
                Popup popup = new FramedCloud("id1", pointFeature.getCenterLonLat(), null, "<h1>Some popup text</H1><BR/>And more text", null, false);
                popup.setPanMapIfOutOfView(true); //this set the popup in a strategic way, and pans the map if needed.
                popup.setAutoSize(true);
                pointFeature.setPopup(popup);

                //And attach the popup to the map
                map.addPopup(eventObject.getVectorFeature().getPopup());
            }
        });

        //And add a VectorFeatureUnselectedListener which removes the popup.
        vectorLayer.addVectorFeatureUnselectedListener(new VectorFeatureUnselectedListener()
        {
            public void onFeatureUnselected(FeatureUnselectedEvent eventObject)
            {
                GWT.log("onFeatureUnselected");
                map.removePopup(eventObject.getVectorFeature().getPopup());
                pointFeature.resetPopup();
            }
        });

        contentPanel.add(
                new HTML(
                "<p>This example shows attach a popup to a feature.</p><p>Click on the feature to display the popup, and click somewhere else on the map to close it after it was opened.</p>"));
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
        return GWT.getModuleBaseURL() + "examples/featurepopup/"
                + "FeaturePopupExample.txt";
    }
}
