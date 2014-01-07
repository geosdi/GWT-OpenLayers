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

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @deprecated This class will be removed in OpenLayers 3.0, use NavToolbar instead
 */
public class MouseToolbar extends Control
{

    protected MouseToolbar(JSObject element)
    {
        super(element);
    }

    public MouseToolbar()
    {
        this(MouseToolbarImpl.create());
    }

    public MouseToolbar(MouseToolbarOptions options)
    {
        this(MouseToolbarImpl.create(options.getJSObject()));
    }
}
