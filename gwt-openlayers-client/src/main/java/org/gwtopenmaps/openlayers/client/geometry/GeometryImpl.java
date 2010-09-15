/**
 * 
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class GeometryImpl {
 
    public static native void destroy(JSObject self)/*-{
        self.destroy();
    }-*/;
    
	public static native JSObject getBounds(JSObject geom)/*-{
		return geom.getBounds();
    }-*/;

}
