package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin commandeur - Atlis EJS
 * @author Rafael Cer�volo
 *
 * Convenience class exposing options that are valid for a vector layer.
 * There's also a Vector constructor that can take an Options object directly.
 *
 */
public class VectorOptions extends LayerOptions {

	public VectorOptions(){
	}

	public void setIsBaseLayer(boolean b){
		getJSObject().setProperty("isBaseLayer", b);
	}

	public boolean getIsBaseLayer(){
		return getJSObject().getPropertyAsBoolean("isBaseLayer");
	}

	//limit geometry type to a specific geometry type
	public void setGeometryType(String gtype){
		getJSObject().setProperty("geometryType", gtype);
	}

	public String getGeometryType(){
		return getJSObject().getPropertyAsString("geometryType");
	}

	public void setStyle(Style style){
		getJSObject().setProperty("style", style.getJSObject());
	}

	public JSObject getStyle(Style style){
		return getJSObject().getProperty("style");
	}
	
	public void setRendererOptions(RendererOptions rendererOptions){
		getJSObject().setProperty("rendererOptions", rendererOptions.getJSObject());
    }

    public JSObject getRendererOptions(){
    	return getJSObject().getProperty("rendererOptions");
    }
}
