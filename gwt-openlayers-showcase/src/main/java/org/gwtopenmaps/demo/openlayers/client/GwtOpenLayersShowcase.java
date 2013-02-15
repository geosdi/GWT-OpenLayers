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
package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseExamplePanel;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseTopPanel;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.demo.openlayers.client.config.GwtOpenlayersInjector;
import org.gwtopenmaps.demo.openlayers.client.puregwt.ShowcaseEventBus;
import org.gwtopenmaps.demo.openlayers.client.puregwt.event.ExamplePanelBuildEvent;

/**
 * Entry point for GWT OpenLayers showcase.
 */
public class GwtOpenLayersShowcase implements EntryPoint {

    private GwtOpenlayersInjector injector = GWT.create(
            GwtOpenlayersInjector.class);

    /**
     * TODO : Improve this code with ChainOfResponsibility Pattern
     * 
     * Entry point for the GWT OpenLayers Showcase
     */
    public void onModuleLoad() {
        ShowcaseEventBus bus = injector.getEventBus();
        ShowcaseTopPanel topPanel = injector.getShowcaseTopPanel();
        ShowcaseExamplePanel examplePanel = injector.getShowcaseExamplePanel();
        ShowcaseExampleStore store = injector.getExampleStore();

        store.sortStore();

        if (Window.Location.getParameter("example") != null) {
            for (ExampleBean example : store.getExamples()) {
                if (example.getName().equals(Window.Location.getParameter(
                        "example"))) {
                    example.getExample().buildPanel();
                    RootPanel.get().add(example.getExample());
                }
            }
        } else {
            RootPanel.get().add(topPanel);
            RootPanel.get().add(examplePanel);

            bus.fireEvent(new ExamplePanelBuildEvent(""));
        }
    }
}