/*
 * Copyright 2012 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.components;

import com.google.gwt.user.client.ui.FlowPanel;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.gwtopenmaps.demo.openlayers.client.ExampleBean;
import org.gwtopenmaps.demo.openlayers.client.ExamplePanel;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.demo.openlayers.client.puregwt.ShowcaseEventBus;
import org.gwtopenmaps.demo.openlayers.client.puregwt.event.ExampleNumberEvent;
import org.gwtopenmaps.demo.openlayers.client.puregwt.handler.ExamplePanelBuildHandler;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Singleton
public class ShowcaseExamplePanel extends FlowPanel implements
        ExamplePanelBuildHandler {

    private ShowcaseExampleStore store;
    private ShowcaseEventBus bus;
    private ExampleNumberEvent event = new ExampleNumberEvent();

    @Inject
    public ShowcaseExamplePanel(ShowcaseExampleStore theStore,
            ShowcaseEventBus theBus) {
        super.setWidth("100%");
        this.store = theStore;
        this.bus = theBus;

        this.bus.addHandler(ExamplePanelBuildHandler.TYPE, this);
    }

    public void buildExamplePanel(String filter) {
        super.clear();

        int numberOfExamples = 0;

        for (ExampleBean example : store.getExamples()) {
            boolean show = false;
            String[] tags = example.getTags();
            if ((filter == null) || (filter.trim().equals(""))) {
                show = true;
            } else {
                for (String tag : tags) {
                    if (tag.trim().toLowerCase().contains(
                            filter.trim().toLowerCase())) {
                        show = true;
                        break;
                    }
                }
            }


            if (show) {
                super.add(new ExamplePanel(example));
                numberOfExamples++;
            }
        }

        this.event.setNumber(numberOfExamples);
        this.bus.fireEvent(event);
    }
}
