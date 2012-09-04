package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public abstract class Collection extends Geometry
{

    protected Collection(JSObject element)
    {
        super(element);
    }

    /**
     * Every Geometry that is a collection has components
     * These components can be basic geometry types or other collections.
     * The getComponents method is defined for direct subclasses of Collection
     * and the return type differs per subclass.
     *
     * @return integer number of components
     */
    public int getNumberOfComponents()
    {
        return CollectionImpl.getNumberOfComponents(getJSObject());
    }

    public JSObject getComponent(int index)
    {
        return CollectionImpl.getComponent(getJSObject(), index);
    }


    public void transform(Projection source, Projection dest)
    {
        CollectionImpl.transform(getJSObject(), source.getJSObject(),
            dest.getJSObject());
    }

    /**
     * APIMethod: equals Determine whether another geometry is equivalent to
     * this one. Geometries are considered equivalent if all components have the
     * same coordinates.
     *
     * Parameters: geom - {<OpenLayers.Geometry>} The geometry to test.
     *
     * Returns: {Boolean} The supplied geometry is equivalent to this geometry.
     */
    public boolean equals(Geometry geometry)
    {
        return CollectionImpl.equals(getJSObject(), geometry.getJSObject());
    }

    /**
     * Calculate the length of this geometry
     * @return The length of the geometry
     */
    public double getLength()
    {
        return CollectionImpl.getLength(getJSObject());
    }
    
    /**
     * Moves a geometry by the given displacement along positive x and y axes.  
     * This modifies the position of the geometry and clears the cached bounds.
     * @param x Distance to move geometry in positive x direction.
     * @param y Distance to move geometry in positive y direction.
     */
    public void move(double x, double y)
    {
    	CollectionImpl.move(getJSObject(), x, y);
    }
    
    /**
     * Rotate a geometry around some origin.
     * @param angle Rotation angle in degrees (measured counterclockwise from the positive x-axis)
     * @param origin Center point for the rotation
     */
    public void rotate(double angle, Point origin)
    {
    	CollectionImpl.rotate(getJSObject(), angle, origin.getJSObject());
    }
    
    /**
     * Resize a geometry relative to some origin.  Use this method to apply a uniform scaling to a geometry.
     * @param scale	Factor by which to scale the geometry.  A scale of 2 doubles the size of the geometry in each dimension (lines, for example, will be twice as long, and polygons will have four times the area).
	 * @param origin Point of origin for resizing
	 * @param ratio x:y ratio for resizing.  Default ratio is 1.
     */
    public void resize(double scale, Point origin, double ratio)
    {
    	CollectionImpl.resize(getJSObject(), scale, origin.getJSObject(), ratio);
    }

    /**
     * Resize a geometry relative to some origin.  Use this method to apply a uniform scaling to a geometry.
     * This method uses a default ratio of 1
     * @param scale	Factor by which to scale the geometry.  A scale of 2 doubles the size of the geometry in each dimension (lines, for example, will be twice as long, and polygons will have four times the area).
	 * @param origin Point of origin for resizing
     */
    public void resize(double scale, Point origin)
    {
    	CollectionImpl.resize(getJSObject(), scale, origin.getJSObject());
    }
}
