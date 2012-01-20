/*
 * Copyright 2011 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.examples.layers;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.TMS;
import org.gwtopenmaps.openlayers.client.layer.TMSOptions;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Alessio Fabiani - GeoSolutions S.A.S.
 * @email alessio.fabiani@geo-solutions.it
 */
public class TMSExample implements ShowcaseExample
{

    private static native JSObject getMyUrl()
    /*-{
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

                        var url = "http://biwsapplgmt01.digitalglobe.com:6180/~BASE/tile_production/3857_9_92_200_20110803_50000043/jpg/"+z+"/"+x+"/"+y+".jpg";
                        return url;
                }
        }

        return get_my_url;
    }-*/;

    private MapOptions defaultMapOptions;

    private MapExample example;

    private OSM mapnik;

    private TMS tileServerImagery;

    public TMSExample()
    {
        this.defaultMapOptions = new MapOptions();

        // In OL, the map gets PanZoom, Navigation, ArgParser, and Attribution Controls
        // by default. Do removeDefaultControls to remove these.
        this.defaultMapOptions.setNumZoomLevels(21);
        this.defaultMapOptions.setProjection("EPSG:900913");
        this.defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326"));
        this.defaultMapOptions.setUnits("m");
        this.defaultMapOptions.setMaxResolution(156543.0339f);
        this.defaultMapOptions.setMaxExtent(new Bounds(-20037508, -20037508, 20037508, 20037508.34));

        example = new MapExample(defaultMapOptions);

        mapnik = new OSM();

        // Add a WMS layer for a little background
        TMSOptions tmsOptions = new TMSOptions();
        tmsOptions.setDisplayOutsideMaxExtent(false);
        tmsOptions.setIsBaseLayer(true);
        tmsOptions.setType("jpg");
        tmsOptions.setGetURL(getMyUrl());

        tileServerImagery = new TMS("TMS", "", tmsOptions);

        example.getMap().addLayers(new Layer[] { mapnik, tileServerImagery });

        example.getMap().addControl(new LayerSwitcher());
        example.getMap().addControl(new MousePosition());

        example.getMap().zoomToMaxExtent();
    }

    public MapExample getMapExample()
    {
        return this.example;
    }
}
