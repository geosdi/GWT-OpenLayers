package org.gwtopenmaps.openlayers.client;

/**
 * Methods for interacting with the global OpenLayers object.
 *
 */
public class OpenLayers {

	/**
	 * @param proxyhost - the relative path to the proxyhost, including the
	 *   parameter that takes the url to forward the request to as value.
	 *
	 * For example: "GwtOpenlayersProxy?resourceUrl="
	 */
	public static native void setProxyHost(String proxyhost)/*-{
		$wnd.OpenLayers.ProxyHost = proxyhost;
	}-*/;

	/**
	 *
	 * @return the proxyhost that has been set, or null if no
	 *   proxyHost has been set
	 */
	public static native String getProxyHost()/*-{
		return ($wnd.OpenLayers.ProxyHost !== undefined)?$wnd.OpenLayers.ProxyHost:null;
	}-*/;

	/**
	 * Sets the IMAGE_RELOAD_ATTEMPTS property on the OpenLayers Object.
	 *
	 * @param attempts - the number of times OpenLayers will try to load an image that is requested over HTTP after the first attempt failed
	 */
	public static native void setImageReloadAttempts(int attempts)/*-{
		$wnd.OpenLayers.IMAGE_RELOAD_ATTEMPTS = attempts;
	}-*/;

	/**
	 * @return the number of times OpenLayers will try to load an image that is requested over HTTP after the first attempt failed -
	 *   by default this is 0 (that is, one try)
	 */
	public static native int getImageReloadAttempts()/*-{
		return $wnd.OpenLayers.IMAGE_RELOAD_ATTEMPTS;
	}-*/;
	
	
	/**
	 * 
	 * @return default 72
	 */
	public static native double getDotPerInch() /*-{
		return $wnd.OpenLayers.DOTS_PER_INCH;
	}-*/;
	
	/**
	 * @param value
	 */
	public static native void setDotPerInch(double value) /*-{
		$wnd.OpenLayers.DOTS_PER_INCH = value;
	}-*/;
	
	public static native double getInchesPerUnitMeter() /*-{
		return $wnd.OpenLayers.INCHES_PER_UNIT['m'];
	}-*/;

}
