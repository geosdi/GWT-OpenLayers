package org.gwtopenmaps.openlayers.client.util;


/**
 * Base class for Objects that wrap an opaque javascript object (represented by a JSObject),
 * to provide (part of) the javascript object's functionality in GWT.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class JSObjectWrapper
{

    private JSObject jsObject;

    protected JSObjectWrapper(JSObject jsObject)
    {
        setJSObject(jsObject);
    }

    public JSObject getJSObject()
    {
        return jsObject;
    }

    public void setJSObject(JSObject jsObject)
    {
        this.jsObject = jsObject;
    }

}
