/**
 *
 *   Copyright 2013 sourceforge.
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
