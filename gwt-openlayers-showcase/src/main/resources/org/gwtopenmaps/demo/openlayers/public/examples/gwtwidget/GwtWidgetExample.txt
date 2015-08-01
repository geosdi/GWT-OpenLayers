/**
 *
 *   Copyright 2015 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.examples.gwtwidget;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.MapMoveListener;
import org.gwtopenmaps.openlayers.client.layer.OSM;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Shows how to add a GwtWidget to the map.
 * @author Frank Wynants
 *
 */
public class GwtWidgetExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public GwtWidgetExample(ShowcaseExampleStore store) {
        super("GWT Widget Example", "Show how to add a GWT widget to the map at a LatLng",
              new String[]{"widget", "gwt"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget and add 2 OSM layers
        final MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        OSM osm_1 = OSM.Mapnik("Mapnik");
        OSM osm_2 = OSM.CycleMap("CycleMap");
        osm_1.setIsBaseLayer(true);
        osm_2.setIsBaseLayer(true);
        final Map map = mapWidget.getMap();
        map.addLayer(osm_1);
        map.addLayer(osm_2);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        final LonLat lonLat = new LonLat(6.95, 50.94);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                         map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 5);
        
        //And now where the real code starts
        final AbsolutePanel panel = new AbsolutePanel(); //use a GWT AbsolutePanel
        panel.setSize("500px", "500px"); //give it the same size as the MapWidget
        panel.add(mapWidget, 0, 0); //add the MapWidget to the AbsolutePanel

        final List<TextBox> ltb = new ArrayList<TextBox>();
        final List<LonLat> lll = new ArrayList<LonLat>();
        
        for (int i = 0 ; i < 20 ; i++)
        {
        	for (int j = 40 ; j < 60 ; j++)
        	{
                final TextBox tbGwt = new TextBox(); //we will add a TextBox to on top of the map
                tbGwt.setText("I am a GWT TextBox " + i + ";" +j);
                tbGwt.getElement().getStyle().setProperty("pointerEvents", "none"); //events will go through to the map
                ltb.add(tbGwt);
                
        		final LonLat ll = new LonLat(i, j);
        		ll.transform(DEFAULT_PROJECTION.getProjectionCode(),
                        map.getProjection()); //transform lonlat to OSM coordinate system
        		lll.add(ll);
        	}
        }
        
        int count=0;
        for (int i = 0 ; i < 20 ; i++)
        {
        	for (int j = 40 ; j < 60 ; j++)
        	{
        		final LonLat ll = lll.get(count);

                Pixel pxLonLat = map.getPixelFromLonLat(ll); //calculate px coordinates from lonLat
                int x = pxLonLat.x();
                int y = pxLonLat.y();
                
                if ((x > 0) && (y > 0) && (x < 500) && (y < 500))
                {
                	panel.add(ltb.get(count), pxLonLat.x(), pxLonLat.y()); //add TextBox add these px coordinates
                }
                count++;
        	}
        }
        
        map.addMapMoveListener(new MapMoveListener() {
			
			public void onMapMove(MapMoveEvent eventObject) {

				if (panel.getWidgetCount() > 1)
				{
					int count2 = 0;
			        for (int i = 0 ; i < 20 ; i++)
			        {
			        	for (int j = 40 ; j < 60 ; j++)
			        	{
			        		panel.remove(ltb.get(count2));
			        		count2++;
			        	}
			        }
				}
				
				int count3 = 0;
		        for (int i = 0 ; i < 20 ; i++)
		        {
		        	for (int j = 40 ; j < 60 ; j++)
		        	{
		        		final LonLat ll = lll.get(count3);

		                Pixel pxLonLat = map.getPixelFromLonLat(ll); //calculate px coordinates from lonLat
		                int x = pxLonLat.x();
		                int y = pxLonLat.y();
		                
		                if ((x > 0) && (y > 0) && (x < 500) && (y < 500))
		                {
		                	panel.add(ltb.get(count3), pxLonLat.x(), pxLonLat.y()); //add TextBox add these px coordinates
		                }
		                count3++;
		        	}
		        }
				
			}
        });

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a GWT widget to the map, at a certain location.</p>" +
                "<p>In this example we add a TextBox at LonLat(6.95, 50.94). The upperleft point of the widget will be placed at this point."));
        contentPanel.add(panel);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/gwtwidget/"
                + "GwtWidgetExample.txt";
    }
}
