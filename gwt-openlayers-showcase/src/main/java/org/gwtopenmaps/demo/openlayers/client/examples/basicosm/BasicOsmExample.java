package org.gwtopenmaps.demo.openlayers.client.examples.basicosm;

import org.gwtopenmaps.demo.openlayers.client.examples.AbstractExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.OSM;

import com.google.gwt.user.client.ui.HTML;

public class BasicOsmExample extends AbstractExample
{
   private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:4326");
   
   /**
    * Constructor.
    * @param title The title of the example
    * @param source The source of the example.
    */ 
   public BasicOsmExample(String title, String source)
   {
      super(title, source);
   }

   @Override
   public void buildPanel()
   {
      //create some MapOptions
      MapOptions defaultMapOptions = new MapOptions();
      defaultMapOptions.setNumZoomLevels(16);

      //Create a MapWidget and add 2 OSM layers
      MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
      OSM osm_1 = OSM.Mapnik("Mapnik");
      OSM osm_2 = OSM.CycleMap("CycleMap");
      osm_1.setIsBaseLayer(true);
      osm_2.setIsBaseLayer(true);
      Map map = mapWidget.getMap();
      map.addLayer(osm_1);
      map.addLayer(osm_2);
      
      //Lets add some default controls to the map
      map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
      map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
      map.addControl(new ScaleLine()); //Display the scaleline

      //Center and zoom to a location
      LonLat lonLat = new LonLat(6.95, 50.94);
      lonLat.transform(DEFAULT_PROJECTION.getProjectionCode() , map.getProjection()); //transform lonlat to OSM coordinate system
      map.setCenter(lonLat, 12);

      contentPanel.add(new HTML("<p>This example shows how to add a some OSM layers to GWT-OL.</p>" +
      		"<p>Don't forget to add the following line to your html file if you want to use OSM : <b><pre>&lt;script src=\"http://www.openstreetmap.org/openlayers/OpenStreetMap.js\"&gt;&lt;/script&gt;</pre></b></p>"));
      contentPanel.add(mapWidget);
      
      initWidget(contentPanel);
      
      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
   }
}
