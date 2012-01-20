package org.gwtopenmaps.openlayers.client.util;


import com.google.gwt.user.client.Element;


/**
 *
 */
public class ElementHelper
{

    /**
     * @return Element - the head element of the Document object of the topmost ancestor window
     */
    public static native Element getHead() /*-{
        return $wnd.top.document.getElementsByTagName("head")[0];
    }-*/;

    /**
     * @return Element - the Document object of the topmost ancestor window
     *
     */
    public static native Element getTopDocument() /*-{
        return $wnd.top.document;
    }-*/;

    public static native JSObject getElementsByTagName(Element parent, String tagName) /*-{
        return parent.getElementsByTagName(tagName);
    }-*/;
}
