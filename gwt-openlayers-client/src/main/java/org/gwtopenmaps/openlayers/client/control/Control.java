package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.event.ControlActivateListener;
import org.gwtopenmaps.openlayers.client.event.ControlActivateListener.ControlActivateEvent;
import org.gwtopenmaps.openlayers.client.event.ControlDeactivateListener;
import org.gwtopenmaps.openlayers.client.event.ControlDeactivateListener.ControlDeactivateEvent;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
public class Control extends OpenLayersEObjectWrapper
{

    public static Control narrowToControl(JSObject object)
    {
        return new Control(object);
    }

    protected Control(JSObject element)
    {
        super(element);
    }

    public void setAutoActivate(boolean autoActivate)
    {
        getJSObject().setProperty("autoActivate", autoActivate);
    }

    public boolean activate()
    {
        return ControlImpl.activate(getJSObject());
    }

    public boolean deactivate()
    {
        return ControlImpl.deactivate(getJSObject());
    }

    public void addControlActivateListener(final ControlActivateListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_ACTIVATE, new EventHandler()
            {
                public void onHandle(EventObject eventObject)
                {
                    ControlActivateEvent e = new ControlActivateEvent(eventObject);
                    listener.onActivate(e);
                }
            });
    }

    public void addControlDeactivateListener(final ControlDeactivateListener listener)
    {
        eventListeners.addListener(this, listener, EventType.CONTROL_DEACTIVATE, new EventHandler()
            {
                public void onHandle(EventObject eventObject)
                {
                    ControlDeactivateEvent e = new ControlDeactivateEvent(eventObject);
                    listener.onDeactivate(e);
                }
            });
    }

    public boolean isActive()
    {
        return ControlImpl.isActive(getJSObject());
    }

    /**
     * Enable the Control
     *
     */
    public void enable()
    {
        ControlImpl.enable(getJSObject());
    }

    /**
     * Disable Control
     *
     */
    public void disable()
    {
        ControlImpl.disable(getJSObject());
    }

    /**
     * Give the Control ID
     *
     * @return control id
     */
    public String getControlId()
    {
        return ControlImpl.getControlId(getJSObject());
    }

    /**
     * get the map to which this control is attached
     *
     * @return the map
     */
    public Map getMap()
    {
        return Map.narrowToMap(this.getJSObject().getProperty("map"));
    }


    public String getZIndex()
    {
        return ControlImpl.getZIndex(getJSObject());
    }

    /**
     *
     * @return
     *                      Vector on which features are drawn
     */
    public Vector getLayer()
    {
        return Vector.narrowToVector(ControlImpl.getLayer(getJSObject()));
    }

}
