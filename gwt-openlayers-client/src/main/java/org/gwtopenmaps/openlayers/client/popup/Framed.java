/**
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 * @author <a href="mailto:marten.karlberg@digpro.se">Marten Karlberg</a>, Digpro AB
 *
 */
public class Framed extends Popup
{

    protected Framed(JSObject element)
    {
        super(element);
    }

    /*
     * Constructor also taking a CloseListener callback as suggested by the original OpenLayers
     * JavaScript constructor.
     *
     * Added by Digpro.
     */
    public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor,
        boolean closeBox, CloseListener closeBoxCallback)
    {

        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox,
                (closeBoxCallback != null) ? closeBoxCallback : null));
        this.id = id; 
    }

    /**
     *
     * Use addCloseListener to respond to popup close event. (Beware! This does not work as
     * expected. Instead pass the CloseListener in the constructor for proper binding. /Digpro)
     *
     * @param anchor - ...
     *
     * For explanation of other parameters see {@link Popup}.
     */
    public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor,
        boolean closeBox)
    {
        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                (anchor != null) ? anchor.getJSObject() : null,
                closeBox));
        this.id = id;   
    }

    public Framed(String id, LonLat lonlat, Size size, String html, boolean closeBox)
    {
        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                (size != null) ? size.getJSObject() : null,
                html,
                null,
                closeBox));
        this.id = id; 
    }

    public Framed(String id, LonLat lonlat, String html, boolean closeBox)
    {
        this(FramedImpl.create(id,
                lonlat.getJSObject(),
                null,
                html,
                null,
                closeBox));
                
        this.id = id; 
    }
}
