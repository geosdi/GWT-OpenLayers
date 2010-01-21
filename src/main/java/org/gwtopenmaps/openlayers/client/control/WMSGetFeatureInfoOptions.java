package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 *
 * @author Dave Potts
 *
 */
public class WMSGetFeatureInfoOptions extends JSObjectWrapper {

	protected WMSGetFeatureInfoOptions(JSObject jsObject) {
		super(jsObject);
	}

	public WMSGetFeatureInfoOptions(){
		this(JSObject.createJSObject());
	}

	public void setHover(boolean hover){
		getJSObject().setProperty("hover", hover);
	}

	public boolean getHover(){
		return getJSObject().getPropertyAsBoolean("hover");
	}

	public void setMaxFeaturess(int maxFeatures){
		getJSObject().setProperty("maxFeatures", maxFeatures);
	}

	public int getMaxFeatures(){
		return getJSObject().getPropertyAsInt("maxFeatures");
	}



}
