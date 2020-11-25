/*
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
package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.Pixel;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapClickListener extends EventListener
{

    public void onClick(MapClickEvent mapClickEvent);

    class MapClickEvent extends MapEvent
    {

        public MapClickEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        public LonLat getLonLat()
        {
            Map map = Map.narrowToMap(this.getSourceJSObject());
            Pixel pixel = Pixel.narrowToPixel(getJSObject().getProperty("xy"));

            return (pixel != null) ? map.getLonLatFromPixel(pixel) : null;
        }

        public Pixel getPixel()
        {
            return Pixel.narrowToPixel(getJSObject().getProperty("xy"));
        }
    }
}
