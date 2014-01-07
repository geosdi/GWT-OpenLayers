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
 * Displays the geographic coordinates of the position of the mouse cursor.
 *
 * To display the coordinates outside the map, the HTML element where the
 * coordinates should be displayed should be passed to the constructor.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 * @since GWT-OL 0.2
 */
public class MousePosition extends Control
{

    protected MousePosition(JSObject element)
    {
        super(element);
    }

    public MousePosition()
    {
        this(MousePositionImpl.create());
    }

    /**
     *
     * @param options -
     * @since GWT-OL 0.4
     */
    public MousePosition(MousePositionOptions options)
    {
        this(MousePositionImpl.create(options.getJSObject()));
    }

    //
    // legacy
    //

    /*
    //TODO: move to MousePositionOptions
            public MousePosition(Element divId) {
                    super((JSObject)null);
                    Options options = new Options();
                    options.getJSObject().setProperty("element", divId);
                    setJSObject(MousePositionImpl.create(options.getJSObject()));
            }
     */

}
