package org.gwtopenmaps.demo.openlayers.client;

import org.gwtopenmaps.demo.openlayers.client.i18n.I18NMessages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * A clickable example panel.
 * @author Frank Wynants
 *
 */

public class ExamplePanel extends Composite
{
   public static final I18NMessages I18N = (I18NMessages) GWT.create(I18NMessages.class);
   
/**
 * Constructs the ExamplePanel using an Example
 * @param example
 */
   public ExamplePanel(final Example example)
   {
      final VerticalPanel vp = new VerticalPanel();
      vp.setSpacing(5);
      
      final ScrollPanel sp = new ScrollPanel();
      sp.getElement().getStyle().setOverflowX(Overflow.HIDDEN);
      sp.setSize("350px", "100px");
      sp.setWidget(vp);
      
      final Label lblName = new Label(example.getName());
      final Label lblDescription = new Label(example.getDescription());
      final StringBuffer sb = new StringBuffer();
      final String[] tags = example.getTags();
      for (String tag : tags)
      {
         sb.append(tag).append(", ");
      }
      final Label lblTags = new Label(I18N.tags(sb.toString().substring(0, sb.toString().length() - 2)));
      lblTags.setStyleName("exampletags");
      
      lblName.setStyleName("examplename");
      vp.add(lblName);
      vp.add(lblDescription);
      vp.add(lblTags);
      
      this.initWidget(sp);
      this.setStyleName("examplepanel");
   }
}