package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.geometry.Geometry;

public class MeasureEvent extends ControlEvent {

	public MeasureEvent(EventObject eventObject) {
		super(eventObject.getJSObject());
	}

	public Geometry getGeometry(){
		return Geometry.narrowToGeometry(getJSObject().getProperty("geometry"));
	}

	public float getMeasure(){
		return getJSObject().getPropertyAsFloat("measure");
	}

	public int getOrder(){
		return getJSObject().getPropertyAsInt("order");
	}

	public String getUnits(){
		return getJSObject().getPropertyAsString("units");
	}
}