package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * GetFeature implementation that gets Vector Features use WFS
 * 
 * @author davek<at>komacke<dot>com
 *
 */

public class GetFeature extends Control {

	protected GetFeature(JSObject element){
		super(element);
	}

	public GetFeature(){
		this(GetFeatureImpl.create());
	}

	public GetFeature(GetFeatureOptions options){
		this(GetFeatureImpl.create(options.getJSObject()));
	}
	
	public void setSelectVectorFeature(VectorFeature feature) {
		getJSObject().setProperty("select", feature.getJSObject());
	}

	public static GetFeature narrowToGetFeature(JSObject getFeature) {
		return (getFeature == null) ? null : new GetFeature(getFeature);
	}

}
