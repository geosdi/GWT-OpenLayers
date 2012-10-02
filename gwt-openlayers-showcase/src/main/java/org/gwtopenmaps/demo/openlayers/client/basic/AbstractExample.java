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
    private final ShowSourceButton butShowSource = new ShowSourceButton();
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