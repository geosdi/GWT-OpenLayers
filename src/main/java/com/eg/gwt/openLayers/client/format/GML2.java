package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Brief explanation of Geographic Markup Language (GML) vector format here.
 *
 * Reference to GML specification. GML is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class GML2 extends VectorFormat {

	protected GML2(JSObject gmlFormat){
		super(gmlFormat);
	}

	public GML2(){
		this(GML2Impl.create());
	}

}
