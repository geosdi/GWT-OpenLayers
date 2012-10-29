package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.util.JDoubleArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Represents a bounding box (or bounding rectangle).
 *
 * @author Erdem Gunay
 * @author Curtis Jensen
 * @author Edwin Commandeur
 * @author Jon Britton, SpiffyMap Ltd.
 */
public class Bounds extends OpenLayersObjectWrapper {

    protected Bounds(JSObject element) {
        super(element);
    }

    public static Bounds narrowToBounds(JSObject element) {
        return (element == null) ? null : new Bounds(element);
    }

    /**
     * Create a bounding box by specifying its lower left coordinates, and its
     * upper right coordinates.
     *
     * The units of the bounding box will depend on the CRS and or projection
     * used.
     *
     * For example, a bounds object that represents the world-wide bounds in
     * EPSG:4392 is specified as: new Bounds(-180,-90,180,90);
     *
     * @param lowerLeftX = west = minx
     * @param lowerLeftY = south = miny
     * @param upperRightX = east = maxx
     * @param upperRightY = north = maxy
     */
    public Bounds(double lowerLeftX,
            double lowerLeftY,
            double upperRightX,
            double upperRightY) {
        this(BoundsImpl.create(lowerLeftX,
                               lowerLeftY,
                               upperRightX,
                               upperRightY));
    }

    /**
     * Create an empty Bounds object with coordinates set to null
     */
    public Bounds() {
        this(BoundsImpl.create());
    }

    public double[] toArray() {
        JSObject boundsOpaque = BoundsImpl.toArray(getJSObject());
        JDoubleArray bounds = JDoubleArray.narrowToJDoubleArray(boundsOpaque);
        int boundsLength = bounds.length();
        double[] boundsCoordinates = new double[4];
        if (boundsLength == 4) {
            for (int i = 0; i < boundsLength; i++) {
                boundsCoordinates[i] = bounds.get(i);
            }
        }
        return boundsCoordinates;
    }

    /**
     * @return double - lower left x-coordinate of bounds
     */
    public double getLowerLeftX() {
        return BoundsImpl.getMinX(getJSObject());
    }

    /**
     * @return double - lower left y-coordinate of bounds
     */
    public double getLowerLeftY() {
        return BoundsImpl.getMinY(getJSObject());
    }

    /**
     * @return double - upper right x-coordinate of bounds
     */
    public double getUpperRightX() {
        return BoundsImpl.getMaxX(getJSObject());
    }

    /**
     * @return double - upper right y-coordinate of bounds
     */
    public double getUpperRightY() {
        return BoundsImpl.getMaxY(getJSObject());
    }

    public float getWidth() {
        return BoundsImpl.getWidth(getJSObject());
    }

    public float getHeight() {
        return BoundsImpl.getHeight(getJSObject());
    }

    /**
     * @return the size of the box
     */
    public Size getSize() {
        return Size.narrowToSize(BoundsImpl.getSize(getJSObject()));
    }

    /**
     * @param significantDigits - Number of significant digits in the bbox
     * coordinates, pass null to use the default of 6.
     * @return String - simple string representation of a Bounds object. For
     * example: "5,42,10,45"
     */
    public String toBBox(Integer significantDigits) {
        return BoundsImpl.toBBox(getJSObject(), significantDigits);
    }

    public String toString() {
        return BoundsImpl.toString(getJSObject());
    }

    /**
     *
     * @return the center of the bounds in map space
     */
    public LonLat getCenterLonLat() {
        return LonLat.narrowToLonLat(BoundsImpl.getCenterLonLat(
                this.getJSObject()));
    }

    /**
     * @return the center of the bounds in pixel space
     */
    public Pixel getCenterPixel() {
        return Pixel.narrowToPixel(BoundsImpl.getCenterPixel(this.getJSObject()));
    }

    public Geometry toGeometry() {
        return Geometry.narrowToGeometry(BoundsImpl.toGeometry(
                this.getJSObject()));
    }

    public boolean containsBounds(Bounds bounds,
            boolean partial,
            boolean contains) {
        return BoundsImpl.containsBounds(getJSObject(), bounds.getJSObject(),
                                         partial, contains);
    }

    public void extend(LonLat lonLat) {
        BoundsImpl.extend(this.getJSObject(), lonLat.getJSObject());
    }

    public void extend(Point point) {
        BoundsImpl.extend(this.getJSObject(), point.getJSObject());
    }

    public void extend(Bounds bounds) {
        BoundsImpl.extend(this.getJSObject(), bounds.getJSObject());
    }

    public Bounds transform(Projection source,
            Projection dest) {
        return Bounds.narrowToBounds(BoundsImpl.transform(getJSObject(),
                                                          source.getJSObject(),
                                                          dest.getJSObject()));
    }

    /**
     * Scales the bounds.
     *
     * @param ratio
     * @return a new bounds that is scaled by ratio
     */
    public Bounds scale(float ratio) {
        return Bounds.narrowToBounds(BoundsImpl.scale(this.getJSObject(), ratio,
                                                      null));
    }

    /**
     * Scales the bounds around a pixel. Note that the new bounds may return
     * non-integer properties.
     *
     * @param ratio
     * @param origin default is center
     * @return a new bounds that is scaled by ratio from origin
     */
    public Bounds scale(float ratio,
            Pixel origin) {
        JSObject originJsObj = (origin == null) ? null : origin.getJSObject();
        return Bounds.narrowToBounds(BoundsImpl.scale(this.getJSObject(), ratio,
                                                      originJsObj));
    }

    /**
     * @param x
     * @param y
     * @return A new bounds whose coordinates are the same as this, but shifted
     * by the passed-in x and y values.
     */
    public Bounds add(float x,
            float y) {
        return Bounds.narrowToBounds(BoundsImpl.add(this.getJSObject(), x, y));
    }

    /**
     * Scales the bounds around a LonLat.
     *
     * @param ratio
     * @param origin default is center
     * @return a new bounds that is scaled by ratio from origin
     */
    public Bounds scale(float ratio,
            LonLat origin) {
        JSObject originJsObj = (origin == null) ? null : origin.getJSObject();
        return Bounds.narrowToBounds(BoundsImpl.scale(this.getJSObject(), ratio,
                                                      originJsObj));
    }

    /**
     * APIMethod: containsLonLat
     *
     * Parameters: ll - {<OpenLayers.LonLat>} inclusive - {Boolean} Whether or
     * not to include the border. Default is true.
     *
     * Returns: {Boolean} The passed-in lonlat is within this bounds.
     */
    public boolean containsLonLat(LonLat ll,
            boolean inclusive) {
        return BoundsImpl.containsLonLat(getJSObject(), ll.getJSObject(),
                                         inclusive);
    }

    /**
     * Determine whether the target bounds intersects this bounds. Bounds are
     * considered intersecting if any of their edges intersect or if one bounds
     * contains the other.
     *
     * @param bounds the target bounds
     * @return whether the passed-in bounds object intersects this bounds
     */
    public boolean intersectsBounds(Bounds bounds) {
        return BoundsImpl.intersectsBounds(this.getJSObject(),
                                           bounds.getJSObject());
    }
}
