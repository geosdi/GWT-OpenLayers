package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public abstract class Collection extends Geometry{

    protected Collection(JSObject element){
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
    public int getNumberOfComponents(){
        return CollectionImpl.getNumberOfComponents(getJSObject());
    }
    
    public JSObject getComponent(int index){
        return CollectionImpl.getComponent(getJSObject(), index);
    }
    

	public void transform(Projection source, Projection dest) {
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
	public boolean equals(Geometry geometry) {
		return CollectionImpl.equals(getJSObject(), geometry.getJSObject());
	}

	public double getLength() {
		return CollectionImpl.getLength(getJSObject());
	}


}
