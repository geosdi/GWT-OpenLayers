package org.gwtopenmaps.demo.openlayers.client.examples.basicgooglev2;

import org.gwtopenmaps.demo.openlayers.client.examples.AbstractExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.GMapType;
import org.gwtopenmaps.openlayers.client.layer.Google;
import org.gwtopenmaps.openlayers.client.layer.GoogleOptions;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;

public class BasicGoogleV2Example extends AbstractExample
{
   private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:4326");
   
   /**
    * Constructor.
    * @param title The title of the example
    * @param source The source of the example.
    */ 
   public BasicGoogleV2Example(String title, String source)
   {
      super(title, source);
   }

   @Override
   public void buildPanel()
   {
      //create some MapOptions
      MapOptions defaultMapOptions = new MapOptions();
      defaultMapOptions.setNumZoomLevels(20);

      //Create a MapWidget
      final MapWidget mapWidget = new MapWidget("0px", "0px", defaultMapOptions); //you can try to set this to normal size, but if map appears in upperleft corner this is the solution...
      //Create some Google Layers
      GoogleOptions gNormalOptions = new GoogleOptions();
      gNormalOptions.setIsBaseLayer(true);
      gNormalOptions.setType(GMapType.G_NORMAL_MAP);
      Google gNormal = new Google("Google Normal", gNormalOptions);

      GoogleOptions gSatelliteOptions = new GoogleOptions();
      gSatelliteOptions.setSphericalMercator(false);
      gSatelliteOptions.setIsBaseLayer(true);
      Google gSatellite = new Google("Google Satellite", gSatelliteOptions);

      GoogleOptions gHybridOptions = new GoogleOptions();
      gHybridOptions.setSphericalMercator(false);
      gHybridOptions.setIsBaseLayer(true);
      Google gHybrid = new Google("Google Hybrid", gHybridOptions);

      //And add them to the map
      final Map map = mapWidget.getMap();
      map.addLayer(gHybrid);
      map.addLayer(gNormal);
      map.addLayer(gSatellite);
      
      //Lets add some default controls to the map
      map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
      map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
      map.addControl(new ScaleLine()); //Display the scaleline

      //Center and zoom to a location
      LonLat lonLat = new LonLat(6.95, 50.94);
      lonLat.transform(DEFAULT_PROJECTION.getProjectionCode() , map.getProjection()); //transform lonlat to map coordinate system
      map.setCenter(lonLat, 12);

      contentPanel.add(new HTML("<p>This example shows how to add Google V2 layers to GWT-OL.</p>Don't forget to add the following line to your HTML if you want to use Google V2 (provide your own API key).</p><h2>&lt;script src='http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAjpkAC9ePGem0lIq5XcMiuhR_wWLPFku8Ix9i2SXYRVK3e45q1BQUd_beF8dtzKET_EteAjPdGDwqpQ'&gt;&lt;/script&gt;</h2>"));
      contentPanel.add(mapWidget);
      
      initWidget(contentPanel);
      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups

      //You can try without the following code, but it is the solution if your google map appears in upperleft corner only
      Timer t = new Timer()
      {
         
         @Override
         public void run()
         {
            mapWidget.setSize("500px", "500px");
            map.updateSize();
         }
      };
      t.schedule(1); //must wait at least 1ms, when not using a Timer the map will remain in upperleft corner only
   }
}
