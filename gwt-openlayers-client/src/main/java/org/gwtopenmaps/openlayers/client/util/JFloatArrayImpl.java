package org.gwtopenmaps.openlayers.client.util;


public class JFloatArrayImpl
{

    public static native float get(JSObject array, int index) /*-{
        return array[index];
    }-*/;

    public static native float getAsFloat(JSObject array, int pos) /*-{
        if (array) return array[pos];
    }-*/;

    public static native void push(JSObject array, float f) /*-{
        array.push(f);
    }-*/;
}
