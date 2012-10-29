package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;


/**
* @author Lorenzo Amato <lorenzo.amato@geosdi.org>
*
*/

public class TransformFeatureOptions extends ControlOptions{
	
	/**
     * Set the current rotation angle of the box
     * 
     * @param rotation
     */
	
	public void setRotation (int rotation){
		 getJSObject().setProperty("rotation", rotation);
	}
	
	/** Set the scale of the feature, relative to the scale the time the feature was set.
	 * 
	 * @param scale
	 */
	
	public void setScale (float scale){
		 getJSObject().setProperty("scale", scale);
	}
        
        
        /** Set the scale of the feature, relative to the scale the time the feature was set.
	 * 
	 * @param rotate
	 */
        public void setRotate (boolean rotate){
		 getJSObject().setProperty("rotate", rotate);
	}
        
        /** Set the Render intent for the transformation box and handles.
	 * 
	 * @param intent
	 */
        public void setRederIntent (String intent){
         getJSObject().setProperty("renderIntent", intent);
        }
        
        public void setRotationHandleSymbolizer(Style style){
         getJSObject().setProperty("rotationHandleSymbolizer", style.getJSObject());
        }
        
//        public void setFeature (VectorFeature feature){
//        getJSObject().setProperty("feature", feature.getJSObject());
//        }
	

}
