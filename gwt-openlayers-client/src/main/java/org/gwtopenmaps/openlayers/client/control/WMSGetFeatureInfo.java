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
