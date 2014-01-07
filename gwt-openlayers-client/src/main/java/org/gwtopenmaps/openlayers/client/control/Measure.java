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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.MeasureEvent;
import org.gwtopenmaps.openlayers.client.event.MeasureListener;
import org.gwtopenmaps.openlayers.client.event.MeasurePartialListener;
import org.gwtopenmaps.openlayers.client.handler.Handler;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Michel Vitor A Rodrigues - Intec
 *
 */
public class Measure extends Control
{
    public static Measure narrowToMeasure(JSObject element)
    {
        return (element == null) ? null : new Measure(element);
    }

    protected Measure(JSObject element)
    {
        super(element);
    }

    public Measure(Handler handler)
    {
        this(MeasureImpl.create(handler.getJSObject()));
    }

    public Measure(Handler handler, MeasureOptions options)
    {
        this(MeasureImpl.create(handler.getJSObject(), options.getJSObject()));
    }

    public void setPersist(boolean persist)
    {
        MeasureImpl.setPersist(getJSObject(), persist);
    }

    public void addMeasureListener(final MeasureListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_MEASURE, new EventHandler()
            {
                public void onHandle(EventObject eventObject)
                {
                    MeasureEvent e = new MeasureEvent(eventObject);
                    listener.onMeasure(e);
                }
            });
    }

    public void addMeasurePartialListener(final MeasurePartialListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_MEASURE_PARTIAL, new EventHandler()
            {
                public void onHandle(EventObject eventObject)
                {
                    MeasureEvent e = new MeasureEvent(eventObject);
                    listener.onMeasurePartial(e);
                }
            });
    }
}
