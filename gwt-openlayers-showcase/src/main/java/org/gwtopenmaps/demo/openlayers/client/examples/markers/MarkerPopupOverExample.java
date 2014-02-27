/*
 * Copyright 2014 geoSDI.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.examples.markers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.Icon;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Marker;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.MarkerBrowserEventListener;
import org.gwtopenmaps.openlayers.client.layer.Markers;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.popup.FramedCloud;
import org.gwtopenmaps.openlayers.client.popup.Popup;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class MarkerPopupOverExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    private Popup popup;

    @Inject
    public MarkerPopupOverExample(ShowcaseExampleStore store) {
        super("Marker popup over example", "Show how to add a popup to a Marker.",
                new String[]{"marker", "popup"}, store);
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

        LonLat p = new LonLat(14.450000, 50.018120);
        p.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());

        Markers layer = new Markers("Example Marker");
        map.addLayer(layer);

        Icon icon = new Icon("http://icongal.com/gallery/image/98728/map_pin_location_push_pin_gps_pushpin.png",
                new Size(32, 32));
        final Marker marker = new Marker(p, icon);
        layer.addMarker(marker);

        marker.addBrowserEventListener(EventType.MOUSE_OVER, new MarkerBrowserEventListener() {

            public void onBrowserEvent(MarkerBrowserEventListener.MarkerBrowserEvent markerBrowserEvent) {
                popup = new FramedCloud("id1", marker.getLonLat(), null, "<h1>Some popup text</H1><BR/>And more text", null, false);
                popup.setPanMapIfOutOfView(true); //this set the popup in a strategic way, and pans the map if needed.
                popup.setAutoSize(true);
                map.addPopup(popup);
            }

        });

        marker.addBrowserEventListener(EventType.MOUSE_OUT, new MarkerBrowserEventListener() {

            public void onBrowserEvent(MarkerBrowserEventListener.MarkerBrowserEvent markerBrowserEvent) {
                if(popup != null) {
                    map.removePopup(popup);
                    popup.destroy();
                }
            }

        });

        contentPanel.add(
                new HTML(
                        "<p>This example shows attach a popup to a feature.</p><p>Hover on the feature to display the popup.</p>"));
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
        return GWT.getModuleBaseURL() + "examples/markers/"
                + "MarkerPopupOverExample.txt";
    }

}
