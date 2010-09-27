package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class Geometry extends OpenLayersObjectWrapper {

	public final static String LINEARRING_CLASS_NAME = "OpenLayers.Geometry.LinearRing";
	public final static String LINESTRING_CLASS_NAME = "OpenLayers.Geometry.LineString";
	public final static String POINT_CLASS_NAME = "OpenLayers.Geometry.Point";
	public final static String POLYGON_CLASS_NAME = "OpenLayers.Geometry.Polygon";
	//TODO more class names

	protected Geometry(JSObject element){
		super(element);
	}

	public static Geometry narrowToGeometry(JSObject element) {
		return (element == null) ? null : new Geometry(element);
	}

	public void destroy(){
		GeometryImpl.destroy(getJSObject());
	}

	public Bounds getBounds() {
		return Bounds.narrowToBounds(GeometryImpl.getBounds(this.getJSObject()));
	}

}
