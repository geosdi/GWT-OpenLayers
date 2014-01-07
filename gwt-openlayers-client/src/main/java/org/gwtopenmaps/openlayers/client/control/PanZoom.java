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
 * Pan and Zoom control.
 *
 * This control is added to OpenLayers maps by default.
 * Remove this control from the map when using the PanZoomBar.
 *
 * Other controls that are added by default are the {@link Attribution},
 * {@link Navigation} and {@link ArgParser}.
 *
 * @author Edwin Commandeur
 * @since GWT-OL 0.4
 */
public class PanZoom extends Control
{

    protected PanZoom(JSObject element)
    {
        super(element);
    }

    public PanZoom()
    {
        this(PanZoomImpl.create());
    }

    public PanZoom(PanZoomOptions options)
    {
        this(PanZoomImpl.create(options.getJSObject()));
    }

}
