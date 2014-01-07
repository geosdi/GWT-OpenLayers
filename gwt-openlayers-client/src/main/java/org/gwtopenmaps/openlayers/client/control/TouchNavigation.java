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
 * This control is added to OpenLayers mobile maps by default.
 *
 * Other controls that are added by default are the {@link PanZoom},
 * {@link ArgParser}, and {@link Attribution}.
 *
 * @author Jon Britton
 */
public class TouchNavigation extends Control
{

    protected TouchNavigation(JSObject element)
    {
        super(element);
    }

    public TouchNavigation()
    {
        this(TouchNavigationImpl.create());
    }

    public TouchNavigation(TouchNavigationOptions options)
    {
        this(TouchNavigationImpl.create(options.getJSObject()));
    }
}
