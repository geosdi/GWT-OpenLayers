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