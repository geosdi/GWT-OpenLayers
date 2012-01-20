package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;


/**
 * Listener to handle the event BeforeFeatureHighlighted that occurs on a
 * VectorFeature of the layer
 *
 * @author Rafael Ceravolo - LOGANN Special Solutions
 */
public interface BeforeFeatureHighlightedListener extends EventListener
{

    /**
     * Called when the event BeforeFeatureHighlighted occurs on a VectorFeature
     * of the layer
     *
     * @param vectorFeature
     *            The VectorFeature that generated the event
     */
    public void onBeforeFeatureHighlighted(VectorFeature vectorFeature);
}
