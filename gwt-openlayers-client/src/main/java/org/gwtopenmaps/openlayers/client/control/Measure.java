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

	/**
	 * Activates the immediate measurement so that the "measurepartial" event is also fired once the measurement sketch
	 * is modified. Default is false.
	 * @return true on success, else false
	 */
	public boolean getImmediate()
	{
		return MeasureImpl.getImmediate(getJSObject());
	}

	/**
	 * Sets whether activate the immediate measurement so that the "measurepartial" event is also fired once the
	 * measurement sketch is modified. Default is false.
	 * @param immediate Activate the immediate measurement so that the "measurepartial" event is also fired once the
	 *            measurement sketch is modified?
	 */
	public void setImmediate(boolean immediate)
	{
		MeasureImpl.setImmediate(getJSObject(), immediate);
	}

    /**
     * Keep the temporary measure sketch or not.
     *
     * @return - true to keep the temporary measurement sketch drawn after
     *     the measurement is complete.  The geometry will persist until a new
     *     measurement is started, the control is deactivated, or <cancel> is called.
     *     Default is false.
     */
	public boolean getPersist()
	{
		return MeasureImpl.getPersist(getJSObject());
	}

    /**
     * Keep the temporary measure sketch or not.
     *
     * @param persist - Set to true to keep the temporary measurement sketch drawn after
     *     the measurement is complete.  The geometry will persist until a new
     *     measurement is started, the control is deactivated, or <cancel> is called.
     *     Default is false.
     */
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
