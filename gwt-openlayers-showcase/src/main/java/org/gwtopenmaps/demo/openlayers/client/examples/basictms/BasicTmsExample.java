package org.gwtopenmaps.demo.openlayers.client.examples.basictms;

import org.gwtopenmaps.demo.openlayers.client.examples.AbstractExample;
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

import com.google.gwt.user.client.ui.HTML;

public class BasicTmsExample extends AbstractExample
{
   private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:900913");
   
   /**
    * Constructor.
    * @param title The title of the example
    * @param source The source of the example.
    */ 
   public BasicTmsExample(String title, String source)
   {
      super(title, source);
   }

   /**
    * 
    * @return TMS URL for OSM cyclemap
    */
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

                        var url = "http://a.tile.opencyclemap.org/cycle/" + z + "/" + x + "/" + y + ".png";
                       return url;
               }
       }

       return get_my_url;
   }-*/;
   
   @Override
   public void buildPanel()
   {
      //create some MapOptions
      MapOptions defaultMapOptions = new MapOptions();
      defaultMapOptions.setNumZoomLevels(21);
      //specify bounds, projection, resolution, maxextent for TMS
      defaultMapOptions.setProjection("EPSG:900913");
      defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326"));
      defaultMapOptions.setUnits("m");
      defaultMapOptions.setMaxResolution(156543.0339f);
      defaultMapOptions.setMaxExtent(new Bounds(-20037508, -20037508, 20037508, 20037508.34));
      
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
      lonLat.transform(DEFAULT_PROJECTION.getProjectionCode() , map.getProjection()); //transform lonlat to OSM coordinate system
      map.setCenter(lonLat, 12);

      contentPanel.add(new HTML("<p>This example shows how to add a TMS layer to GWT-OL.</p>"));
      contentPanel.add(mapWidget);
      
      map.zoomToMaxExtent();
      
      initWidget(contentPanel);
      
      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
   }
}
