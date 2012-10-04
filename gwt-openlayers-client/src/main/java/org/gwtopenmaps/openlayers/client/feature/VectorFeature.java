package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.MultiLineString;
import org.gwtopenmaps.openlayers.client.geometry.MultiPolygon;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.util.Attributes;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Lukas Johansson
 *
 * Class name deviates intentionally from OpenLayers class name. Both vector
 * layers and vector features are called Vector in OpenLayers.
 *
 *
 */
public class VectorFeature extends Feature {

    /**
     * {@link VectorFeature} States
     */
    public enum State {

        Unknown,
        Insert,
        Update,
        Delete;

        public static State fromString(String state) {
            if (state != null) {
                for (State s : State.values()) {
                    if (state.equalsIgnoreCase(s.toString())) {
                        return s;
                    }
                }
            }
            return State.Unknown;
        }
    }

    public static VectorFeature narrowToVectorFeature(JSObject vectorFeature) {
        return (vectorFeature == null) ? null : new VectorFeature(vectorFeature);
    }

    protected VectorFeature(JSObject vectorFeature) {
        super(vectorFeature);
    }

    public VectorFeature(Geometry g) {
        super(VectorFeatureImpl.create(g.getJSObject()));
    }

    public VectorFeature(Geometry g, Style s) {
        super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
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
     * Set the featureId on VectoreFeauture. Remember the featureId must be
     * unique
     *
     * @param feaureID
     */
    public void setFeatureId(String feaureID) {
        VectorFeatureImpl.setFeatureId(getJSObject(), feaureID);
    }

    /**
     * Set the attributes. This object (attributes) holds arbitrary properties
     * that describe the feature. <p> Note: the attributes are only applied for
     * styles defined inside a {@link StyleMap}. If just using a single style
     * for the {@link VectorOptions} the attributes will be ignored.
     *
     * @param vectorFeatureAttributes The attributes to set
     */
    public void setAttributes(Attributes attributes) {
        getJSObject().setProperty("attributes", attributes.getJSObject());
    }

    /**
     *
     * @return Attributes object
     */
    public Attributes getAttributes() {
        return Attributes.narrowToAttributes(getJSObject().getProperty(
                "attributes"));
    }

    @Deprecated
    public Attributes getAttributes(VectorFeature attributes) {
        return this.getAttributes();
    }

    public String getRenderIntent() {
        return VectorFeatureImpl.getRenderIntent(getJSObject());
    }

    public boolean redrawParent() {
        return VectorFeatureImpl.redraw(getLayer().getJSObject(), true);
    }

    /**
     * Determine whether the feature is displayed or not
     *
     */
    public boolean getVisibility() {
        return VectorFeatureImpl.getVisibility(getJSObject());
    }

    /**
     * Get the clustered features in this vector feature. If clustering isn't
     * used returns null.
     *
     * @return the clustered features or null if clustering isn't used
     */
    public VectorFeature[] getCluster() {
        JSObject jsObjects = VectorFeatureImpl.getCluster(getJSObject());
        JObjectArray jObjectArray = JObjectArray.narrowToJObjectArray(jsObjects);
        // Should be null if this is not a cluster
        if (jObjectArray == null) {
            return null;
        }
        VectorFeature[] features = new VectorFeature[jObjectArray.length()];
        for (int i = 0; i < jObjectArray.length(); i++) {
            features[i] = VectorFeature.narrowToVectorFeature(
                    jObjectArray.get(i));
        }
        return features;
    }

    /**
     * Create a clone of this vector feature. Does not set any non-standard
     * properties.
     */
    public VectorFeature clone() {
        return narrowToVectorFeature(VectorFeatureImpl.clone(getJSObject()));
    }

    /**
     * Convenient method to convert a LINESTRING VectorFeature to a
     * MULTILINE featureE. This method can be used of you are trying to save a
     * VectorFeature Line using WFS-T to geoserver and you are seeing a "Error
     * performing insert: java.lang.String cannot be cast to
     * com.vividsolutions.jts.geom.Geometry".
     *
     * @return true if converting succeeded (if this is not a LINESTRING)
     */
    public boolean convertLineStringToMultiLineString() {
        final Geometry g = this.getGeometry();

        if (g.getClassName().equals(
                org.gwtopenmaps.openlayers.client.geometry.Geometry.LINESTRING_CLASS_NAME)) {
            final LineString ls = LineString.narrowToLineString(g.getJSObject());
            final MultiLineString mls = new MultiLineString(new LineString[]{ls});
            this.getJSObject().setProperty("geometry", mls.getJSObject());

            return true;
        } else {
            return false;
        }
    }

    /**
     * Convenient method to convert a POLYGON VectorFeature to a
     * MULTIPOLYGON feature. This method can be used of you are trying to save a
     * VectorFeature Polygon using WFS-T to geoserver and you are seeing a "Error
     * performing insert: java.lang.String cannot be cast to
     * com.vividsolutions.jts.geom.Geometry".
     *
     * @return true if converting succeeded (if this is not a POLYGON)
     */
    public boolean convertPolygonToMultiPolygon() {
        final Geometry g = this.getGeometry();

        if (g.getClassName().equals(
                org.gwtopenmaps.openlayers.client.geometry.Geometry.POLYGON_CLASS_NAME)) {
            final Polygon p = Polygon.narrowToPolygon(g.getJSObject());
            final MultiPolygon mp = new MultiPolygon(new Polygon[]{p});
            this.getJSObject().setProperty("geometry", mp.getJSObject());

            return true;
        } else {
            return false;
        }
    }


    /**
     * Moves the feature and redraws it at its new location.
     *
     * @param lonLat the location to which to move the feature
     */
    public void move(LonLat lonLat) {
        VectorFeatureImpl.move(getJSObject(), lonLat.getJSObject());
    }

    /**
     * Sets the new state.
     *
     * @param state The new state
     */
    public void toState(State state) {
        VectorFeatureImpl.toState(getJSObject(), state.toString());
    }

    /**
     * Gets the state of the feature.
     *
     * @return The state of the feature.
     */
    public State getState() {
        return State.fromString(VectorFeatureImpl.getState(getJSObject()));
    }
}