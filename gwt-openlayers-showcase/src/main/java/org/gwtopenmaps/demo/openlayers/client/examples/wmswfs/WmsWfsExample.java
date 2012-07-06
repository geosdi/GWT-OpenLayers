package org.gwtopenmaps.demo.openlayers.client.examples.wmswfs;

import org.gwtopenmaps.demo.openlayers.client.examples.AbstractExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolOptions;
import org.gwtopenmaps.openlayers.client.strategy.BBoxStrategy;
import org.gwtopenmaps.openlayers.client.strategy.Strategy;

import com.google.gwt.user.client.ui.HTML;

public class WmsWfsExample extends AbstractExample
{
   /**
    * Constructor.
    * @param title The title of the example
    * @param source The source of the example.
    */
   public WmsWfsExample(String title, String source)
   {
      super(title, source);
   }

   @Override
   public void buildPanel()
   {
       OpenLayers.setProxyHost("olproxy?targetURL=");

      //create some MapOptions
      MapOptions defaultMapOptions = new MapOptions();
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

      //Create a WFS layer
      WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
      wfsProtocolOptions.setUrl("http://demo.opengeo.org/geoserver/wfs");
      wfsProtocolOptions.setFeatureType("tasmania_roads");
      wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");
      //if your wms is in a different projection use wfsProtocolOptions.setSrsName(LAMBERT72);

      WFSProtocol wfsProtocol = new WFSProtocol(wfsProtocolOptions);

      VectorOptions vectorOptions = new VectorOptions();
      vectorOptions.setProtocol(wfsProtocol);
      vectorOptions.setStrategies(new Strategy[] { new BBoxStrategy() });
      //if your wms is in a different projection use vectorOptions.setProjection(LAMBERT72);

      Vector wfsLayer = new Vector("wfsExample", vectorOptions);

      map.addLayer(wfsLayer);


      //Lets add some default controls to the map
      map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
      map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
      map.addControl(new ScaleLine()); //Display the scaleline

      //Center and zoom to a location
      map.setCenter(new LonLat(146.7, -41.8), 6);

      contentPanel.add(new HTML("<p>This example shows how to add a WMS layer and a WFS overlay to a map.</p>"));
      contentPanel.add(mapWidget);

      initWidget(contentPanel);

      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
   }
}
