package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GoogleImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Google(name);
	}-*/;

   public static native JSObject create(String name, JSObject params)
   /*-{
      return new $wnd.OpenLayers.Layer.Google(name, params);
   }-*/;
	
}
