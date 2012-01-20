package org.gwtopenmaps.openlayers.client.util;


class JObjectArrayImpl
{

    public static native void arraySet(JSObject myArray, int index, JSObject value) /*-{
        myArray[index] = value;
    }-*/;

    public static native JSObject getAsJSObject(JSObject myArray, int pos) /*-{
        return myArray[pos];
    }-*/;

    public static native boolean isNumber(JSObject element) /*-{
        return typeof element  == 'number' && isFinite(element);
    }-*/;

    public static native boolean isNumber(JSObject array, int pos) /*-{
        return typeof array[pos] == 'number' && isFinite(array[pos]);
    }-*/;

    public static native JSObject getNumberAsJSObject(JSObject array, int index) /*-{
        return new $wnd.Number(array[index]);
    }-*/;

    public static native boolean isBoolean(JSObject element) /*-{
        return typeof element == 'boolean';
    }-*/;

    public static native boolean isBoolean(JSObject array, int pos) /*-{
        return typeof array[pos] == 'boolean';
    }-*/;

    public static native JSObject getBooleanAsJSObject(JSObject array, int index) /*-{
        return new $wnd.Boolean(array[index]);
    }-*/;

    public static native boolean isArray(JSObject element) /*-{
        return element && typeof element === 'object' && typeof element.length === 'number' &&
        !(element.propertyIsEnumerable('length'));
    }-*/;
}
