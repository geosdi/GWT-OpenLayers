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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import org.gwtopenmaps.demo.openlayers.client.ExampleBean;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class KvpParameterHandler extends ShowcaseBuilderHandler {

    public KvpParameterHandler() {
        super.setSuccessor(new AllExamplesHandler());
    }

    @Override
    protected void buildShowcase() {
        if (canBuildShowcase()) {
            ExampleBean exampleBean = injector.getExampleStore().getExample(Window.Location.getParameter("example"));
            exampleBean.getExample().buildPanel();
            RootPanel.get().add(exampleBean.getExample());
        } else {
            super.forwardBuildShowcase();
        }
    }

    @Override
    protected boolean canBuildShowcase() {
        return ((Window.Location.getParameter("example") != null)
                && (injector.getExampleStore().getExample(Window.Location.getParameter("example"))) != null);
    }

}
