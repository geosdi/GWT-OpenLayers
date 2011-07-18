package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class CollectionImpl {

    public native static int getNumberOfComponents(JSObject self)/*-{
        return self.components.length;
    }-*/;
    
    public native static JSObject getComponent(JSObject self, int index)/*-{
        return self.components[index];
    }-*/;

    public native static void transform(JSObject self, JSObject source, JSObject dest)/*-{
        self.transform(source, dest);
    }-*/;

    public native static boolean equals(JSObject self, JSObject geom)/*-{
        return self.equals(geom);
    }-*/;

    public native static double getLength(JSObject self)/*-{
	    return self.getLength();
    }-*/;
}
