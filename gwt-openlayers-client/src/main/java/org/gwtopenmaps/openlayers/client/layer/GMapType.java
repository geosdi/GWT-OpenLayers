package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class GMapType extends OpenLayersObjectWrapper
{
   /**
    * This map type shows Google Earth satellite images.
    */
   static final public GMapType G_SATELLITE_MAP = 
         narrowToGMapType(GMapTypeImpl.G_SATELLITE_MAP());
   
   /**
    * Normal street map type.
    */
   static final public GMapType G_NORMAL_MAP = 
         narrowToGMapType(GMapTypeImpl.G_NORMAL_MAP());
   
   /**
    * This map type transposes street maps and labels over satellite images.
    */
   static final public GMapType G_HYBRID_MAP = 
         narrowToGMapType(GMapTypeImpl.G_HYBRID_MAP());
   
   protected GMapType(JSObject element)
   {
      super(element);
   }
   
   protected static GMapType narrowToGMapType(JSObject element)
   {
      return (element == null)? null : new GMapType(element);
   }
}
