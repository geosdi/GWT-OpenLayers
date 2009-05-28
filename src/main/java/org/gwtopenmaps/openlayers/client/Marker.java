package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * 
 * @author Erdem Gunay
 *
 */
public class Marker extends OpenLayersObjectWrapper {

	protected Marker(JSObject element) {
		super(element);
	}

	public static Marker narrowToMarker(JSObject element)
	{
		return (element == null)? null: new Marker(element);
	}

	public Marker(LonLat lonlat) {
		this (MarkerImpl.create(lonlat.getJSObject()));
	}
	
	public Marker(LonLat lonlat, Icon icon) {
		this (MarkerImpl.create(lonlat.getJSObject(), icon.getJSObject()));
	}
	
	public LonLat getLonLat() {
		return LonLat.narrowToLonLat(MarkerImpl.getLonLat(getJSObject()));
	}

	public Icon getIcon() {
		return Icon.narrowToIcon(MarkerImpl.getIcon(getJSObject()));
	}
}
