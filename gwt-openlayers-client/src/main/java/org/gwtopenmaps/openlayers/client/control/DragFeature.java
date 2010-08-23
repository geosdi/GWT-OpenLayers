package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * This control is used to handle drag and drop of the vector features of a
 * layer. Use the {@link DragFeatureOptions} to handle the events.
 * 
 * @author Rafael Ceravolo - LOGANN
 */
public class DragFeature extends Control {

    /**
     * Listener for Drag events (Start, Drag and Complete)
     */
    public interface DragFeatureListener {
	void onDragEvent(VectorFeature vectorFeature, Pixel pixel);
    }

    /** Internal Constructor */
    protected DragFeature(JSObject dragFeatureObj) {
	super(dragFeatureObj);
    }

    /**
     * Constructor.
     * 
     * @param vectorLayer
     *            The layer that this DragFeature belongs.
     */
    public DragFeature(Vector vectorLayer) {
	this(DragFeatureImpl.create(vectorLayer.getJSObject()));
    }

    /**
     * Constructor.
     * 
     * @param vectorLayer
     *            The layer that this DragFeature belongs.
     * @param The
     *            DragFeature options, used to set the listeners that handles
     *            the drag events
     */
    public DragFeature(Vector vectorLayer, DragFeatureOptions options) {
	this(DragFeatureImpl.create(vectorLayer.getJSObject(), options
		.getJSObject()));
    }

}
