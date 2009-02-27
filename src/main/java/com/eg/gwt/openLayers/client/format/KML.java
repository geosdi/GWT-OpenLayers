package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Brief explanation of Keyhole Markup Language (KML) vector format here.
 *
 * Reference to KML specification. KML 2.0 is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class KML extends VectorFormat {

	protected KML(JSObject kmlFormat){
		super(kmlFormat);
	}

	public KML(){
		this(KMLImpl.create());
	}

}
