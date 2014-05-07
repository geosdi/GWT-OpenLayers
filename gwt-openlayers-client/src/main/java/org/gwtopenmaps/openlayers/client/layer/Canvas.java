/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * comment: no such layer in OpenLayers 2.x
 *
 * @author Erdem Gunay
 *
 */
@Deprecated
public class Canvas extends Layer {

    protected Canvas(JSObject element) {
        super(element);
    }

    public Canvas(String name) {
        this(CanvasImpl.create(name));
    }

    public void drawLine(LonLat p1, LonLat p2) {
        CanvasImpl.drawLine(getJSObject(), p1.getJSObject(), p2.getJSObject());
    }

}
