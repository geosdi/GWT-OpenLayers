package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.event.Events;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;

/**
 * Wrapper object for OpenLayer objects.
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 */
public class OpenLayersObjectWrapper extends JSObjectWrapper {

	protected OpenLayersObjectWrapper(JSObject openLayersObject)
	{
		super(openLayersObject);
	}

	public static OpenLayersObjectWrapper narrowToOpenLayersObjectWrapper(JSObject element)
	{
		return (element == null)?null: new OpenLayersObjectWrapper(element);
	}

	/**
	 *
	 * @return Events - see {@link com.eg.gwt.openLayers.client.event.Events},
	 *  	null if the object does not fire events via event system.
	 */
	public Events getEvents() {
		return Events.narrowToEvents(OpenLayersObjectWrapperImpl.getEvents(getJSObject()));
	}

	/**
	 * Each OpenLayers object has a CLASS_NAME property.
	 *
	 * @return String - fully qualified OpenLayers class name
	 */
	public String getClassName(){
		return OpenLayersObjectWrapperImpl.getClassName(getJSObject());
	}
}
