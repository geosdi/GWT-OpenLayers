package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
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
 */
public class WMSParams extends Params {

	protected WMSParams(JSObject jsObject) {
		super(jsObject);
	}

	public WMSParams(){
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
		String transparent = getJSObject().getPropertyAsString("TRANSPARENT");
		return transparent != null && "TRUE".equalsIgnoreCase(transparent);
	}
	
	/**
	 * Set transparent parameter in WMS request. Default is false.
	 *
	 * Within this method the value of the parameter will be set in uppercase,
	 * since at least IONIC's WMS requires it to be in uppercase, in
	 * accordance with the WMS Specification
	 *
	 * The WMS 1.1.1 spec states:
	 *  "TRANSPARENT can take on two values, "TRUE" or "FALSE"."
	 *  and
	 *  "Parameter names shall not be case sensitive,
	 *  but parameter values shall be case sensitive."
	 *
	 */
	public void setIsTransparent(boolean isTransparent){
		if(isTransparent){
			getJSObject().setProperty("TRANSPARENT", "TRUE");
		} else {
			getJSObject().setProperty("TRANSPARENT", "FALSE");
		}
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
	
	//TODO: add support for time/elevation?
}
