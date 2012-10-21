package org.gwtopenmaps.openlayers.client.util;


import com.google.gwt.user.client.Element;


/**
 * Static methods for working with {@link JSObject} objects.
 * <p>
 * The getProperty/setProperty methods are convenience methods for reducing
 * the amount of JSNI code that is necessary for creating JSObject wrappers.
 * Be aware: getProperty methods can die horribly at runtime if
 * property does not exist.
 * </p>
 * ECMA-262 (Ecmascript = Javascript) defines an object as an unordered collection of
 * properties each of which contains a  primitive value, object, or function.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Alexander Solovets
 */
public class JSObjectHelper
{

    public static native JSObject createObject() /*-{
        return new $wnd.Object();
    }-*/;

    public static native JSObject createFunction() /*-{
        return new $wnd.Function();
    }-*/;

    public static native JSObject createArray() /*-{
        return new $wnd.Array();
    }-*/;

    // TODO: implement setProperty getProperty methods
    // and remove setAttribute methods from ElementHelper that actually set properies

    public static native void setProperty(JSObject object, String name, int value) /*-{
        object[name] = value;
    }-*/;

    public static native int getPropertyAsInt(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? 0 : ret;
    }-*/;

    public static native void setProperty(JSObject object, String name, String value) /*-{
        object[name] = value;
    }-*/;

    public static native String getPropertyAsString(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? null : ret;
    }-*/;

    public static native void setProperty(JSObject object, String name, boolean value) /*-{
        object[name] = value;
    }-*/;

    public static native boolean getPropertyAsBoolean(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? 0 : ret;
    }-*/;

    public static native void setProperty(JSObject object, String name, float value) /*-{
        object[name] = value;
    }-*/;

    public static native float getPropertyAsFloat(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? 0 : ret;
    }-*/;

    public static native void setProperty(JSObject object, String name, double value) /*-{
        object[name] = value;
    }-*/;

    public static native double getPropertyAsDouble(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? 0 : ret;
    }-*/;

    public static native void setProperty(JSObject object, String name, JSObject value) /*-{
        object[name] = value;
    }-*/;

    public static native JSObject getProperty(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? null : ret;
    }-*/;

    public static native void setProperty(JSObject object, String name, Element value) /*-{
        object[name] = value;
    }-*/;

    public static native Element getPropertyAsDomElement(JSObject object, String name) /*-{
        var ret = object[name];
        return (ret === undefined) ? null : ret;
    }-*/;

    public static native String getPropertyNames(JSObject object) /*-{
        var ret = "";
        for (var i in object){
        if(ret == ""){
        ret = ret + i
        } else {
        ret = ret + "," + i;
        }
        }
        return ret;
    }-*/;
    
    public static native String getPropertyValues(JSObject object) /*-{
        var ret = "";
        for (var k in object){
        if(ret == ""){
        ret = ret + object[k];
        } else {
        ret = ret + "," + object[k];
        }
        }
        return ret;
    }-*/;
    
    public static native boolean hasProperty(JSObject object, String name) /*-{
        if(object[name] != undefined){return true}else{return false};
    }-*/;

    /**
     * Unset/Clear the property with the given name. Uses the javascript operator delete
     * @param object The object in which the property exists
     * @param name The name of the property
     */
    public static native void unsetProperty(JSObject object, String name) /*-{
        delete object[name];
    }-*/;

    /**
     * Utility method for creating arguments to functions that take an array of objects.
     *
     * @param object - an opaque handle on a JavaScript object
     * @return object - an opaque handle on a JavaScript object that is surely an Array
     */
    public static native JSObject ensureOpaqueArray(JSObject object) /*-{
        //GWT breaks instanceof, so use a duck type test for testing if object is Array
        if(object.push && object.splice && object.unshift){
        return object;
        }else{
        return [object];
        }
    }-*/;

}
