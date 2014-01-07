/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.event;

/**
 * changelayer - triggered after a layer name change, order change, opacity
 * change, params change, visibility change (actual visibility, not the layer's
 * visibility property) or attribution change (due to extent change). Listeners
 * will receive an event object with *layer* and *property* properties. The
 * *layer* property will be a reference to the changed layer. The *property*
 * property will be a key to the changed property (name, order, opacity, params,
 * visibility or attribution).
 *
 * Listening to visibility changes can be done at the layer level with a
 * LayerVisibilityChangedListener.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerChangedListener extends EventListener {
    
    public enum ChangeLayerPropertyKey {
        
        PROPERTY_NAME("name"),
        PROPERTY_ORDER("order"),
        PROPERTY_OPACITY("opacity"),
        PROPERTY_PARAMS("params"),
        PROPERTY_VISIBILITY("visibility"),
        PROPERTY_ATTRIBUTION("attribution");
        
        private final String value;
        
        ChangeLayerPropertyKey(String theValue) {
            this.value = theValue;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }
        
        public static ChangeLayerPropertyKey fromValue(String value) {
            for (ChangeLayerPropertyKey key : ChangeLayerPropertyKey.values()) {
                if (key.value.equalsIgnoreCase(value)) {
                    return key;
                }
            }
            
            throw new IllegalArgumentException("No ChangeLayerPropertyKey"
                    + " found for value : " + value);
        }
        
    }
    
    public void onLayerChanged(MapLayerChangedEvent eventObject);
    
    class MapLayerChangedEvent extends MapLayerEvent {
        
        public MapLayerChangedEvent(EventObject eventObject) {
            super(eventObject.getJSObject());
        }
        
        public ChangeLayerPropertyKey getProperty() {
            return ChangeLayerPropertyKey.fromValue(
                    getJSObject().getPropertyAsString("property"));
        }
        
    }
    
}
