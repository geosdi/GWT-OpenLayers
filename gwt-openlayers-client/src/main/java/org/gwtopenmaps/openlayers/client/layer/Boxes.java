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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.marker.Box;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
* <p>
* Boxes is only maintained for backwards compatibility, as explained <a href="http://docs.openlayers.org/library/layers.html">here<a>.
*  Alternatively, use Vector Layers, as described <a href="http://docs.openlayers.org/library/overlays.html">here</a>.
* </p>
*
* @author Michel Vitor A Rodrigues
*/
public class Boxes extends Markers
{

    protected Boxes(JSObject boxes)
    {
        super(boxes);
    }

    public Boxes(String name, BoxesMarkersOptions options)
    {
        this(BoxesImpl.create(name, options.getJSObject()));
    }

    public Boxes(String name)
    {
        this(BoxesImpl.create(name));
    }

    public Boxes narrowToBoxes(JSObject boxes)
    {
        return (boxes == null) ? null : new Boxes(boxes);
    }

    public void drawMarker(Box marker)
    {
        BoxesImpl.drawMarker(getJSObject(), marker);
    }

    public void removeMarker(Box marker)
    {
        BoxesImpl.removeMarker(getJSObject(), marker);
    }

}
