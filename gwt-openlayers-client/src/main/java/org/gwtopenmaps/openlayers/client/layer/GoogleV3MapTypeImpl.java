package org.gwtopenmaps.openlayers.client.layer;

/**
 * @author Max Gensthaler
 */
class GoogleV3MapTypeImpl {
   /** This is the normal street map type. */
   native static public String G_NORMAL_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.RADMAP) return $wnd.google.maps.MapTypeId.RADMAP;
      else return null;
   }-*/;

   /** This map type shows Google Earth satellite images. */
   native static public String G_SATELLITE_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.SATELLITE) return $wnd.google.maps.MapTypeId.SATELLITE;
      else return null;
   }-*/;

   /** This map type shows transparent street maps over Google Earth satellite images. */
   native static public String G_HYBRID_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.HYBRID) return $wnd.google.maps.MapTypeId.HYBRID;
      else return null;
   }-*/;

   /** This map type shows transparent street maps over Google Earth satellite images. */
   native static public String G_TERRAIN_MAP()/*-{
      if ($wnd.google.maps.MapTypeId.TERRAIN) return $wnd.google.maps.MapTypeId.TERRAIN;
      else return null;
   }-*/;
}