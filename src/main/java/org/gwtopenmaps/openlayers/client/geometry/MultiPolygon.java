package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class MultiPolygon extends Collection {

	protected MultiPolygon(JSObject element) {
		super(element);
	}
	
    public MultiPolygon(Polygon[] polygons){
        this(MultiPolygonImpl.create((new JObjectArray(polygons)).getJSObject()));
    }
	
    public static MultiPolygon narrowToMultiPolygon(JSObject multiPolygon){
        return (multiPolygon == null) ? null : new MultiPolygon(multiPolygon);
    }
    
    /**
     * MultiPolygons are collections of Polygons.
     *  
     * @return Array of LinearRing Objects
     */
    public Polygon[] getComponents(){
        int max = getNumberOfComponents();
        Polygon[] components = new Polygon[max];
        for(int i = 0; i < max; i++){
            components[i] = Polygon.narrowToPolygon(getComponent(i));
        }
        return components;
    }
    
}
