package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.protocol.CRUDOptions.Callback;
import org.gwtopenmaps.openlayers.client.protocol.Response;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolCRUDOptions;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolOptions;


public class ReadWFS implements ShowcaseExample
{
    public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";

    private MapExample example;

    private WMS wmsLayer;

    private Vector wfsLayer;

    public ReadWFS()
    {
        example = new MapExample();

        // Defining a WMSLayer and adding it to a Map
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        wmsLayer = new WMS(
                "Basic WMS",
                WMS_URL,
                wmsParams,
                wmsLayerParams);

        VectorOptions vectorOptions = new VectorOptions();
        wfsLayer = new Vector("wfsExample", vectorOptions);

        // set a proxyHost
        OpenLayers.setProxyHost("../gwtOpenLayersProxy?targetURL=");

        WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
        wfsProtocolOptions.setUrl("http://demo.opengeo.org/geoserver/wfs");
        wfsProtocolOptions.setFeatureType("states");
        wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");

        WFSProtocol wfsProtocol = new WFSProtocol(wfsProtocolOptions);

        // WFS Protocol is asynchronous, so we need to use a callback
        Callback callback = new Callback()
            {
                public void computeResponse(Response response)
                {
                    VectorFeature[] features = response.getFeatures();

                    for (VectorFeature feature : features)
                    {
                        // Fill in green all states with population < 4M
                        if (Double.parseDouble(feature.getAttributes().getAttributeAsString("PERSONS")) < 4000000)
                        {
                            Style style = new Style();
                            style.setFillColor("#00FF00");
                            feature.setStyle(style);

                            // Fill in orange all states with 4M < population < 10M
                        }
                        else if (Double.parseDouble(feature.getAttributes().getAttributeAsString("PERSONS")) < 10000000)
                        {
                            Style style = new Style();
                            style.setFillColor("#FFFF00");
                            feature.setStyle(style);

                            // Fill in red all states with population > 10M
                        }
                        else
                        {
                            Style style = new Style();
                            style.setFillColor("#FF0000");
                            feature.setStyle(style);
                        }
                    }

                    wfsLayer.addFeatures(features);
                }
            };

        WFSProtocolCRUDOptions options = new WFSProtocolCRUDOptions(callback);
        wfsProtocol.read(options);

        example.getMap().addLayers(new Layer[] { wmsLayer, wfsLayer });
        example.getMap().addControl(new PanZoomBar());
        example.getMap().addControl(new LayerSwitcher());
        example.getMap().setCenter(new LonLat(-100, 40), 3);

    }

    public MapExample getMapExample()
    {
        return this.example;
    }

}
