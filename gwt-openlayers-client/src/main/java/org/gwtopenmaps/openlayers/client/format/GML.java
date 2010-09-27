package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * GML parser and writer, supports simple features profile ONLY.
 * Wraps OpenLayers.Format.GML
 * 
 * @author Mikael Couzic
 */
public class GML extends VectorFormat {

	protected GML(JSObject gmlFormat){
		super(gmlFormat);
	}

	public GML(){
		this(GMLImpl.create());
	}

}