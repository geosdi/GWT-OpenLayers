package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;


/**
* Wrapper of OpenLayers.Layer.HTTPRequest in OpenLayers. Renamed HTTPREquest
* to HTTPRequestLayer so it is not confused with HTTPRequest in GWT.
*
* HTTPRequest in GWT provides functionality to make basic HTTP requests.
*
* HTTPRequestLayer in GWT-OL supports ...
*
* From OL API docs:
*
*
* @author Edwin Commandeur - Atlis EJS
* @author Michel Vitor A Rodrigues - Intec
*
*/
public class HTTPRequestLayer extends Layer
{

    protected HTTPRequestLayer(JSObject httpRequestLayer)
    {
        super(httpRequestLayer);
    }

    /**
     * Constructor: HTTPRequestLayer
     *
     * Parameters:
     * name    - {String}
     * url     - {String}
     * params  - {WMSParams}
     * options - {HTTPRequestLayerOptions} Hashtable of extra options to tag onto the layer
     */
    public HTTPRequestLayer(String name, String url, WMSParams params, HTTPRequestLayerOptions options)
    {
        this(HTTPRequestLayerImpl.create(name, url, params.getJSObject(), options.getJSObject()));
    }

    /**
     * Constructor: HTTPRequestLayer
     *
     * Parameters:
     * name    - {String}
     * url     - {String}
     * params  - {WMSParams}
     *
     */
    public HTTPRequestLayer(String name, String url, WMSParams params)
    {
        this(HTTPRequestLayerImpl.create(name, url, params.getJSObject()));
    }

    /**
     * Constructor: HTTPRequestLayer
     *
     * Parameters:
     * name    - {String}
     * url     - {Array (String)}
     * params  - {WMSParams}
     * options - {HTTPRequestLayerOptions} Hashtable of extra options to tag onto the layer
     */
    public HTTPRequestLayer(String name, String[] urls, WMSParams params, HTTPRequestLayerOptions options)
    {
        this(HTTPRequestLayerImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject(), options.getJSObject()));
    }

    /**
     * Constructor: HTTPRequestLayer
     *
     * Parameters:
     * name    - {String}
     * url     - {Array (String)}
     * params  - {WMSParams}
     *
     */
    public HTTPRequestLayer(String name, String[] urls, WMSParams params)
    {
        this(HTTPRequestLayerImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject()));
    }

    public HTTPRequestLayer narrowToHTTPRequestLayer(JSObject httpRequestLayer)
    {
        return (httpRequestLayer == null) ? null : new HTTPRequestLayer(httpRequestLayer);
    }

    /**
     * APIMethod: destroy
     */
    public void destroy()
    {
        HTTPRequestLayerImpl.destroy(getJSObject());
    }

    /**
     * APIMethod: clone
     *
     * Parameters:
     * obj - {HTTPRequest}
     *
     * Returns:
     * {HTTPRequest} An exact clone of this HTTPRequest
     */
    public HTTPRequestLayer clone(HTTPRequestLayer obj)
    {
        return new HTTPRequestLayer(HTTPRequestLayerImpl.Clone(getJSObject(), obj.getJSObject()));
    }

    /**
     * APIMethod: setUrl
     *
     * Parameters:
     * newUrl - {String}
     */
    public void setUrl(String newUrl)
    {
        HTTPRequestLayerImpl.setURL(getJSObject(), newUrl);
    }

    /**
     * APIMethod: mergeNewParams
     *
     * Parameters:
     * newParams - {Object}
     *
     * Returns:
     * redrawn: {Boolean} whether the layer was actually redrawn.
     */
    public boolean mergeNewParams(Params params)
    {
        return HTTPRequestLayerImpl.mergeNewParams(getJSObject(), params.getJSObject());
    }

    /**
     * @param force - if true force redraw by adding random parameter to getMap request
     *
     * If force is false or null no random parameters are added, in that case
     * the browser may cache the getMap request, thus not redrawing the map
     *
     */
    public boolean redraw(boolean force)
    {
        return LayerImpl.redraw(getJSObject(), force);
    }

    /**
     * Method: selectUrl
     * selectUrl() implements the standard floating-point multiplicative
     *     hash function described by Knuth, and hashes the contents of the
     *     given param string into a float between 0 and 1. This float is then
     *     scaled to the size of the provided urls array, and used to select
     *     a URL.
     *
     * Parameters:
     * paramString - {String}
     * urls - {String}
     *
     * Returns:
     * {String} An entry from the urls array, deterministically selected based
     *          on the paramString.
     */
    public String selectUrl(String paramString, String url)
    {
        return HTTPRequestLayerImpl.selectUrl(getJSObject(), paramString, url);
    }

//    /**
//     * Method: selectUrl
//     * selectUrl() implements the standard floating-point multiplicative
//     *     hash function described by Knuth, and hashes the contents of the
//     *     given param string into a float between 0 and 1. This float is then
//     *     scaled to the size of the provided urls array, and used to select
//     *     a URL.
//     *
//     * Parameters:
//     * paramString - {String}
//     * urls - {String}
//     *
//     * Returns:
//     * {String} An entry from the urls array, deterministically selected based
//     *          on the paramString.
//     */
//    public String[] SelectUrl(String paramString, String[] urls){
//      String[] objaltUrl = HTTPRequestLayerImpl.selectUrl(getJSObject(), paramString, new JStringArray(urls).getJSObject());
//      String[] SelectUrl = new String[objaltUrl.length];
//              for(int i = 0; i < objaltUrl.length; i++) {
//                      SelectUrl[i] = objaltUrl[i];
//              }
//              return SelectUrl;
//    }

    /**
     * Method: getFullRequestString
     * Combine url with layer's params and these newParams.
     *
     *    does checking on the serverPath variable, allowing for cases when it
     *     is supplied with trailing ? or &, as well as cases where not.
     *
     *    return in formatted string like this:
     *        "server?key1=value1&key2=value2&key3=value3"
     *
     * WARNING: The altUrl parameter is deprecated and will be removed in 3.0.
     *
     * Parameters:
     * newParams - {WMSParams}
     * altUrl - {String} Use this as the url instead of the layer's url
     *
     * Returns:
     * {String}
     */
    public String getFullRequestString(WMSParams newParams, String altUrl)
    {
        return HTTPRequestLayerImpl.getFullRequestString(getJSObject(), newParams.getJSObject(), altUrl);
    }

}
