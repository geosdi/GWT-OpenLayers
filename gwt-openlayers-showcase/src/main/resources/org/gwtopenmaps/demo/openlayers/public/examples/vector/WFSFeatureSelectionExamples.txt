/**
 *
 *   Copyright 2013 sourceforge.
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import java.util.List;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.control.GetFeature;
import org.gwtopenmaps.openlayers.client.control.GetFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.protocol.CRUDOptions;
import org.gwtopenmaps.openlayers.client.protocol.Response;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolCRUDOptions;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolOptions;

public class WFSFeatureSelectionExamples extends AbstractExample {

    private String attributes = "";
    private HTML attributesHTML = new HTML();

    @Inject
    public WFSFeatureSelectionExamples(ShowcaseExampleStore store) {
        super("WFS Select Feature Control Examples",
              "Demonstrates the use of WMS/WFS selection.",
              new String[]{"WFS", "VectorFeature", "selection"}, store);
    }

    @Override
    public void buildPanel() {
        OpenLayers.setProxyHost("olproxy?targetURL=");

        //create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        //Create a MapWidget
        MapWidget mapWidget = new MapWidget("800px", "500px", defaultMapOptions);
        //Create a WMS layer as base layer
        final WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("topp:states");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://demo.opengeo.org/geoserver/ows";

        final WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams,
                                     wmsLayerParams);
        final Vector select = new Vector("Basic WFS");



        GetFeatureOptions gfo = new GetFeatureOptions();

        final WFSProtocolCRUDOptions wfsCRUD = new WFSProtocolCRUDOptions(new CRUDOptions.Callback() {
            public void computeResponse(Response response) {
                GWT.log(
                        "RESPONSE @@@@@@@@@@@@@@@@@" + response.success());
            }
        });


        WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
        wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");
        wfsProtocolOptions.setFeatureType("states");
        wfsProtocolOptions.setSrsName("EPSG:4326");


        wfsProtocolOptions.setGeometryName("the_geom");
        final WFSProtocol wfsProtocol = new WFSProtocol(wmsLayer,
                                                        wfsProtocolOptions);

        gfo.setProtocol(wfsProtocol);
        GetFeature controlFeature = new GetFeature(gfo);



        //Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);
        map.addLayer(select);
        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline
        map.addControl(controlFeature);
        controlFeature.activate();


        controlFeature.getEvents().register("featureselected", wmsLayer,
                                            new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {

                final VectorFeature vectorFeature = getFeatureFromEventObject(
                        eventObject);

                select.addFeature(vectorFeature);

                List<String> attributesList = vectorFeature.getAttributes().getAttributeNames();

                attributes = "";
                for (String string : attributesList) {
                    vectorFeature.getAttributes().setAttribute(string, "");
                    attributes = attributes + "<p><i>" + string + "</i>" + " : " + "<b>" + vectorFeature.getAttributes().getAttributeAsString(
                            string) + "</b></p>";
                }

                vectorFeature.toState(VectorFeature.State.Unknown);
                vectorFeature.toState(VectorFeature.State.Update);
                attributesHTML.setHTML(attributes);
                wfsProtocol.commit(vectorFeature, wfsCRUD);
            }
        });

        controlFeature.getEvents().register("featureunselected", wmsLayer,
                                            new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {

                VectorFeature vectorFeature = getFeatureFromEventObject(
                        eventObject);

                select.removeFeature(vectorFeature);

                attributes = "";
                attributesHTML.setHTML(attributes);
            }
        });




        //Center and zoom to a location
        map.setCenter(new LonLat(-100, 40), 4);



        contentPanel.add(
                new HTML(
                "<p>This example shows how to use a selection feature on a WMS layer.</p><p>Click on a states to see feature</p>"));



        contentPanel.add(mapWidget);
        contentPanel.add(attributesHTML);
        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/wfs/"
                + "WFSFeatureSelectionExamples.txt";
    }

    private VectorFeature getFeatureFromEventObject(EventObject eventObject) {
        VectorFeature vectorFeature = VectorFeature.narrowToVectorFeature(eventObject.getJSObject().getProperty(
                "feature"));
        return vectorFeature;
    }
}
