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
package org.gwtopenmaps.openlayers.client.layer;

/*
 * Copyright 2013 geoSDI.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public enum TransitionEffect {

    /**
     * Existing tiles are resized on zoom to provide a visual effect of the zoom
     * having taken place immediately. As the new tiles become available, they
     * are drawn on top of the resized tiles (this is the default setting).
     */
    RESIZE("resize"),
    /**
     * Existing tiles are resized on zoom and placed below the base layer. New
     * tiles for the base layer will cover existing tiles. This setting is
     * recommended when having an overlay duplicated during the transition is
     * undesirable (e.g. street labels or big transparent fills).
     */
    MAP_RESIZE("map-resize"),
    /**
     * No transition effect.
     */
    NONE(null);

    private final String value;

    TransitionEffect(String theValue) {
        this.value = theValue;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    public static TransitionEffect fromValue(String value) {
        for (TransitionEffect t : TransitionEffect.values()) {
            if (t.value.equalsIgnoreCase(value)) {
                return t;
            }
        }

        return NONE;
    }

}
