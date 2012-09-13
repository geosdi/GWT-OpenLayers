package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Lorenzo Amato <lorenzo.amato@geosdi.org>
 * 
 */

public class TransformFeature extends Control {

	protected TransformFeature(JSObject tranformFeature) {
		super(tranformFeature);
	}

	public TransformFeature(Vector vectorLayer) {
		this(TransformFeatureImpl.create(vectorLayer.getJSObject()));
	}

	public TransformFeature(Vector vectorLayer,
			TransformFeatureOptions transformFeatureOptions) {
		this(TransformFeatureImpl.create(vectorLayer.getJSObject(),
				transformFeatureOptions.getJSObject()));
	}
	
        
       
        
        
//	public void setFeature (VectorFeature feature){
//        TransformFeatureImpl.setFeature(this.getJSObject(), feature.getJSObject());
//        }
}
