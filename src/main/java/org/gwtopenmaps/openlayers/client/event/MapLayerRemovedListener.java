package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerRemovedListener extends EventListener {

    class MapLayerRemovedEvent extends EventObject{

        public MapLayerRemovedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public Layer getLayer() {
            return super.getLayer();
        }
    }
    
    public void onLayerRemoved(Map source, MapLayerRemovedEvent eventObject);
}
