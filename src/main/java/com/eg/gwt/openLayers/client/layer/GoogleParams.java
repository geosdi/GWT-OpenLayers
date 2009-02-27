package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.Options;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class GoogleParams extends Options
{
   public void setType(GMapType type)
   {
      setAttribute("type", type.getJSObject());
   }

   public void setSphericalMercator(boolean value)
   {
      setAttribute("sphericalMercator", value);
   }
}
