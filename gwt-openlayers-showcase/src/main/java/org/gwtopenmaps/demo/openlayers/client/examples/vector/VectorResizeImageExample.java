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
package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.event.MapZoomListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.layer.OSM;
import org.gwtopenmaps.openlayers.client.layer.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

public class VectorResizeImageExample extends AbstractExample {
	private static final Projection DEFAULT_PROJECTION = new Projection(
			"EPSG:4326");


    @Inject
    public VectorResizeImageExample(ShowcaseExampleStore store) {
        super("Image vector",
              "Demonstrates how to attach an image to a Vector layer, and let it resize based on the zoomlevel. This can also be achieved using" +
              "an ImageLayer, but this solution doesn't have the blurry effect the ImageLayer has.",
              new String[]{"image", "feature", "vector", "style", "stylemap"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);
        //Create a OSM layer as base layer
        OSM osm = OSM.Mapnik("Mapnik");
        osm.setIsBaseLayer(true);
        final Map map = mapWidget.getMap();
        map.addLayer(osm);

        //create a layer to add the vectors to
        final Vector vectorLayer = new Vector("Vectorlayer");
        map.addLayer(vectorLayer);

        //SelectFeature control to capture clicks on the vectors
        SelectFeature selectFeature = new SelectFeature(vectorLayer);
        selectFeature.setAutoActivate(true);
        map.addControl(selectFeature);

        //Define a style for the vectors
        final Style style = new Style();
        style.setExternalGraphic("squares.png");
        style.setGraphicOpacity(1.0);

        StyleMap styleMap = new StyleMap(style, style, style);
        vectorLayer.setStyleMap(styleMap);

        //Add a point
        final Point point = new Point(6.95, 50.94);
        point.transform(DEFAULT_PROJECTION, new Projection(map.getProjection())); //transform lonlat to OSM coordinate system
        VectorFeature pointFeature = new VectorFeature(point);
        vectorLayer.addFeature(pointFeature);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        final LonLat llCenter = new LonLat(6.95, 50.94);
        llCenter.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(llCenter, 8);
        map.zoomTo(9); //fires a zoom event

        map.addMapZoomListener(new MapZoomListener() {

			public void onMapZoom(MapZoomEvent eventObject) {
				LonLat llLeftTop = new LonLat(6.90, 51); //this is where we want the left top of the image to be drawn
				llLeftTop.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection()); //transform lonlat to OSM coordinate system
				LonLat llRightBottom = new LonLat(7, 50.90); //this is where we want the right bottom of the image to be drawn
				llRightBottom.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection()); //transform lonlat to OSM coordinate system

				Pixel pxLeftTopMap = map.getPixelFromLonLat(llLeftTop);
				Pixel pxRightBottomMap = map.getPixelFromLonLat(llRightBottom);

				int xLeftTop = pxLeftTopMap.x();
				int yLeftTop = pxLeftTopMap.y();
				int xRightBottom = pxRightBottomMap.x();
				int yRightBottom = pxRightBottomMap.y();

				int xSize = xRightBottom - xLeftTop;
				int ySize = yRightBottom - yLeftTop;

				style.setGraphicSize(xSize, ySize);

				//By specifying the bounds we make sure the image is rendered when only a part is in the viewpart.
				//If you don't do this the image is only rendered if the center of the image is in the viewport.
				//
				//We do this by searching for the px values of the lowerleft and upperright corners of the img
				//After this we convert back to latlng values
				Pixel pxCenterImage = map.getPixelFromLonLat(llCenter);
				int xLowerLeftImage = pxCenterImage.x() - (xSize / 2);
				int yLowerLeftImage = pxCenterImage.y() + (ySize / 2);
                int xUpperRightImage = pxCenterImage.x() + (xSize / 2);
                int yUpperRightImage = pxCenterImage.y() - (ySize / 2);

				LonLat llLowerLeft = map.getLonLatFromPixel(new Pixel(xLowerLeftImage, yLowerLeftImage));
				LonLat llUpperRight = map.getLonLatFromPixel(new Pixel(xUpperRightImage, yUpperRightImage));

				GWT.log("set bounds : " + llLowerLeft.lon() + " ; " + llLowerLeft.lat() + " ; " + llUpperRight.lon() + " ; " + llUpperRight.lat());
				point.setBounds(new Bounds(llLowerLeft.lon(), llLowerLeft.lat(), llUpperRight.lon(), llUpperRight.lat()));

				vectorLayer.redraw();
			}
		});

        contentPanel.add(
                new HTML(
                "<p>This example shows how to add a Vector to the map that uses an Image.</p>" +
                "<p>When zooming the image is resized. The center of the image is 6.95, 50.94 while the image size is between 6.90, 51 and 7, 50.9</p>" +
                "<p>Using an onzoom listener the need pixel size for the image is recalculated and the style is updated.</p>" +
                "<p>You can use this instead of an ImageLayer when you don't want the image to get blurry on resize."));
        contentPanel.add(mapWidget);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "VectorResizeImageExample.txt";
    }
}
