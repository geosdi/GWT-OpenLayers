package org.gwtopenmaps.openlayers.client.geometry;

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

}
