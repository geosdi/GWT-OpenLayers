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
package org.gwtopenmaps.openlayers.client.filter;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Mikael Couzic
 */
public class FeatureIdFilterImpl
{

    public static native JSObject create(JSObject fids) /*-{
        // JavaScript can loose the type of objects.
        // the Array that was created in JArrayBaseImpl is reported as an "object"
        // when the OpenLayers code checks for instanceof Array.  Converting the passed in urls Array to a new Array corrects this problem.
        // There may be a better way, until it is figured out, this is what is done.
        
        var newArray = new $wnd.Array(fids.length);
        for (i = 0; i < fids.length; i++) {
        newArray[i] = fids[i];
        }
        return new $wnd.OpenLayers.Filter.FeatureId({fids: newArray});
    }-*/;

}
