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
package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Events extends OpenLayersObjectWrapper
{

    public static Events narrowToEvents(JSObject element)
    {
        return (element == null) ? null : new Events(element);
    }

    protected Events(JSObject element)
    {
        super(element);
    }

    public void register(String type, OpenLayersObjectWrapper obj, EventHandler handler)
    {
        EventsImpl.register(getJSObject(), type, obj.getJSObject(), handler.getJSObject());
    }

    public void on(OpenLayersObjectWrapper obj)
    {
        EventsImpl.on(getJSObject(), obj.getJSObject());
    }

    public void unregister(String type, OpenLayersObjectWrapper obj, EventHandler handler)
    {
        EventsImpl.unregister(getJSObject(), type, obj.getJSObject(), handler.getJSObject());
    }

    public void stop(EventObject event, boolean allowDefault)
    {
        EventsImpl.stop(event.getJSObject(), allowDefault);
    }

    public void stop(EventObject event)
    {
        this.stop(event, false);
    }

    public Pixel getMousePosition(Event event)
    {
        return Pixel.narrowToPixel(EventsImpl.getMousePosition(getJSObject(), event.getJSObject()));
    }


}
