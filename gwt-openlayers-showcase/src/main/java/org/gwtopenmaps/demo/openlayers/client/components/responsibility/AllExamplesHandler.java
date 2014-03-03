/*
 * Copyright 2014 geoSDI.
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
package org.gwtopenmaps.demo.openlayers.client.components.responsibility;

import com.google.gwt.user.client.ui.RootPanel;
import org.gwtopenmaps.demo.openlayers.client.puregwt.event.ExamplePanelBuildEvent;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class AllExamplesHandler extends ShowcaseBuilderHandler {

    @Override
    protected void buildShowcase() {
        if (canBuildShowcase()) {
            RootPanel.get().add(injector.getShowcaseTopPanel());
            RootPanel.get().add(injector.getShowcaseExamplePanel());

            injector.getEventBus().fireEvent(new ExamplePanelBuildEvent(""));
        }
    }

    @Override
    protected boolean canBuildShowcase() {
        return Boolean.TRUE;
    }

}
