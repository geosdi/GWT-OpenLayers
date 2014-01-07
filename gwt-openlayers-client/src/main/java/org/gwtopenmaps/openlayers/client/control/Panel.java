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

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 *
 */
public class Panel extends Control
{

    protected Panel(JSObject element)
    {
        super(element);
    }

    public Panel(PanelOptions options)
    {
        this(PanelImpl.create(options.getJSObject()));
    }

    public void addControls(Control[] controls)
    {
        JObjectArray controlArray = new JObjectArray(controls);
        PanelImpl.addControls(this.getJSObject(), controlArray.getJSObject());
    }
}
