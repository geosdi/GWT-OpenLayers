package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;

public class OSM extends Layer {

	protected OSM(JSObject element) {
		super(element);
	}
	
	public static OSM Mapnik (String name){
		return new OSM(OSMImpl.Mapnik(name));
	}
	
	public static OSM Mapnik (String name, OSMParams params){
		return new OSM(OSMImpl.Mapnik(name, params.getJSObject()));
	}
	
	public static OSM Osmarender (String name){
		return new OSM(OSMImpl.Osmarender(name));
	}
	
	public static OSM Osmarender (String name, OSMParams params){
		return new OSM(OSMImpl.Osmarender(name, params.getJSObject()));
	}
	
	public static OSM CycleMap (String name){
		return new OSM(OSMImpl.CycleMap(name));
	}
	
	public static OSM CycleMap (String name, OSMParams params){
		return new OSM(OSMImpl.CycleMap(name, params.getJSObject()));
	}
	
	public static OSM Maplint (String name){
		return new OSM(OSMImpl.Maplint(name));
	}
	
	public static OSM Maplint (String name, OSMParams params){
		return new OSM(OSMImpl.Maplint(name, params.getJSObject()));
	}
	

}
