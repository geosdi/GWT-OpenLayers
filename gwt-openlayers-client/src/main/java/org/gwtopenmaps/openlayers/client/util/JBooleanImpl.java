package org.gwtopenmaps.openlayers.client.util;


class JBooleanImpl
{
    public static native boolean isBoolean(JSObject element) /*-{
        return element instanceof $wnd.Boolean;
    }-*/;

    public static native JSObject create(boolean num) /*-{
        return new $wnd.Boolean(num);
    }-*/;

    public static native boolean toBoolean(JSObject element) /*-{
        return element.valueOf();
    }-*/;
}
