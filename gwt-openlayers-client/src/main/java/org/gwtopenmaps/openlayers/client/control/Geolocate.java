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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.LocationFailedEvent;
import org.gwtopenmaps.openlayers.client.event.LocationFailedListener;
import org.gwtopenmaps.openlayers.client.event.LocationUncapableListener;
import org.gwtopenmaps.openlayers.client.event.LocationUpdateEvent;
import org.gwtopenmaps.openlayers.client.event.LocationUpdateListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * Supported event types (in addition to those from
 * <OpenLayers.Control.events>):
 *
 * locationupdated - Triggered when browser return a new position. Listeners
 * will receive an object with a 'position' property which is the
 * browser.geolocation.position native object, as well as a 'point' property
 * which is the location transformed in the current map projection.
 *
 * locationfailed - Triggered when geolocation has failed.
 *
 * locationuncapable - Triggered when control is activated on a browser which
 * doesn't support geolocation.
 *
 * To support this features i have added three listeners :
 *
 * <ul>
 * <li>{@link LocationUpdateListener} listener</li>
 * <li>{@link LocationFailedListener} listener</li>
 * <li>{@link LocationUncapableListener} listener</li>
 * </ul>
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class Geolocate extends Control {

    private static final GeolocateOptions defaultOptions = new GeolocateOptions();

    public static Geolocate narrowToGeolocate(JSObject element) {
        return (element == null) ? null : new Geolocate(element);
    }

    protected Geolocate(JSObject element) {
        super(element);
    }

    public Geolocate() {
        super(GeolocateImpl.create(defaultOptions.getJSObject()));
    }

    public Geolocate(GeolocateOptions theGeolocateOptions) {
        super(GeolocateImpl.create(theGeolocateOptions.getJSObject()));
    }

    /**
     * {Boolean} If true, map center will be set on location update.
     *
     * @param bind
     */
    public void setBind(boolean bind) {
        super.getJSObject().setProperty("bind", bind);
    }

    /**
     * {Boolean} If true, position will be update regularly.
     *
     * @param watch
     */
    public void setWatch(boolean watch) {
        super.getJSObject().setProperty("watch", watch);
    }

    public void addLocationUpdateListener(final LocationUpdateListener listener) {
        eventListeners.addListener(this, listener,
                EventType.GEOLOCATE_LOCATION_UPDATE, new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                LocationUpdateEvent event = new LocationUpdateEvent(eventObject);
                listener.onLocationUpdate(event);
            }

        });
    }

    public void addLocationFailedListener(final LocationFailedListener listener) {
        eventListeners.addListener(this, listener,
                EventType.GEOLOCATE_LOCATION_FAILED, new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                LocationFailedEvent event = new LocationFailedEvent(eventObject);
                listener.onLocationFailed(event);
            }

        });
    }

    public void addLocationUncapableListener(
            final LocationUncapableListener listener) {
        eventListeners.addListener(this, listener,
                EventType.GEOLOCATE_LOCATION_UNCAPABLE, new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                listener.onLocationUncapable();
            }

        });
    }

}
