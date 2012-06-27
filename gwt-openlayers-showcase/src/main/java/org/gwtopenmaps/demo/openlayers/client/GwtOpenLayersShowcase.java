package org.gwtopenmaps.demo.openlayers.client;

import java.util.ArrayList;
import java.util.List;

import org.gwtopenmaps.demo.openlayers.client.i18n.I18NMessages;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


/**
 * Entry point for GWT OpenLayers showcase.
 */
public class GwtOpenLayersShowcase implements EntryPoint, FocusHandler, BlurHandler
{
   public static final I18NMessages I18N = (I18NMessages) GWT.create(I18NMessages.class);
	
	private final TextBox txtSearch = new TextBox();
	private final Label lblNumberOfExamples = new Label("(0)");
	
	private final FlowPanel examplesPanel = new FlowPanel();
	
	private final List<Example> examples = new ArrayList<Example>();

    /**
     * main panel contains the showcase app
     */

    /**
     * Entry point for the GWT OpenLayers Showcase
     */
    public void onModuleLoad()
    {
       buildTopPanel();
       loadExamples();
       buildExamplePanels("");
    }

    /**
     * Reads in all the examples.
     */
   private void loadExamples()
   {
      examples.add(new Example("Basic OSM example", "Show a simple OSM map.", new String[]{"openstreetmap", "OSM", "basic"}));
      examples.add(new Example("BING example", "Demonstrates the use of Bing layers.", new String[]{"Bing", "Microsoft", "Virtual Earth"}));
      examples.add(new Example("Google layer example", "Demonstrates the use of the various types of Google layers.", new String[]{"Google"}));
      examples.add(new Example("WMS example", "Show the basic use of a WMS layer in GWT-OL.", new String[]{"WMS", "basic"}));
      examples.add(new Example("Measure example", "Shows how to use the measure control to measure distances and and areas.", new String[]{"measure", "control", "length", "distance", "area", "measure", "control", "length", "distance", "area", "measure", "control", "length", "distance", "area"}));
      
      lblNumberOfExamples.setText("(" + examples.size() + ")");
   }

/**
 * Creates a panel for each available example.
 */
   private void buildExamplePanels(final String filter)
   {
      examplesPanel.clear();
      
      //TODO filter
      for (Example example : examples)
      {
         examplesPanel.add(new ExamplePanel(example));
      }
   }

/**
 * Builds the top panel containing the logo, the searchbox, and the number of examples currently shown.
 */
   private void buildTopPanel()
   {
      final HorizontalPanel hpTop = new HorizontalPanel();
      hpTop.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      hpTop.setStyleName("top");

      final Image imgLogo = new Image(Resources.INSTANCE.gwtOlLogo());
      hpTop.add(imgLogo);
      final HorizontalPanel hpTopSearch = new HorizontalPanel();
      hpTopSearch.setSpacing(3);
      hpTop.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      hpTopSearch.add(txtSearch);
      hpTopSearch.add(lblNumberOfExamples);
      hpTop.add(hpTopSearch);
      hpTop.setCellWidth(imgLogo, "1px");

      txtSearch.setText(I18N.filterByKeywords());
      txtSearch.setStyleName("emptytextbox");

      txtSearch.addFocusHandler(this);
      txtSearch.addBlurHandler(this);

      RootPanel.get().add(hpTop);
      examplesPanel.setWidth("100%");
      RootPanel.get().add(examplesPanel);
   }

   /*
     * (non-Javadoc)
     * @see com.google.gwt.event.dom.client.FocusHandler#onFocus(com.google.gwt.event.dom.client.FocusEvent)
     */
   public void onFocus(FocusEvent event)
   {
      if (event.getSource() == txtSearch)
      {
         if (txtSearch.getText().equals(I18N.filterByKeywords())) 
         {
            txtSearch.setText("");
            txtSearch.removeStyleName("emptytextbox");
         }
      }
   }

   /*
    * (non-Javadoc)
    * @see com.google.gwt.event.dom.client.BlurHandler#onBlur(com.google.gwt.event.dom.client.BlurEvent)
    */
   public void onBlur(BlurEvent event)
   {
      if (event.getSource() == txtSearch)
      {
         if (txtSearch.getText().trim().equals(""))
         {
            txtSearch.setText(I18N.filterByKeywords());
            txtSearch.addStyleName("emptytextbox");
         }
      }
   }
}