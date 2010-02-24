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
}
