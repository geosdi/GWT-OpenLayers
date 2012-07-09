package org.gwtopenmaps.demo.openlayers.client.examples.wmsfeatureinfo;

import org.gwtopenmaps.demo.openlayers.client.DialogBoxWithCloseButton;
import org.gwtopenmaps.demo.openlayers.client.examples.AbstractExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.WMSGetFeatureInfo;
import org.gwtopenmaps.openlayers.client.control.WMSGetFeatureInfoOptions;
import org.gwtopenmaps.openlayers.client.event.GetFeatureInfoListener;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.user.client.ui.HTML;

public class WmsFeatureInfoExample extends AbstractExample
{
   /**
    * Constructor.
    * @param title The title of the example
    * @param source The source of the example.
    */
   public WmsFeatureInfoExample(String title, String source)
   {
      super(title, source);
   }

   @Override
   public void buildPanel()
   {
       OpenLayers.setProxyHost("olproxy?targetURL=");

      //create some MapOptions
      MapOptions defaultMapOptions = new MapOptions();
      defaultMapOptions.setDisplayProjection(new Projection("EPSG:4326")); //causes the mouse popup to display coordinates in this format
      defaultMapOptions.setNumZoomLevels(16);

      //Create a MapWidget
      MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
      //Create a WMS layer as base layer
      WMSParams wmsParams = new WMSParams();
      wmsParams.setFormat("image/png");
      wmsParams.setLayers("topp:tasmania_state_boundaries");
      wmsParams.setStyles("");

      WMSOptions wmsLayerParams = new WMSOptions();
      wmsLayerParams.setUntiled();
      wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

      String wmsUrl = "http://demo.opengeo.org/geoserver/wms";

      WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

      //Add the WMS to the map
      Map map = mapWidget.getMap();
      map.addLayer(wmsLayer);

      //Adds the WMSGetFeatureInfo control
      WMSGetFeatureInfoOptions wmsGetFeatureInfoOptions = new WMSGetFeatureInfoOptions();
      wmsGetFeatureInfoOptions.setMaxFeaturess(50);
      wmsGetFeatureInfoOptions.setLayers(new WMS[] {wmsLayer});
      wmsGetFeatureInfoOptions.setDrillDown(true);
      //to request a GML string instead of HTML : wmsGetFeatureInfoOptions.setInfoFormat(GetFeatureInfoFormat.GML.toString());

      WMSGetFeatureInfo wmsGetFeatureInfo = new WMSGetFeatureInfo(wmsGetFeatureInfoOptions);

      wmsGetFeatureInfo.addGetFeatureListener(new GetFeatureInfoListener()
      {
         public void onGetFeatureInfo(GetFeatureInfoEvent eventObject)
         {
            //if you did a wmsGetFeatureInfoOptions.setInfoFormat(GetFeatureInfoFormat.GML.toString()) you can do a VectorFeature[] features = eventObject.getFeatures(); here
            DialogBoxWithCloseButton db = new DialogBoxWithCloseButton();
            HTML html = new HTML(eventObject.getText());
            db.setWidget(html);
            db.center();            
         }
      });
      map.addControl(wmsGetFeatureInfo);
      wmsGetFeatureInfo.activate();      
      //Lets add some default controls to the map
      map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
      map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
      map.addControl(new ScaleLine()); //Display the scaleline

      //Center and zoom to a location
      map.setCenter(new LonLat(146.7, -41.8), 6);

      contentPanel.add(new HTML("<p>This example shows how to add a custom mouse position to the map..</p>"));
      contentPanel.add(mapWidget);

      initWidget(contentPanel);

      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
   }
}
