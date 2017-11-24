/**
 *
 *   Copyright 2015 sourceforge.
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
package org.gwtopenmaps.openlayers.client.format;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class XML<E extends Node> extends Format<E, String> {

    protected XML(JSObject format) {
        super(format);
    }

    public XML() {
        this(XMLImpl.create());
    }

    public XML(XMLOptions xmlOptions) {
        this(XMLImpl.create(xmlOptions.getJSObject()));
    }

    /**
     * Method: setNamespace Set a namespace alias and URI for the format.
     *
     * Parameters: alias - {@link String} The namespace alias (prefix). uri -
     * {String} The namespace URI.
     *
     * @param alias
     * @param uri
     */
    public void setNamespace(String alias, String uri) {
        XMLImpl.setNamespace(getJSObject(), alias, uri);
    }

    /**
     * APIMethod: read Deserialize a XML string and return a DOM node.
     *
     * Parameters: text - {@link String} A XML string
     *
     * Returns: {@link Element} A DOM node
     *
     * @param text
     * @return
     */
    @Override
    public E read(String text) {
        return (E) XMLImpl.read(getJSObject(), text);
    }

    /**
     * APIMethod: write Serialize a DOM node into a XML string.
     *
     * Parameters: node - {DOMElement} A DOM node.
     *
     * Returns: {String} The XML string representation of the input node.
     *
     * @param el
     *
     * @return String
     */
    public String write(E el) {
        return XMLImpl.write(getJSObject(), el);
    }

    /**
     * APIMethod: getElementsByTagNameNS Get a list of elements on a node given
     * the namespace URI and local name. To return all nodes in a given
     * namespace, use '*' for the name argument. To return all nodes of a given
     * (local) name, regardless of namespace, use '*' for the uri argument.
     *
     * Parameters: node - {Element} Node on which to search for other nodes. uri
     * - {String} Namespace URI. name - {String} Local name of the tag (without
     * the prefix).
     *
     * Returns: {NodeList} A node list or array of elements.
     *
     * @param <T>
     * @param el
     * @param uri
     * @param name
     * @return {@link NodeList<T>} nodeList
     */
    public <T extends Node> NodeList<T> getElementsByTagNameNS(Element el,
            String uri, String name) {
        return XMLImpl.getElementsByTagNameNS(getJSObject(), el, uri, name);
    }

    /**
     * APIMethod: hasAttributeNS Determine whether a node has a particular
     * attribute matching the given name and namespace.
     *
     * Parameters: node - {Element} Node on which to search for an attribute.
     * uri - {String} Namespace URI. name - {String} Local name of the attribute
     * (without the prefix).
     *
     * Returns: {Boolean} The node has an attribute matching the name and
     * namespace.
     *
     * @param el
     * @param uri
     * @param name
     * @return {@link Boolean} value
     */
    public boolean hasAttributeNS(Element el, String uri, String name) {
        return XMLImpl.hasAttributeNS(getJSObject(), el, uri, name);
    }

    /**
     * APIMethod: getAttributeNodeNS Get an attribute node given the namespace
     * URI and local name.
     *
     * Parameters: node - {Element} Node on which to search for attribute nodes.
     * uri - {String} Namespace URI. name - {String} Local name of the attribute
     * (without the prefix).
     *
     * Returns: {DOMElement} An attribute node or null if none found.
     *
     * @param el
     * @param uri
     * @param name
     * @return {@link Node} value
     */
    public Element getAttributeNodeNS(Element el, String uri, String name) {
        return XMLImpl.getAttributeNodeNS(getJSObject(), el, uri, name);
    }

    /**
     * APIMethod: getAttributeNS Get an attribute value given the namespace URI
     * and local name.
     *
     * Parameters: node - {Element} Node on which to search for an attribute.
     * uri - {String} Namespace URI. name - {String} Local name of the attribute
     * (without the prefix).
     *
     * Returns: {String} An attribute value or and empty string if none found.
     *
     * @param el
     * @param uri
     * @param name
     *
     * @return {@link String} node value
     */
    public String getAttributeNS(Element el, String uri, String name) {
        return XMLImpl.getAttributeNS(getJSObject(), el, uri, name);
    }

    /**
     * APIMethod: createElementNS Create a new element with namespace. This node
     * can be appended to another node with the standard node.appendChild
     * method. For cross-browser support, this method must be used instead of
     * document.createElementNS.
     *
     * Parameters: uri - {String} Namespace URI for the element. name - {String}
     * The qualified name of the element (prefix:localname).
     *
     * Returns: {Element} A DOM element with namespace.
     *
     * @param uri
     * @param name
     *
     * @return {@link Element} element
     */
    public Element createElementNS(String uri, String name) {
        return XMLImpl.createElementNS(getJSObject(), uri, name);
    }

    /**
     * APIMethod: createTextNode Create a text node. This node can be appended
     * to another node with the standard node.appendChild method. For
     * cross-browser support, this method must be used instead of
     * document.createTextNode.
     *
     * Parameters: text - {String} The text of the node.
     *
     * Returns: {DOMElement} A DOM text node.
     *
     * @param text
     *
     * @return {@link Element} element
     */
    public Element createTextNode(String text) {
        return XMLImpl.createTextNode(getJSObject(), text);
    }
}
