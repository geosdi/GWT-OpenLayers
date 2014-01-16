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
package org.gwtopenmaps.demo.openlayers.client.examples.geodesiclength;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.Point;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * Example showing how to use geojson
 * @author www.fks.be / Frank Wynants
 *
 */

public class GeodesicLengthExample extends AbstractExample {

    @Inject
    public GeodesicLengthExample(ShowcaseExampleStore store) {
        super("GetGeodesicLength length example", "Shows the usage of the getGeoDesicLength method on line.",
              new String[]{"line", "getGeoDesicLength"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
    	LonLat lonLat1 = new LonLat(19.503304, 47.162494);
    	LonLat lonLat2 = new LonLat(20.147060499999952, 46.2525684);
    	
    	Point[] pts = new Point[2];
    	pts[0] = new Point(lonLat1.lon(), lonLat1.lat());
    	pts[1] = new Point(lonLat2.lon(), lonLat2.lat());
    	
    	LineString ls = new LineString(pts);
    	
    	
    	double distance = ls.getGeodesicLength(new Projection("EPSG:4326"));
    	
		HTML html = new HTML("<H2>The distance between (" + lonLat1.lon()
				+ " , " + lonLat1.lat() + ") and (" + lonLat2.lon() + ","
				+ lonLat2.lat() + ") = " + distance + "</H2>");

        contentPanel.add(
                new HTML(
                "<p>This example shows the usage of the getGeodesicLength method to get the accurate distance from a line.</P>"));
        
        contentPanel.add(html);

        initWidget(contentPanel);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/geodesiclength/GeodesicLengthExample.txt";
    }
}
