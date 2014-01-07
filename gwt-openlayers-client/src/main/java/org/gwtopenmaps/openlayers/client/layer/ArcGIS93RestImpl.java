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


/**
* @author Michel Vitor A Rodrigues
*/
public class ArcGIS93RestImpl
{

    public static native JSObject create(String name, String url, JSObject params, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.ArcGIS93Rest(name, url, params,options);
    }-*/;

    public static native JSObject create(String name, String url, JSObject params) /*-{
        return new $wnd.OpenLayers.Layer.ArcGIS93Rest(name, url, params);
    }-*/;

    public static native JSObject create(String name, JSObject urls,
        JSObject params) /*-{
        var wmsURLs = new $wnd.Array(urls.length);
        for (i = 0; i < urls.length; i++) {
        wmsURLs[i] = urls[i];
        }
        
        return new $wnd.OpenLayers.Layer.ArcGIS93Rest(name, wmsURLs, params);
    }-*/;

    public static native JSObject create(String name, JSObject urls,
        JSObject params, JSObject layerParams) /*-{
        var wmsURLs = new $wnd.Array(urls.length);
        for (i = 0; i < urls.length; i++) {
        wmsURLs[i] = urls[i];
        }
        
        return new $wnd.OpenLayers.Layer.ArcGIS93Rest(name, wmsURLs, params, layerParams);
    }-*/;

    public static native void setIsBaseLayer(JSObject self, boolean isBaseLayer) /*-{
        self.isBaseLayer = isBaseLayer;
    }-*/;

    public static native void destroy(JSObject arcGIS93Rest) /*-{
        arcGIS93Rest.destroy();
    }-*/;

    public static native JSObject clone(JSObject arcGIS93Rest, JSObject obj) /*-{
        return arcGIS93Rest.clone(obj);
    }-*/;

    public static native String getURL(JSObject arcGIS93Rest, JSObject bounds) /*-{
        return arcGIS93Rest.getURL(bounds);
    }-*/;

    public static native void setLayerFilter(JSObject arcGIS93Rest, String id, String queryDef) /*-{
        arcGIS93Rest.setLayerFilter(id, queryDef);
    }-*/;

    public static native void clearLayerFilter(JSObject arcGIS93Rest, String id) /*-{
        arcGIS93Rest.clearLayerFilter(id);
    }-*/;

    public static native boolean mergeNewParams(JSObject arcGIS93Rest, JSObject params) /*-{
        return arcGIS93Rest.mergeNewParams(params);
    }-*/;

    public static native void addTile(JSObject arcGIS93Rest, JSObject bounds, JSObject position) /*-{
        arcGIS93Rest.addTile(bounds,position);
    }-*/;

    public static native int getNumLoadingTiles(JSObject layer) /*-{
        return layer.numLoadingTiles;
    }-*/;
}
