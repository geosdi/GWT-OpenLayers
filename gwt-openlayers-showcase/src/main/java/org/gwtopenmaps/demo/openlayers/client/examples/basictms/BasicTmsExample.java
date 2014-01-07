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
package org.gwtopenmaps.demo.openlayers.client.examples.basictms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.TMS;
import org.gwtopenmaps.openlayers.client.layer.TMSOptions;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class BasicTmsExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:900913");

    @Inject
    public BasicTmsExample(ShowcaseExampleStore store) {
        super("Basic TMS example", "Demonstrates the use of a TMS layer.",
              new String[]{"TMS", "basic"}, store);
    }

    /**
     *
     * @return TMS URL for OSM cyclemap
     */
    private static native JSObject getMyUrl() /*-{
     function get_my_url(bounds) {
     var res = this.map.getResolution();

     var x = Math.round((bounds.left - this.maxExtent.left)
     / (res * this.tileSize.w));
     var y = Math.round((this.maxExtent.top - bounds.top)
     / (res * this.tileSize.h));
     var z = this.map.getZoom();

     var limit = 100000000;
     var i = 0;
     var dir_x = x;
     var dir_y = y;

     for (i = z; i > 9; i--) {
     dir_x = (Math.floor(dir_x / 2.0));
     dir_y = (Math.floor(dir_y / 2.0));
     }

     var path = "9_" + dir_x + "_" + dir_y + "/jpg";

     if (y < 0 || y >= limit) {
     return "http://imageatlas.digitalglobe.com/ia-webapp/img/noImage.gif"
     } else {
     limit = Math.pow(2, z);

     x = ((x % limit) + limit) % limit;
     y = ((y % limit) + limit) % limit;

     var url = "http://a.tile.opencyclemap.org/cycle/" + z + "/" + x + "/" + y + ".png";
     return url;
     }
     }

     return get_my_url;
     }-*/;

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(21);
        //specify bounds, projection, resolution, maxextent for TMS
        defaultMapOptions.setProjection("EPSG:900913");
        defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326"));
        defaultMapOptions.setUnits("m");
        defaultMapOptions.setMaxResolution(156543.0339f);
        defaultMapOptions.setMaxExtent(new Bounds(-20037508, -20037508, 20037508,
                                                  20037508.34));

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        //Create TMS layer
        TMSOptions tmsOptions = new TMSOptions();
        tmsOptions.setDisplayOutsideMaxExtent(false);
        tmsOptions.setIsBaseLayer(true);
        tmsOptions.setType("jpg");
        tmsOptions.setGetURL(getMyUrl());

        TMS tms = new TMS("TMS", "", tmsOptions);

        //And add them to the map
        Map map = mapWidget.getMap();
        map.addLayer(tms);


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
                "<p>This example shows how to add a TMS layer to GWT-OL.</p>"));
        contentPanel.add(mapWidget);

        map.zoomToMaxExtent();

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/basictms/"
                + "BasicTmsExample.txt";
    }
}
