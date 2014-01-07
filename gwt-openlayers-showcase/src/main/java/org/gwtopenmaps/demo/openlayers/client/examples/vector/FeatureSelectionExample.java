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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ExampleStore;
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
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocol;
import org.gwtopenmaps.openlayers.client.protocol.WFSProtocolOptions;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class FeatureSelectionExample extends AbstractExample {
    
    protected Vector select;
    protected GetFeature controlFeature;
    
    public FeatureSelectionExample(String name, String description,
            String[] tags, ExampleStore store) {
        super(name, description, tags, store);
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
        
        this.select = new Vector("Basic Vector");
        
        GetFeatureOptions gfo = createGetFeatureOptions();
        
        WFSProtocolOptions wfsProtocolOptions = new WFSProtocolOptions();
        wfsProtocolOptions.setFeatureNameSpace("http://www.openplans.org/topp");
        wfsProtocolOptions.setFeatureType("states");
        wfsProtocolOptions.setSrsName("EPSG:4326");
        
        
        wfsProtocolOptions.setGeometryName("the_geom");
        final WFSProtocol wfsProtocol = new WFSProtocol(wmsLayer,
                wfsProtocolOptions);
        
        gfo.setProtocol(wfsProtocol);
        controlFeature = new GetFeature(gfo);
        
        Map map = mapWidget.getMap();
        map.addLayer(wmsLayer);
        map.addLayer(select);
        //Lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline
        map.addControl(controlFeature);
        controlFeature.activate();

        //Center and zoom to a location
        map.setCenter(new LonLat(-100, 40), 4);
        
        
        contentPanel.add(createComponent());
        contentPanel.add(mapWidget);
        
        initWidget(contentPanel);
        
        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
    }
    
    protected abstract GetFeatureOptions createGetFeatureOptions();
    
    protected abstract Widget createComponent();
    
    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "FeatureSelectionExample.txt";
    }
    
}
