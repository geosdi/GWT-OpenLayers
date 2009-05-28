package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Event extends OpenLayersObjectWrapper {

	protected Event(JSObject element) {
		super(element);
	}

	public static Event narrowToMap(JSObject element)
	{
		return (element == null)? null: new Event(element);
	}

}
