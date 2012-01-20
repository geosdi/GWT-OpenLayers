/**
 *
 */
package org.gwtopenmaps.openlayers.client.protocol;

/**
 * @author lorenzo
 *
 */
public class HTTPProtocolOptions extends ProtocolOptions
{

    /**
     * Property: url
     * {String} Service URL, read-only, set through the options
     *     passed to constructor.
     */
    public void setUrl(String url)
    {
        getJSObject().setProperty("url", url);
    }


    /**
     * Property: readWithPOST
     * {Boolean} true if read operations are done with POST requests
     *     instead of GET, defaults to false.
     */
    public void setReadWithPOST(boolean post)
    {
        getJSObject().setProperty("readWithPost", post);
    }

    /**
     * Property: wildcarded.
     * {Boolean} If true percent signs are added around values
     *     read from LIKE filters, for example if the protocol
     *     read method is passed a LIKE filter whose property
     *     is "foo" and whose value is "bar" the string
     *     "foo__ilike=%bar%" will be sent in the query string;
     *     defaults to false.
     */
    public void setWildcarded(boolean wildcarded)
    {
        getJSObject().setProperty("wildcarded", wildcarded);
    }


}
