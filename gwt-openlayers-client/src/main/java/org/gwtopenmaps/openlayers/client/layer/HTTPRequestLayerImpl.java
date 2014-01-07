/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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

	public static native boolean mergeNewParams(JSObject HTTPRequest, JSObject params)/*-{
		return HTTPRequest.mergeNewParams(params);
	}-*/;

	public static native String selectUrl(JSObject HTTPRequest ,String paramString, String url)/*-{
		return HTTPRequest.selectUrl(paramString, url);
	}-*/;

	public static native String getFullRequestString( JSObject HTTPRequest, JSObject newParams, String altUrl)/*-{
		return HTTPRequest.getFullRequestString(newParams,altUrl);
	}-*/;
	
	public static native JSObject getParams(JSObject HTTPRequest)/*-{
		if( HTTPRequest.params ) 		
			return HTTPRequest.params;
		else return {};
	}-*/;
}
