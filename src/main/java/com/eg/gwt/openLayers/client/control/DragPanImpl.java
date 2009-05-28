package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class DragPanImpl
{
   
   public static native JSObject create()
   /*-{
      return new $wnd.OpenLayers.Control.DragPan();
   }-*/;
   
   public static native JSObject create(JSObject options) /*-{
      return new $wnd.OpenLayers.Control.DragPan(
          $wnd.gwt_openlayers_util.eventListenersToObject(options));
   }-*/;

}
