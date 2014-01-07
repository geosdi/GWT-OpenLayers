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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.symbolizer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * @author lorenzo
 *
 */
public class SymbolizerOptions extends JSObjectWrapper
{

    protected SymbolizerOptions(JSObject jsObject)
    {
        super(jsObject);
        // TODO Auto-generated constructor stub
    }

    public SymbolizerOptions()
    {
        // TODO Auto-generated constructor stub
        this(JSObject.createJSObject());
    }

    /**
     * APIProperty: zIndex
     * {Number} The zIndex determines the rendering order for a symbolizer.
     *     Symbolizers with larger zIndex values are rendered over symbolizers
     *     with smaller zIndex values.  Default is 0.
     */

    public void setZindex(int zIndex)
    {
        getJSObject().setProperty("zIndex", zIndex);
    }


}
