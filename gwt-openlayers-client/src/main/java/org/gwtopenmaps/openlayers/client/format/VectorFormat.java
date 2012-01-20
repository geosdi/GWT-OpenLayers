package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Format objects provide support for reading and writing formats for
 * representing vector features (or their geometries).
 *
 * There are different standard formats for representing vector features.
 * For example, WKT GML, and KML.
 *
 * A format object can read and write vector features in a specific format.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class VectorFormat extends Format
{

    protected VectorFormat(JSObject element)
    {
        super(element);
    }

    /**
     * Write an array of {@link org.gwtopenmaps.openlayers.client.feature.VectorFeature} objects
     * in a particular format that depends on the specific format object.
     *
     * For example, a WKT format object writes the features in Well Known Text format:
     * <code>
     *   WKT wktFormat = new WKT();
     *   String wkt = wktFormat.write(vectorFeatures);
     * </code>
     *
     * @param vectorFeatures - an array of vector features
     * @return a String containing the vector features written in a particular format.
     */
    public String write(VectorFeature[] vectorFeatures)
    {
        JObjectArray objectArray = new JObjectArray(vectorFeatures);

        return FormatImpl.writeArray(getJSObject(), objectArray.getJSObject());
    }

    /**
     * Write a {@link org.gwtopenmaps.openlayers.client.feature.VectorFeature} in a
     * particular format that depends on the specific format object.
     *
     * For example, a WKT format object writes the features in Well Known Text format:
     * <code>
     *   WKT wktFormat = new WKT();
     *   String wkt = wktFormat.write(vectorFeatures);
     * </code>
     *
     * @param vectorFeature - a vector feature
     * @return a String containing the vector feature written in a particular format.
     */
    public String write(VectorFeature vectorFeature)
    {
        return FormatImpl.write(getJSObject(), vectorFeature.getJSObject());
    }

    /**
     * Read a String representation of a vector format into an array of vector features.
     *
     * @param vectorFormatString - String of a particular vector format
     * @return array of vector features
     */
    // For VectorFormats with specific read options or different return types
    // specific read functions should be constructed.
    // For example:
    // read(String vfString, WKTReadOptions options)
    // readToMap(String vfString, WKTReadOptions options)
    public VectorFeature[] read(String vectorFormatString)
    {
        JSObject out = FormatImpl.read(getJSObject(), vectorFormatString);
        JObjectArray jObjectArray = JObjectArray.narrowToJObjectArray(out.ensureOpaqueArray());
        int nr = jObjectArray.length();
        VectorFeature[] vfs = new VectorFeature[nr];
        for (int i = 0; i < nr; i++)
        {
            // get objects and narrow them to vector features
            vfs[i] = VectorFeature.narrowToVectorFeature(jObjectArray.get(i));
        }

        return vfs;
    }

}
