package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;

/**
 * Callback for context-based styles
 * @author Jon Britton, SpiffyMap Ltd (jonb@spiffymap.net)
 */
public interface ContextStyler {
    public String doStyle(VectorFeature feature);
}
