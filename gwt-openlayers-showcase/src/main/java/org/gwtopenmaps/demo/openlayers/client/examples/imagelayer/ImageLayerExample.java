package org.gwtopenmaps.demo.openlayers.client.examples.imagelayer;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3MapType;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3Options;
import org.gwtopenmaps.openlayers.client.layer.Image;
import org.gwtopenmaps.openlayers.client.layer.ImageOptions;
import org.gwtopenmaps.openlayers.client.layer.Layer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

public class ImageLayerExample extends AbstractExample {

    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    @Inject
    public ImageLayerExample(ShowcaseExampleStore store) {
        super("Image Layer Example",
              "Demonstrate a single non-tiled image as an overlay layer.",
              new String[]{"Image", "layer", "overlay"}, store);
    }

    @Override
    public void buildPanel() {
        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(18);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        //Create a Google Layers
        GoogleV3Options gNormalOptions = new GoogleV3Options();
        gNormalOptions.setIsBaseLayer(true);
        gNormalOptions.setType(GoogleV3MapType.G_SATELLITE_MAP);
        GoogleV3 gNormal = new GoogleV3("Google sattelite", gNormalOptions);
        
        //Create a image layer
        
        final Bounds extent = new Bounds(-88.0, 41.4, -87.0, 42.2);
        extent.transform(DEFAULT_PROJECTION, new Projection("EPSG:900913"));
        ImageOptions imageOptions = new ImageOptions();
        imageOptions.setNumZoomLevels(18);
        //imageOptions.setDisplayOutsideMaxExtent(true);
        imageOptions.setLayerOpacity(0.8d);
        imageOptions.setProjection("EPSG:900913");
        Image imageLayer = new Image("CatsLayer", "http://i1.kym-cdn.com/entries/icons/original/000/007/263/photo_cat2.jpg", extent, new Size(108,73), 
              imageOptions);
        imageLayer.setIsBaseLayer(false);
   

        //And add them to the map
        Map map = mapWidget.getMap();
        
        map.addLayers(new Layer[]{gNormal, imageLayer});
        //map.addLayer(imageLayer);

        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline

        //Center and zoom to a location
        LonLat lonLat = new LonLat(-87.65, 41.85);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(), map.getProjection());        
        map.setCenter(lonLat, 7);
                
        contentPanel.add(mapWidget);
        contentPanel.add(new HTML("<p>This example shows how you can create an image layer and use it as an overlay.</p><p>Some things you need to take into account is that you need to use the same projection (in this example the 900913 (GOOGLE) projection), and the same amount of zoomlevels as the base layer.</p><p>When different projections are used the image will not show up. And when different zoomlevels are used the image will only show up on some zoom levles.</p>"));

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
        
        GWT.log("map projection = " + map.getProjection());
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/imagelayer/"
                + "ImageLayerExample.txt";
    }
}
