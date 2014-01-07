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

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.control.Geolocate;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class LocationUpdateEvent extends EventObject {

    public LocationUpdateEvent(EventObject eventObject) {
        super(eventObject.getJSObject());
    }

    public Geolocate getSource() {
        JSObject object = super.getSourceJSObject();

        return (object != null) ? Geolocate.narrowToGeolocate(object) : null;
    }

    /**
     *
     * @return {@link Point} point property which is the location transformed in
     * the current map projection.
     */
    public Point getPoint() {
        JSObject object = super.getJSObject().getProperty("point");

        return (object != null) ? Point.narrowToPoint(object) : null;
    }

    public Position getPosition() {
        JSObject object = super.getJSObject().getProperty("position");

        return (object != null) ? Position.narrowToPosition(object) : null;
    }

    public static class Position extends OpenLayersObjectWrapper {

        protected Position(JSObject openLayersObject) {
            super(openLayersObject);
        }

        public static Position narrowToPosition(JSObject element) {
            return (element != null) ? new Position(element) : null;
        }

        public Coords getCoords() {
            return Coords.narrowToCoords(super.getJSObject().getProperty(
                    "coords"));
        }

        public static class Coords extends OpenLayersObjectWrapper {

            protected Coords(JSObject openLayersObject) {
                super(openLayersObject);
            }

            public static Coords narrowToCoords(JSObject element) {
                return (element != null) ? new Coords(element) : null;
            }

            public double lon() {
                return getJSObject().getPropertyAsDouble("longitude");
            }

            public double lat() {
                return getJSObject().getPropertyAsDouble("latitude");
            }

            public float getAccuracy() {
                return getJSObject().getPropertyAsFloat("accuracy");
            }

        }
    }
}
