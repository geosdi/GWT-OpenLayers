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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
class XMLImpl {

    public static native JSObject create() /*-{
     return new $wnd.OpenLayers.Format.XML();
     }-*/;

    public static native JSObject create(JSObject xmlOptions) /*-{
     return new $wnd.OpenLayers.Format.XML(xmlOptions);
     }-*/;

    public static native void setNamespace(JSObject xmlFormat, String alias,
            String uri) /*-{
     xmlFormat.setNamespace(alias, uri);
     }-*/;

    public static native Document read(JSObject xmlFormat, String input) /*-{
     return xmlFormat.read(input);
     }-*/;

    public static native <E extends Node> String write(JSObject xmlFormat, E el) /*-{
     return xmlFormat.write(el);
     }-*/;

    public static native NodeList getElementsByTagNameNS(JSObject xmlFormat,
            Element el, String uri, String name) /*-{
     return xmlFormat.getElementsByTagNameNS(el, uri, name);
     }-*/;

    public static native boolean hasAttributeNS(JSObject xmlFormat,
            Element el, String uri, String name) /*-{
     return xmlFormat.hasAttributeNS(el, uri, name);
     }-*/;

    public static native Element getAttributeNodeNS(JSObject xmlFormat,
            Element el, String uri, String name) /*-{
     return xmlFormat.getAttributeNodeNS(el, uri, name);
     }-*/;

    public static native String getAttributeNS(JSObject xmlFormat,
            Element el, String uri, String name) /*-{
     return xmlFormat.getAttributeNS(el, uri, name);
     }-*/;

    public static native Element createElementNS(JSObject xmlFormat,
            String uri, String name) /*-{
     return xmlFormat.createElementNS(uri, name);
     }-*/;

    public static native Element createTextNode(JSObject xmlFormat,
            String text) /*-{
     return xmlFormat.createTextNode(text);
     }-*/;
}
