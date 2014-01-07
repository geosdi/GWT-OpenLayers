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
package org.gwtopenmaps.openlayers.client.marker;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.Marker;
import org.gwtopenmaps.openlayers.client.event.BoxEventListener;
import org.gwtopenmaps.openlayers.client.event.BoxEventListener.BoxEvents;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
*
* @author Michel Vitor - Intec
*
*/
public class Box extends Marker
{
    public static Box narrowToBox(JSObject element)
    {
        return (element == null) ? null : new Box(element);
    }

    protected Box(JSObject element)
    {
        super(element);
    }

    public Box(Bounds bounds, String borderColor, int borderWidth)
    {
        this(BoxImpl.create(bounds.getJSObject(), borderColor, borderWidth));
    }

    public Box(Bounds bounds)
    {
        this(BoxImpl.create(bounds.getJSObject(), "red", 2));
    }

    public void setBorder(String borderColor, int borderWidth)
    {
        BoxImpl.setBorder(getJSObject(), borderColor, borderWidth);
    }

    public void setZIndex(int zIndex)
    {
        BoxImpl.setZIndex(getJSObject(), zIndex);
    }

    public String getZIndex()
    {
        return BoxImpl.getZIndex(getJSObject());
    }

    public Bounds getBounds()
    {
        return Bounds.narrowToBounds(BoxImpl.getBounds(getJSObject()));
    }

    public void addBoxEventListener(String Event, final BoxEventListener listener)
    {
        eventListeners.addListener(this, listener, Event, new EventHandler()
            {
                public void onHandle(EventObject eventObject)
                {
                    BoxEvents e = new BoxEvents(eventObject);
                    listener.onBox(e);
                }
            });
    }

}
