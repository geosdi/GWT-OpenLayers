package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public abstract class MultiPoint extends Collection {

    protected MultiPoint(JSObject element) {
        super(element);
    }

    public Point[] getComponents() {
        int max = getNumberOfComponents();
        Point[] components = new Point[max];
        for (int i = 0; i < max; i++) {
            components[i] = Point.narrowToPoint(getComponent(i));
        }

        return components;
    }

    public double[][] getCoordinateArray() {
        Point[] components = getComponents();
        int max = components.length;
        double[][] coordinateArray = new double[max][];
        for (int i = 0; i < max; i++) {
            coordinateArray[i] = components[i].getXY();
        }

        return coordinateArray;
    }
}
