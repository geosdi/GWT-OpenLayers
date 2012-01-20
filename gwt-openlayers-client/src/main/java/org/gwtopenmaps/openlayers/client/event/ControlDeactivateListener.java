package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlDeactivateListener extends EventListener
{

    void onDeactivate(ControlDeactivateEvent eventObject);

    class ControlDeactivateEvent extends ControlEvent
    {
        public ControlDeactivateEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }
    }
}
