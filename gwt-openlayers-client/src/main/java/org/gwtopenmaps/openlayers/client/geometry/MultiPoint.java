package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * MultiPoint is a collection of Points.
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

    /**
     * Add a point to the MultiPoint
     * @param point The point to add
     * @param The index
     */
    public void addPoint (Point point, int index) {
        addComponent(point, index);
    }

    /**
     * Removes a point from this MultiPoint
     * @param point The point to remove
     */
    public void removePoint (Point point) {
        removeComponent(point);
    }

}
