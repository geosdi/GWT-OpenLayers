package org.gwtopenmaps.demo.openlayers.client.examples;

import org.gwtopenmaps.demo.openlayers.client.DialogBoxWithCloseButton;
import org.gwtopenmaps.demo.openlayers.client.GwtOpenLayersShowcase;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ShowSourceButton extends Composite implements ClickHandler
{
   private Button but = new Button(GwtOpenLayersShowcase.I18N.viewSource(), this);
   
   private String source = null;

   /**
    * Constructor
    */
   public ShowSourceButton()
   {
      initWidget(but);
   }
   
   /**
    * @param source the source to set
    */
   public void setSource(String source)
   {
      this.source = source;
   }

   /*
    * (non-Javadoc)
    * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
    */
   public void onClick(ClickEvent event)
   {
      if (source == null) Window.alert(GwtOpenLayersShowcase.I18N.noSourceFound());
      else
      {
         //source = "package be.fks.test;\n\npublic static void main (String[] args)\n{\n   System.out.println(\"Testing stuff\");\n}";
         
         
         final String html = "<pre class=\"brush: java; toolbar: false;\">" + source + "</pre>";
         ScrollPanel sp = new ScrollPanel();
         sp.setSize((Window.getClientWidth() * 0.6) + "px", (Window.getClientHeight() * 0.7) + "px");
         sp.add(new HTML(html));

          DialogBoxWithCloseButton dialogBox = new DialogBoxWithCloseButton(false);
          dialogBox.setWidget(sp);
          dialogBox.setText(GwtOpenLayersShowcase.I18N.viewSource());
          dialogBox.center();
          
          doFormat();
       }
   }
   
   private native void doFormat()
   /*-{
      $wnd.SyntaxHighlighter.highlight();
   }-*/;   
}
