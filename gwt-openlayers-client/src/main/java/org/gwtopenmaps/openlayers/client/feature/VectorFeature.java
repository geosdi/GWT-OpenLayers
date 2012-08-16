package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.util.Attributes;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Lukas Johansson
 *
 *  Class name deviates intentionally from OpenLayers class name. Both
 *  vector layers and vector features are called Vector in OpenLayers.
 *
 *
 */
public class VectorFeature extends Feature
{

    public static VectorFeature narrowToVectorFeature(JSObject vectorFeature)
    {
        return (vectorFeature == null) ? null : new VectorFeature(vectorFeature);
    }

    protected VectorFeature(JSObject vectorFeature)
    {
        super(vectorFeature);
    }

    public VectorFeature(Geometry g)
    {
        super(VectorFeatureImpl.create(g.getJSObject()));
    }

    public VectorFeature(Geometry g, Style s)
    {
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
    public Geometry getGeometry()
    {
        return Geometry.narrowToGeometry(getJSObject().getProperty("geometry"));
    }

    /**
     * Set the featureId on VectoreFeauture. Remember the featureId must be
     * unique
     *
     * @param feaureID
     */
    public void setFeatureId(String feaureID)
    {
        VectorFeatureImpl.setFeatureId(getJSObject(), feaureID);
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
    public void setAttributes(Attributes attributes)
    {
        getJSObject().setProperty("attributes", attributes.getJSObject());
    }

    /**
     *
     * @return Attributes object
     */
    public Attributes getAttributes()
    {
        return Attributes.narrowToAttributes(getJSObject().getProperty("attributes"));
    }

    @Deprecated
    public Attributes getAttributes(VectorFeature attributes)
    {
        return this.getAttributes();
    }

    public String getRenderIntent()
    {
        return VectorFeatureImpl.getRenderIntent(getJSObject());
    }

    public boolean redrawParent()
    {
        return VectorFeatureImpl.redraw(getLayer(), true);
    }

    /**
     * Determine whether the feature is displayed or not
     *
     */
    public boolean getVisibility()
    {
        return VectorFeatureImpl.getVisibility(getJSObject());
    }
    
    public VectorFeature[] getCluster()
    {
        JSObject jsObjects = VectorFeatureImpl.getCluster(getJSObject());
        JObjectArray jObjectArray = JObjectArray.narrowToJObjectArray(jsObjects);
        VectorFeature[] features = new VectorFeature[jObjectArray.length()];
        for (int i = 0; i < jObjectArray.length(); i++) {
            features[i] = VectorFeature.narrowToVectorFeature(jObjectArray.get(i));
        }
        return features;
    }

    /**
     * Create a clone of this vector feature. Does not set any non-standard
     * properties.
     */
    public VectorFeature clone()
    {
        return narrowToVectorFeature(VectorFeatureImpl.clone(getJSObject()));
    }

}
