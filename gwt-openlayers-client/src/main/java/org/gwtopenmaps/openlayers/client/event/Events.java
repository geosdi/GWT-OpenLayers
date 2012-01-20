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
