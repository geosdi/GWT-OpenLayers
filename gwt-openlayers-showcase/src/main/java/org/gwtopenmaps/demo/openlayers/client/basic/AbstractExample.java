package org.gwtopenmaps.demo.openlayers.client.basic;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The abstract base for each Example
 *
 * @author Frank Wynants
 *
 */
public abstract class AbstractExample extends Composite {

    protected VerticalPanel contentPanel = new VerticalPanel();
    private final ShowSourceButton butShowSource = new ShowSourceButton();

    /**
     * The constructor.
     *
     * @param title The title of the example
     * @param textResource The source of the example.
     */
    public AbstractExample(String title) {
        setTitle(title);
        butShowSource.setSourceCodeURL(getSourceCodeURL());
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
}