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
