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
package org.gwtopenmaps.demo.openlayers.client.examples.label;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.DragFeature;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

/**
 * Shows how to fix label overleap problems.
 * @author http://www.fks.be / Frank Wynants
 *
 */

public class LabelOverLeapExample extends AbstractExample {
   /* Lets declare some global stuff we need. */
   private Vector vectorFeature;
   private DragFeature vectorDragFeature;
   private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:4326");

    @Inject
    public LabelOverLeapExample(ShowcaseExampleStore store) {
        super("Label overleap example",
              "Demonstrates how to add labels, and make sure they don't overleap.",
              new String[]{"label", "labels", "overleap"}, store);
    }

    @Override
    public void buildPanel() {
      OpenLayers.setProxyHost("olproxy?targetURL=");

      MapOptions defaultMapOptions = new MapOptions();
      defaultMapOptions.setDisplayProjection(DEFAULT_PROJECTION); // causes the
                                                                  // mouse popup
                                                                  // to display
                                                                  // coordinates
                                                                  // in this
                                                                  // format
      defaultMapOptions.setNumZoomLevels(16);

      // Create a MapWidget
      MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
      // Create a WMS layer as base layer
      WMSParams wmsParams = new WMSParams();
      wmsParams.setFormat("image/png");
      wmsParams.setLayers("basic");
      wmsParams.setStyles("");

      WMSOptions wmsLayerParams = new WMSOptions();
      wmsLayerParams.setUntiled();
      wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

      String wmsUrl = "http://labs.metacarta.com/wms/vmap0";

      WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

      vectorFeature = new Vector("vectorTesterLayer");
      vectorDragFeature = new DragFeature(vectorFeature);
      
      vectorFeature.setTextRootRendererToVectorRootRenderer(); //makes sure labels don't overleap
      
      mapWidget.getMap().addLayers(new Layer[] { wmsLayer, vectorFeature });
      Map map = mapWidget.getMap();
      // Lets add some default controls to the map
      map.addControl(new LayerSwitcher()); // + sign in the upperright corner to
                                           // display the layer switcher
      map.addControl(new OverviewMap()); // + sign in the lowerright to display
                                         // the overviewmap
      map.addControl(new ScaleLine()); // Display the scaleline
      map.addControl(new MousePosition());

      // Center and zoom to a location
      LonLat lonLat = new LonLat(6.95, 50.94);
      lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection()); // transform
                                                                                     // lonlat
                                                                                     // to
                                                                                     // OSM
                                                                                     // coordinate
                                                                                     // system
      map.setCenter(lonLat, 12);

      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force
                                                                             // the
                                                                             // map
                                                                             // to
                                                                             // fall
                                                                             // behind
                                                                             // popups

      mapWidget.getMap().addControl(vectorDragFeature);
      addExampleFeatures();
      vectorFeature.setZIndex(4000);

      contentPanel.add(new HTML("<p>This example shows how to add labels that don't overleap.</p>" +
      		"<p>Drag the features arround and you will see that the GWT-OpenLayers box and text sit on top of the text-example 1 box and text.</p>" +
            "<p>Without the fix you would have the weird effect that the GWT-OpenLayers box would be on top of the test-example 1 box, but below the test-example 1 text.</p>" +
            "<p>The magic code : vectorFeature.setTextRootRendererToVectorRootRenderer();</p>"));
      		
      contentPanel.add(mapWidget);

      initWidget(contentPanel);
    }
    
/**
 * Add some example features to the map
 */
   private void addExampleFeatures() {
      String img = "http://upload.wikimedia.org/wikipedia/commons/3/38/Rect_Geometry.png";
   
      
      Point point = new Point(6.95, 50.94);
      VectorFeature vf1 =  new VectorFeature(point,createVectorFeatureStyle(img, "text example 1"));
      
      Point point2 = new Point(6.95, 50.94);
      VectorFeature vf2 =  new VectorFeature(point2,createVectorFeatureStyle(img, "GWT-Openlayers Rock"));
      
      vectorFeature.addFeature(vf1);
      vectorFeature.addFeature(vf2);
      vectorDragFeature.activate();
   }

/**
 * Create a style for the vectorfeatures.
 * @param img
 * @param text
 * @return
 */
   private Style createVectorFeatureStyle(String img, String text){
      Style externalStyle = new Style();
      externalStyle.setExternalGraphic(img);
      externalStyle.setGraphicSize(60, 60);
      externalStyle.setFillOpacity(1);
      externalStyle.setLabel(text);
      externalStyle.setFontWeight("bold");
      externalStyle.setFontFamily("arial");
      externalStyle.setFontSize("7pt");
   
   
      return externalStyle;
   }    

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/label/"
                + "LabelOverLeapExample.txt";
    }
}