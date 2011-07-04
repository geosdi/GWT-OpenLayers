package org.gwtopenmaps.openlayers.client.layer;


/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GMapTypeImpl
{
// Constants
// Constants Description

   /*
    * G_NORMAL_MAP  This is the normal street map type.
    */
   native static public String G_NORMAL_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.RADMAP) return $wnd.google.maps.MapTypeId.RADMAP; // google maps api 3.x
      // is JSObject: else if ($wnd.G_NORMAL_MAP) return $wnd.G_NORMAL_MAP; // google maps api 2.x
      else return null;
   }-*/;

   /*
    * G_SATELLITE_MAP  This map type shows Google Earth satellite images.
    */
   native static public String G_SATELLITE_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.SATELLITE) return $wnd.google.maps.MapTypeId.SATELLITE; // google maps api 3.x
      // is JSObject: else if ($wnd.G_SATELLITE_MAP) return $wnd.G_SATELLITE_MAP; // google maps api 2.x
      else return null;
   }-*/;

   /*
    * G_HYBRID_MAP  This map type shows transparent street maps over Google Earth satellite images.
    */
   native static public String G_HYBRID_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.HYBRID) return $wnd.google.maps.MapTypeId.HYBRID; // google maps api 3.x
      // is JSObject: else if ($wnd.G_HYBRID_MAP) return $wnd.G_HYBRID_MAP; // google maps api 2.x
      else return null;
   }-*/;

   /*
    * G_TERRAIN_MAP  This map type shows transparent street maps over Google Earth satellite images.
    */
   native static public String G_TERRAIN_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.TERRAIN) return $wnd.google.maps.MapTypeId.TERRAIN; // google maps api 3.x
      // non existent in google maps api 2.x
      else return null;
   }-*/;
}
