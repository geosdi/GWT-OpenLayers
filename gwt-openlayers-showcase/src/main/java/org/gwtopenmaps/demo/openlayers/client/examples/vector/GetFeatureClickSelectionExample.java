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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.ShowSourceButton;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.control.GetFeatureOptions;
import org.gwtopenmaps.openlayers.client.event.FeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;

public class GetFeatureClickSelectionExample extends FeatureSelectionExample {

    @Inject
    public GetFeatureClickSelectionExample(ShowcaseExampleStore store) {
        super("WFS Get Feature Control Click Examples",
                "Demonstrates the use of WMS/WFS click selection.",
                new String[]{"WFS", "VectorFeature", "selection"}, store);
    }

    @Override
    public void buildPanel() {
        super.buildPanel();

        controlFeature.addFeatureSelectedListener(
                new FeatureSelectedListener() {

            public void onFeatureSelected(
                    FeatureSelectedListener.FeatureSelectedEvent event) {

                final VectorFeature vectorFeature = event.getFeature();
                select.addFeature(vectorFeature);
            }

        });

        controlFeature.addFeatureUnselectedListener(
                new FeatureUnselectedListener() {

            public void onFeatureUnselected(
                    FeatureUnselectedListener.FeatureUnselectedEvent event) {
                VectorFeature vectorFeature = event.getFeature();

                select.removeFeature(vectorFeature);
            }

        });


        ShowSourceButton btn = new ShowSourceButton("FeatureSelectionExample");
        btn.setSourceCodeURL(super.getSourceCodeURL());
        contentPanel.add(btn);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/vector/"
                + "GetFeatureClickSelectionExample.txt";
    }

    @Override
    protected GetFeatureOptions createGetFeatureOptions() {
        return new GetFeatureOptions();
    }

    @Override
    protected Widget createComponent() {
        return new HTML("<p>This example shows how to use a "
                + "selection feature on a WMS layer.</p>"
                + "<p>Single Click on a states to see feature</p>");
    }

}
