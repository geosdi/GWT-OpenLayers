/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.demo.openlayers.client.examples.handler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

import javax.inject.Inject;

import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.event.ClickEvent;
import org.gwtopenmaps.openlayers.client.event.ClickListener;
import org.gwtopenmaps.openlayers.client.handler.ClickHandler;
import org.gwtopenmaps.openlayers.client.handler.ClickHandlerOptions;
import org.gwtopenmaps.openlayers.client.handler.Handler;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3MapType;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3Options;

/**
 *
 * @author Tino Desjardins - SRP
 * 
 */
public class KeyMaskExample extends AbstractExample {
    
    private static final Projection DEFAULT_PROJECTION = new Projection(
            "EPSG:4326");

    private KeymaskControl keyMaskControl = new KeymaskControl();
    private CheckBox keyAltCheckBox;
    private CheckBox keyShiftCheckBox;
    
    @Inject
    public KeyMaskExample(ShowcaseExampleStore store) {
        super("Key Mask Example",
                "This example shows the use of the handler with a key mask.",
                new String[]{"click", "event", "handler"}, store);
    }

    @Override
    public void buildPanel() {

        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // create a MapWidget
        MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

        contentPanel.add(new HTML(
                "<p>This example shows the use of the handler with a key mask.</p>"
                + "<p>"
                + "<li>Choose the keys you want to check with the checkboxes.</li>"
                + "<li>Press an hold the buttons you have choosen and click in the map.</li>"));
        contentPanel.add(
                new InfoPanel(
                        "<p>Don't forget to add the following line to your HTML if you want to use Google V3. :</p>"
                        + "<p><b>&lt;script src=\"http://maps.google.com/maps/api/js?v=3&amp;sensor=false\"&gt;&lt;/script&gt;</b></p>"));
        
        HorizontalPanel keyChooserPanel = new HorizontalPanel();
        
        this.keyAltCheckBox = new CheckBox("Alt");
        this.keyShiftCheckBox = new CheckBox("Shift");
        
        keyChooserPanel.add(this.keyAltCheckBox);
        keyChooserPanel.add(this.keyShiftCheckBox);
        
        
        ValueChangeHandler<Boolean> changeHandler = new ValueChangeHandler<Boolean>() {
            
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                
                int keyCodes = Handler.MOD_NONE;
                
                if(keyAltCheckBox.getValue()) {
                    keyCodes |= Handler.MOD_ALT;
                }
                
                if(keyShiftCheckBox.getValue()) {
                    keyCodes |= Handler.MOD_SHIFT;
                }
                
                keyMaskControl.setKeyMask(keyCodes);
                
            }
        };
        
        this.keyShiftCheckBox.addValueChangeHandler(changeHandler);
        this.keyAltCheckBox.addValueChangeHandler(changeHandler);
        this.keyShiftCheckBox.addValueChangeHandler(changeHandler);

        contentPanel.add(mapWidget);
        contentPanel.add(keyChooserPanel);

        // create some Google Layers
        GoogleV3Options gNormalOptions = new GoogleV3Options();
        gNormalOptions.setIsBaseLayer(true);
        gNormalOptions.setType(GoogleV3MapType.G_NORMAL_MAP);
        GoogleV3 gNormal = new GoogleV3("Google Normal", gNormalOptions);

        // and add them to the map
        final Map map = mapWidget.getMap();
        map.addLayer(gNormal);

        // lets add some default controls to the map
        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
        map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
        map.addControl(new ScaleLine()); //Display the scaleline
        
        
        map.addControl(keyMaskControl);
        
        keyMaskControl.activate();
        
        // center and zoom to a location
        LonLat lonLat = new LonLat(13.4, 52.51);
        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
                map.getProjection()); //transform lonlat to OSM coordinate system
        map.setCenter(lonLat, 12);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups


    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/handler/"
                + "KeyMaskExample.txt";
    }
    
    /**
     * Example control with keymask.
     * 
     * @author Tino Desjardins - SRP
     * 
     */
    public class KeymaskControl extends Control {
        
        private ClickHandler clickHandler;

        @Override
        public boolean activate() {

            if (this.getMap() != null) {

                if (this.clickHandler == null) {
                    
                    ClickHandlerOptions clickHandlerOptions = new ClickHandlerOptions();
                    clickHandlerOptions.setClickListener(new ClickListener() {
                        
                        @Override
                        public void onDoubleClick(ClickEvent eventObject) {
                            checkEvent(eventObject);
                        }
                        
                        @Override
                        public void onClick(ClickEvent eventObject) {
                            checkEvent(eventObject);
                        }
                    });
                    
                    this.clickHandler = new ClickHandler(this, clickHandlerOptions);
                    
                }

                this.clickHandler.activate();

            }

            return super.activate();
        }

        private void checkEvent(ClickEvent eventObject) {
            
            boolean keyMaskPassed = this.clickHandler.checkModifiers(eventObject);
            if (keyMaskPassed) {
                Window.alert("Selected keys are pressed.");
            } else {
                Window.alert("Selected keys don't match!");
            }

        }
        
        @Override
        public boolean deactivate() {

            if (this.clickHandler != null) {
                this.clickHandler.deactivate();
            }

            return super.deactivate();
        }
        
        public ClickHandler getClickHandler() {
            return this.clickHandler;
        }
        
        public void setKeyMask(int... keyCodes) {
            this.clickHandler.setKeyMask(keyCodes);
        }
        
    }
    
}
