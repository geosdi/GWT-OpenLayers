package org.gwtopenmaps.demo.openlayers.client.i18n;

import com.google.gwt.i18n.client.Messages;

/**
 * Defines the messages that can be used.
 * 
 * @author fks/Frank Wynants
 * 
 */
public interface I18NMessages extends Messages
{
   String filterByKeywords();
   String tags(String string);
   String viewSource();
   String noSourceFound();
   
   String basicOsmExampleSource();
   String basicBingExampleSource();
   String basicGoogleExampleSource();
}