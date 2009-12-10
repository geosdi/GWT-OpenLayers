package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class HTTPRequestLayerImpl {

	public static native JSObject create(String name, String url,
			JSObject params, JSObject options)/*-{
		return new $wnd.OpenLayers.Layer.HTTPRequest(name, url, params,options);
	}-*/;
	public static native JSObject create(String name, String url,
			JSObject params)/*-{
		return new $wnd.OpenLayers.Layer.HTTPRequest(name, url, params);
	}-*/;
	public static native JSObject create(String name, JSObject urls,
			JSObject params)/*-{
	    var wmsURLs = new $wnd.Array(urls.length);
		for (i = 0; i < urls.length; i++) {
		  wmsURLs[i] = urls[i];
		}

		return new $wnd.OpenLayers.Layer.HTTPRequest(name, wmsURLs, params);
	   }-*/;

	public static native JSObject create(String name, JSObject urls,
			JSObject params, JSObject layerParams)/*-{
		var wmsURLs = new $wnd.Array(urls.length);
		for (i = 0; i < urls.length; i++) {
		  wmsURLs[i] = urls[i];
		}

		return new $wnd.OpenLayers.Layer.HTTPRequest(name, wmsURLs, params, layerParams);
	}-*/;
	public static native void destroy(JSObject HTTPRequest)/*-{
	    HTTPRequest.destroy();
	}-*/;
	public static native JSObject Clone(JSObject HTTPRequest, JSObject obj)/*-{
	    return HTTPRequest.clone(obj);
    }-*/;
    public static native void setURL(JSObject HTTPRequest, String newUrl)/*-{
        HTTPRequest.setUrl(newUrl);
    }-*/;
    public static native void mergeNewParams(JSObject HTTPRequest, JSObject params)/*-{
	    HTTPRequest.mergeNewParams(params);
    }-*/;
    public static native String selectUrl(JSObject HTTPRequest ,String paramString, String urls)/*-{
        return HTTPRequest.selectUrl(paramString, urls); 
    }-*/;
    
    public static native String getFullRequestString( JSObject HTTPRequest, JSObject newParams, String altUrl)/*-{
        return HTTPRequest.getFullRequestString(newParams,altUrl);
    }-*/;
}
