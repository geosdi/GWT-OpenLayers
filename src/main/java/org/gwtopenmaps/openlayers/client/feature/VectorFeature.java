package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.util.Attributes;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 *  Class name deviates intentionally from OpenLayers class name. Both
 *  vector layers and vector features are called Vector in OpenLayers.
 *
 *
 */
public class VectorFeature extends Feature {

	protected VectorFeature(JSObject vectorFeature) {
		super(vectorFeature);
	}

	public VectorFeature(Geometry g) {
		super(VectorFeatureImpl.create(g.getJSObject()));
	}

	public VectorFeature(Geometry g, Style s) {
		super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
	}

	public static VectorFeature narrowToVectorFeature(JSObject vectorFeature) {
		return (vectorFeature == null) ? null : new VectorFeature(vectorFeature);
	}

	/**
	 * Get vector feature geometry.
	 *
	 * Example:
	 * <code>
	 * VectorFeature vf = wkt.read("POINT (1 2)");
	 * Geometry g = vf.getGeometry();
	 * if(g.getClassName().equals(Geometry.POINT_CLASS_NAME){
	 *   Point p = Point.narrowToPoint(g.getJSObject());
	 * };
	 * </code>
	 */
	public Geometry getGeometry() {
		return Geometry.narrowToGeometry(getJSObject().getProperty("geometry"));
	}

	/**
	 * Set the attributes. This object (attributes) holds arbitrary properties
	 * that describe the feature.
	 * <p>
	 * Note: the attributes are only applied for styles defined inside a
	 * {@link StyleMap}. If just using a single style for the
	 * {@link VectorOptions} the attributes will be ignored.
	 *
	 * @param vectorFeatureAttributes
	 *            The attributes to set
	 */
	public void setAttributes(Attributes attributes) {
		getJSObject().setProperty("attributes", attributes.getJSObject());
	}

	/**
	 * 
	 * @return Attributes object
	 */
	public Attributes getAttributes(){
		return Attributes.narrowToAttributes(getJSObject().getProperty("attributes"));
	}
	
	@Deprecated
	public Attributes getAttributes(VectorFeature attributes){
		return this.getAttributes();
	}

}
