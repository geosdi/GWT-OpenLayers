package org.gwtopenmaps.openlayers.client.util;


class JStringArrayImpl
{

    public static native void arraySet(JSObject array, int index, String value) /*-{
        array[index] = value;
    }-*/;

    public static native String getAsString(JSObject array, int pos) /*-{
        if (array) return array[pos];
        return "";
    }-*/;

    public static native void push(JSObject array, String s) /*-{
        array.push(s);
    }-*/;
}
