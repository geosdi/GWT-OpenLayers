package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Event extends OpenLayersWidget {

	protected Event(JSObject element) {
		super(element);
	}

	public static Event narrowToMap(JSObject element)
	{
		return (element == null)? null: new Event(element);
	}

}
