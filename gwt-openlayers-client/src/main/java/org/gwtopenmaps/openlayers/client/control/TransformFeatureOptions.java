/**
 *
 *   Copyright 2014 sourceforge.
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


/**
* @author Lorenzo Amato <lorenzo.amato@geosdi.org>
*
*/

public class TransformFeatureOptions extends ControlOptions{

	/**
     * Set the current rotation angle of the box
     * @param rotation
     */
	public void setRotation (int rotation){
		 getJSObject().setProperty("rotation", rotation);
	}

	/**
	 * Set the scale of the feature, relative to the scale the time the feature was set.
	 * @param scale
	 */

	public void setScale (float scale){
		 getJSObject().setProperty("scale", scale);
	}


    /**
     * Set to false if rotation should be disabled.  Default is true.
     * @param rotate
     */
    public void setRotate (boolean rotate){
        getJSObject().setProperty("rotate", rotate);
    }

    /** Set the Render intent for the transformation box and handles.
     *  @param intent
     */
    public void setRederIntent (String intent){
        getJSObject().setProperty("renderIntent", intent);
    }

    /**
     * Custom symbolizer for the rotation handles.
     * @param style the style for the rotation handlers
     */
    public void setRotationHandleSymbolizer(Style style){
        getJSObject().setProperty("rotationHandleSymbolizer", style.getJSObject());
    }

    /**
     * Set to true to not change the feature’s aspect ratio, default is false.
     * @param preserveAspectRatio True or false
     */
    public void setPreserveAspectRatio(boolean preserveAspectRatio) {
        getJSObject().setProperty("preserveAspectRatio", preserveAspectRatio);
    }

}
