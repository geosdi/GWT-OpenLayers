package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class CollectionImpl
{

    public static native int getNumberOfComponents(JSObject self) /*-{
        return self.components.length;
    }-*/;

    public static native JSObject getComponent(JSObject self, int index) /*-{
        return self.components[index];
    }-*/;

    public static native void transform(JSObject self, JSObject source, JSObject dest) /*-{
        self.transform(source, dest);
    }-*/;

    public static native boolean equals(JSObject self, JSObject geom) /*-{
        return self.equals(geom);
    }-*/;

    public static native double getLength(JSObject self) /*-{
        return self.getLength();
    }-*/;
}
