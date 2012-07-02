package org.gwtopenmaps.demo.openlayers.client;

import java.util.ArrayList;
import java.util.List;

import org.gwtopenmaps.demo.openlayers.client.examples.basicbing.BasicBingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicosm.BasicOsmExample;
import org.gwtopenmaps.demo.openlayers.client.i18n.I18NMessages;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
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
public class GwtOpenLayersShowcase implements EntryPoint, FocusHandler, BlurHandler, KeyUpHandler
{
   public static final I18NMessages I18N = (I18NMessages) GWT.create(I18NMessages.class);
	
	private final TextBox txtSearch = new TextBox();
	private final Label lblNumberOfExamples = new Label("(0)");
	
	private final FlowPanel examplesPanel = new FlowPanel();
	
	private final List<ExampleBean> examples = new ArrayList<ExampleBean>();

    /**
     * main panel contains the showcase app
     */

    /**
     * Entry point for the GWT OpenLayers Showcase
     */
    public void onModuleLoad()
    {
       loadExamples();
       if (Window.Location.getParameter("example") != null)
       {
          for (ExampleBean example : examples)
          {
             if (example.getName().equals(Window.Location.getParameter("example"))) 
             {
                example.getExample().buildPanel();
                RootPanel.get().add(example.getExample());
             }
          }
       }
       else
       {
          buildTopPanel();
          buildExamplePanels("");
       }
    }

    /**
     * Reads in all the examples.
     */
   private void loadExamples()
   {
      String name = "Basic OSM example";
      examples.add(new ExampleBean(name, "Show a simple OSM map.", new String[]{"openstreetmap", "OSM", "basic"}, new BasicOsmExample(name, I18N.basicOsmExampleSource())));
      
      name = "Basic Bing example";
      examples.add(new ExampleBean(name, "Demonstrates the use of Bing layers.", new String[]{"Bing", "Microsoft", "Virtual Earth"}, new BasicBingExample(name, I18N.basicBingExampleSource())));
   }

/**
 * Creates a panel for each available example.
 */
   private void buildExamplePanels(final String filter)
   {
      examplesPanel.clear();
      
      int numberOfExamples = 0;
      
      for (ExampleBean example : examples)
      {
         boolean show = false;
         String[] tags = example.getTags();
         if ((filter == null) || (filter.trim().equals(""))) show = true;
         else
         {
            for (String tag : tags)
            {
               if (tag.trim().toLowerCase().contains(filter.trim().toLowerCase()))
               {
                  show = true;
                  break;
               }
            }
         }
         
         
         if (show) 
         {
            examplesPanel.add(new ExamplePanel(example));
            numberOfExamples++;
         }
      }
      
      lblNumberOfExamples.setText("(" + numberOfExamples + ")");
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
      txtSearch.addKeyUpHandler(this);

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

   /*
    * (non-Javadoc)
    * @see com.google.gwt.event.dom.client.KeyUpHandler#onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent)
    */
   public void onKeyUp(KeyUpEvent event)
   {
      if (event.getSource() == txtSearch) buildExamplePanels(txtSearch.getText());
      
   }
}