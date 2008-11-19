package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.layer.Layer;

/**
 * <p>Base class for event objects.</p>
 *  
 * <b>Caveat: Currently, events are not yet used uniformly in OpenLayers. This is on the OpenLayers roadmap for version 3.x.</b>
 * <p>
 * In OpenLayers, a listener may be passed a reference to an event object. 
 * In GWT OpenLayers, the {@link EventHandler} interface enables registering listeners  
 * and the event object argument gets passed to the onHandle method of the EventHandler.
 * </p>
 * <p>
 * Depending on which event is fired, and from which source the event is fired 
 * (e.g. Map, Layer, etc.), the event object may differ. Therefore, the 
 * higher-level way to register events (see also {@link EventHandler))
 * passes an event object to the listener method that is specific to the event. 
 * </p>
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventObject {

    private JSObject eventObject;
    
    public EventObject(JSObject eventObject){
        this.eventObject = eventObject;
    }

    /**
     * 
     * @return Element as an opaque JSObject
     */
    public JSObject getElement(){
        return EventObjectImpl.getElement(getJSObject());
    }

    
    /**
     * Type is a string like "addlayer" or "move" denoting the type of event.
     * 
     * @return A string denoting the type of event, or null if there is no type property. 
     */
    public String getType(){
        String type = EventObjectImpl.getType(getJSObject());
        return (type.equals("undefined"))?null:type;
    }
    
    //TODO move this javadoc?
    /**
     * Events fired by the Map like "addlayer", "removelayer", etc. 
     * return the layer as property of the event object.
     * 
     * @return Layer effected by the event, or null if there is no layer property
     */
    protected Layer getLayer(){
        JSObject layer = EventObjectImpl.getLayer(getJSObject());
        return Layer.narrowToLayer(layer);
    }

    public JSObject getJSObject(){
        return this.eventObject;
    }
}
