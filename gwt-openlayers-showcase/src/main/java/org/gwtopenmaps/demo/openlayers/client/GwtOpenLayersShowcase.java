package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.xhr.client.XMLHttpRequest;

import org.gwtopenmaps.demo.openlayers.client.widget.ShowcaseContent;
import org.gwtopenmaps.demo.openlayers.client.widget.ShowcaseMenu;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolbar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;


/**
 * Entry point for GWT OpenLayers showcase.
 */
public class GwtOpenLayersShowcase implements EntryPoint
{

    public static final String WMS_URL = "http://v2.suite.opengeo.org/geoserver/wms/";
    private Map map;
    private MapOptions defaultMapOptions;

    private WMS wmsLayer;

    /**
     * main panel contains the showcase app
     */
    // private DockPanel mainPanel = new DockPanel();
    //
    // private SimplePanel bannerPanel = new SimplePanel();
    // private ShowcaseContent contentPanel = new ShowcaseContent();
    // private ShowcaseMenu menuPanel = new ShowcaseMenu(contentPanel);

    /**
     * Entry point for the GWT OpenLayers Showcase
     */
    public void onModuleLoad()
    {


        // HTML tempBanner = new
        // HTML("Welcome to the GWT OpenLayers showcase.");
        // bannerPanel.add(tempBanner);
        //
        // // TODO menuPanel gets passed a ShowcaseMenu widget
        // // the ShowcaseMenu widget gets passed a reference to the
        // contentPanel
        //
        // menuPanel.setTitle("Menu");
        // menuPanel.setWidth("200px");
        //
        // contentPanel.setTitle("Example");
        //
        // mainPanel.add(bannerPanel, DockPanel.NORTH);
        // mainPanel.add(menuPanel, DockPanel.WEST);
        // mainPanel.add(contentPanel, DockPanel.CENTER);

        this.defaultMapOptions = new MapOptions();

        // In OL, the map gets PanZoom, Navigation, ArgParser, and Attribution
        // Controls
        // by default. Do removeDefaultControls to remove these.
        this.defaultMapOptions.removeDefaultControls();
        this.defaultMapOptions.setNumZoomLevels(16);
        this.defaultMapOptions.setProjection("EPSG:4326");

        MapWidget mapWidget = new MapWidget("100%", "100%", defaultMapOptions);
        this.map = mapWidget.getMap();

        final WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("usa:states");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setTileSize(new Size(256, 256));

        wmsLayer = new WMS("Basic WMS", WMS_URL, wmsParams, wmsLayerParams);

        this.map.addLayers(new Layer[] { wmsLayer });

        // Adding controls to the Map
        this.map.addControl(new PanZoomBar());

        // use NavToolbar instead of deprecated MouseToolbar
        this.map.addControl(new NavToolbar());
        this.map.addControl(new MousePosition());
        this.map.addControl(new LayerSwitcher());
        this.map.addControl(new ScaleLine());

        // Center and Zoom
        double lon = -98;
        double lat = 38;
        int zoom = 4;

        this.map.setCenter(new LonLat(lon, lat), zoom);

        WingUIManager wing = new WingUIManager();
        ShowcaseContent content = new ShowcaseContent();
        FlexTable menuPanel = new ShowcaseMenu(wing.getMapZone(),
                wing.getSouthWestZone());

        wing.getWestCenterZone().add(menuPanel);
        wing.getMapZone().add(mapWidget);

        RootLayoutPanel.get().add(wing);
    }

    private static final class GeneratorInfo
    {
    }
}
