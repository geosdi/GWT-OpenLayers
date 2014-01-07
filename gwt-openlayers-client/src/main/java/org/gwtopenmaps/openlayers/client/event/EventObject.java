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

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * <p>Base class for event objects.</p>
 *
 * <b>Caveat: In Openlayers 2.x event handling is not yet implemented uniformly in OpenLayers. This should be fixed in version 3.x and higher.</b>
 * <p>
 * In OpenLayers, an event object is an argument that gets passed to the listener when it is called.
 * In GWT OpenLayers, this event object gets passed to the onHandle method of the EventHandler {@link EventHandler} when
 * the onHandle method is called. An event object class extending this base class can wrap this event object.
 * </p>
 * <p>
 * Depending on which event is fired, and from which source the event is fired
 * (e.g. Map, Layer, etc.), the event object may differ. Therefore, the
 * addXxxListener methods (see also {@link EventHandler}) that abstract from event registration details,
 * wrap the event object passed to onHandle in a way that is specific to the event.
 * </p>
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventObject extends JSObjectWrapper
{


    public static EventObject narrowToEventObject(JSObject object)
    {
        return (object != null) ? new EventObject(object) : null;
    }

    protected EventObject(JSObject eventObject)
    {
        super(eventObject);
    }

    /**
     *
     * @return Element as an opaque JSObject
     */
    public JSObject getElement()
    {
        return EventObjectImpl.getElement(getJSObject());
    }

    /**
     * Type is a string like "addlayer" or "move" denoting the type of event.
     *
     * @return A string denoting the type of event, or null if there is no type property.
     */
    public String getType()
    {
        String type = EventObjectImpl.getType(getJSObject());

        return type;
    }

    /**
     * @return JSObject - source object that fired the event
     */
    public JSObject getSourceJSObject()
    {
        JSObject object = EventObjectImpl.getObject(getJSObject());

        return object;
    }

}
