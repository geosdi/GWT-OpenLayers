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
package org.gwtopenmaps.demo.openlayers.client.basic;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.gwtopenmaps.demo.openlayers.client.ExampleBean;
import org.gwtopenmaps.demo.openlayers.client.components.store.ExampleStore;

/**
 * The abstract base for each Example
 *
 * @author Frank Wynants
 *
 */
public abstract class AbstractExample extends Composite {

    protected VerticalPanel contentPanel = new VerticalPanel();
    private final ShowSourceButton butShowSource = new ShowSourceButton("");
    protected ExampleBean example;

    public AbstractExample(String name, String description, String[] tags,
            ExampleStore store) {
       this(name, description, tags);
       store.addExample(example);
    }

    /**
     * The constructor.
     *
     */
    public AbstractExample(String name, String description, String[] tags) {
        setTitle(name);
        butShowSource.setSourceCodeURL(getSourceCodeURL());

        this.example = new ExampleBean(name, description, tags, this);
    }

    public abstract void buildPanel();

    public abstract String getSourceCodeURL();

    /**
     * @param title the title to set
     */
    @Override
    public void setTitle(String title) {
        contentPanel.setSpacing(5);
        contentPanel.getElement().getStyle().setPadding(10, Unit.PX);
        contentPanel.setWidth("100%");
        contentPanel.add(new HTML("<H1>" + title + "</H1>"));
        contentPanel.add(butShowSource);
    }

    /**
     * @return the example
     */
    public ExampleBean getExample() {
        return example;
    }
}