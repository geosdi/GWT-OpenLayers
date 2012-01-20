package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * The WMSParams correspond with parameters that can be specified
 * in the WMS request.
 *
 * This differs from {@link WMSOptions}, which are options
 * that are set on the OL concept of a layer.
 * 
 * All WMS parameter names are case-insensitive, values are case sensitive
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 *
 * TODO: add support for time/elevation?
 */
public class WMSParams extends Params {

    protected WMSParams(JSObject jsObject) {
        super(jsObject);
    }

    public WMSParams() {
        this(JSObject.createJSObject());
    }

	public void setLayers(String layers) {
		getJSObject().setProperty("LAYERS", layers);
	}
	
	public String getLayers() {
		return getJSObject().getPropertyAsString("LAYERS");
	}

	public void setStyles(String styles) {
		getJSObject().setProperty("STYLES", styles);
	}
	
	public String getStyles() {
		return getJSObject().getPropertyAsString("STYLES");
	}

	public void setFormat(String styles) {
		getJSObject().setProperty("FORMAT", styles);
	}
	
	public String getFormat() {
		return getJSObject().getPropertyAsString("FORMAT");
	}

	public boolean isTransparent() { 
		return isTransparent(getJSObject());
	}
	
	public void setTransparent(boolean transparent) {
		getJSObject().setProperty("TRANSPARENT", transparent);
	}
	
	/**
	 * use {@link WMSParams#setTransparent} instead
	 * @param isTransparent
	 */
	@Deprecated
	public void setIsTransparent(boolean isTransparent){
		getJSObject().setProperty("TRANSPARENT", isTransparent);
	}
	
	public String getBgColor() { 
		return getJSObject().getPropertyAsString("BGCOLOR");
	}
	
	/**
	 * Hexadecimal red-green-blue colour value for the background color (default=0xFFFFFF).
	 * @param bgColor
	 */
	public void setBgColor(String bgColor) { 
		getJSObject().setProperty("BGCOLOR", bgColor);
	}
	
	/**
	 * Helper for transparency property of WMS 
	 * 
	 * @param layer
	 * @return
	 */
	public static native boolean isTransparent(JSObject params)/*-{
		if (typeof params.TRANSPARENT != "boolean") {
			return params.TRANSPARENT && params.TRANSPARENT.toString().toLowerCase() == "true";
		} else return params.TRANSPARENT;
	}-*/;
}
