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

import org.gwtopenmaps.openlayers.client.event.BeforeGetFeatureInfoListener;
import org.gwtopenmaps.openlayers.client.event.BeforeGetFeatureInfoListener.BeforeGetFeatureInfoEvent;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.GetFeatureInfoListener;
import org.gwtopenmaps.openlayers.client.event.GetFeatureInfoListener.GetFeatureInfoEvent;
import org.gwtopenmaps.openlayers.client.event.NoGetFeatureInfoListener;
import org.gwtopenmaps.openlayers.client.event.NoGetFeatureInfoListener.NoGetFeatureInfoEvent;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Dave Potts
 * @author Edwin Commandeur
 *
 * requires OpenLayers 2.7 or higher
 */
public class WMSGetFeatureInfo extends Control
{
    public static WMSGetFeatureInfo narrowToWMSGetFeatureInfo(JSObject object)
    {
        return (object == null) ? null : new WMSGetFeatureInfo(object);
    }

    protected WMSGetFeatureInfo(JSObject wMSGetFeatureInfo)
    {
        super(wMSGetFeatureInfo);
    }

    public WMSGetFeatureInfo()
    {
        this(WMSGetFeatureInfoImpl.create());
    }

    public WMSGetFeatureInfo(WMSGetFeatureInfoOptions o)
    {
        this(WMSGetFeatureInfoImpl.create(o.getJSObject()));
    }

    public void addBeforeGetFeatureListener(final BeforeGetFeatureInfoListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_GET_FEATURE_INFO_BEFORE, new EventHandler()
            {
                @Override
                public void onHandle(EventObject eventObject)
                {
                    BeforeGetFeatureInfoEvent e = new BeforeGetFeatureInfoEvent(eventObject);
                    listener.onBeforeGetFeatureInfo(e);
                }
            });
    }

    public void addGetFeatureListener(final GetFeatureInfoListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_GET_FEATURE_INFO, new EventHandler()
            {
                @Override
                public void onHandle(EventObject eventObject)
                {
                    GetFeatureInfoEvent e = new GetFeatureInfoEvent(eventObject);
                    listener.onGetFeatureInfo(e);
                }
            });
    }

    public void addNoGetFeatureListener(final NoGetFeatureInfoListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_NO_GET_FEATURE_INFO, new EventHandler()
            {

                @Override
                public void onHandle(EventObject eventObject)
                {
                    NoGetFeatureInfoEvent e = new NoGetFeatureInfoEvent(eventObject);
                    listener.onNoGetFeatureInfo(e);
                }
            });
    }
}
