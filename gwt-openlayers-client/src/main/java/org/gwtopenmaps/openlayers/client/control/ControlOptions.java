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

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Options specific to Control widgets.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ControlOptions extends OpenLayersEObjectWrapper
{

    protected ControlOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public ControlOptions()
    {
        this(JSObject.createJSObject());
    }
    
    public void setAutoActivate(boolean autoActivate)
    {
        getJSObject().setProperty("autoActivate", autoActivate);
    }
}
