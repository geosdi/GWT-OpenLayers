/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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