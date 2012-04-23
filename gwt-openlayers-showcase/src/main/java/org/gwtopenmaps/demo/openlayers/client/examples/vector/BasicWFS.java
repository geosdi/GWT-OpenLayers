package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import com.google.gwt.user.client.ui.VerticalPanel;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.layer.Layer;
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


public class BasicWFS implements ShowcaseExample
{
    public static final String WMS_URL = "http://demo.opengeo.org/geoserver/wms";

    private MapExample example;

    private WMS wmsLayer;

    private VerticalPanel operationContents;

    public BasicWFS()
    {
        System.out.println(OpenLayers.getProxyHost());
        OpenLayers.setProxyHost("gwtOpenLayersProxy?targetURL=");

        example = new MapExample();

        // Defining a WMSLayer and adding it to a Map
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("topp:tasmania_state_boundaries");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        wmsLayer = new WMS("Basic WMS", WMS_URL, wmsParams, wmsLayerParams);

        // set a proxyHost

        // String proxyHost = OpenLayers.getProxyHost();

        // Defining a WFS and adding it to the map
        // Define a WFS with WFS protocol
        WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
        wfsProtocolOptions.setUrl("http://demo.opengeo.org/geoserver/wfs");
        wfsProtocolOptions.setFeatureType("tasmania_roads");
        wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");

        WFSProtocol wfsProtocol = new WFSProtocol(wfsProtocolOptions);

        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setProtocol(wfsProtocol);
        vectorOptions.setStrategies(new Strategy[] { new BBoxStrategy() });

        Vector wfsLayer = new Vector("wfsExample", vectorOptions);

        example.getMap().addLayers(new Layer[] { wmsLayer, wfsLayer });
        example.getMap().addControl(new PanZoomBar());
        example.getMap().addControl(new LayerSwitcher());
        example.getMap().setCenter(new LonLat(146.7, -41.8), 6);

        this.createOperationContents(null);

    }

    private void createOperationContents(Object object)
    {
        operationContents = new VerticalPanel();
    }

    public VerticalPanel getOperationContents()
    {
        return operationContents;
    }

    public void setOperationContents(VerticalPanel operationContents)
    {
        this.operationContents = operationContents;
    }

    public MapExample getMapExample()
    {
        return this.example;
    }
}
