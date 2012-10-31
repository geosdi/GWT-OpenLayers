package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 * Download plugin OpenLayers.Control.DeleteFeature from internet
 * or use plugin from repository
 *
 */
public class DeleteFeature extends Control
{

    public DeleteFeature(JSObject element)
    {
        super(element);
    }

    public DeleteFeature(Vector vector)
    {
        this(DeleteFeatureImpl.create(vector.getJSObject()));
    }

}
