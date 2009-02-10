package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.util.JSObject;

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
