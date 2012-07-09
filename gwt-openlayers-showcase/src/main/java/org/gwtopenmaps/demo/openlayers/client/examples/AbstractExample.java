package org.gwtopenmaps.demo.openlayers.client.examples;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The abstract base for each Example
 * @author Frank
 *
 */

public abstract class AbstractExample extends Composite
{
   protected VerticalPanel contentPanel = new VerticalPanel();
   
   private final ShowSourceButton butShowSource = new ShowSourceButton();
   
   /**
    * The constructor.
    * @param title The title of the example
    * @param source The source of the example.
    */
   public AbstractExample(String title, String source)
   {
      setTitle(title);
      butShowSource.setSource(source);
   }
   
   public abstract void buildPanel();

   /**
    * @param title the title to set
    */
   public void setTitle(String title)
   {
      contentPanel.setSpacing(5);
      contentPanel.getElement().getStyle().setPadding(10, Unit.PX);
      contentPanel.setWidth("100%");
      contentPanel.add(new HTML("<H1>" + title + "</H1>"));
      contentPanel.add(butShowSource);
   }
}