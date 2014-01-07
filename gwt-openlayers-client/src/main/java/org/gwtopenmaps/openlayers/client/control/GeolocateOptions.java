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

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public final class GeolocateOptions extends ControlOptions {

    /**
     * Build the Geolocate Options Object setting defaults Value on Control.
     *
     * <p>
     * enableHighAccuracy set to
     * <code>false</code> maximumAge set to
     * <code>0</code> timeout set to
     * <code>-1</code>
     * </p>
     */
    public GeolocateOptions() {
        super();
        initializeGeolocateControl();
    }

    /**
     * Sets whether or not the application will request a more accurate position
     * from the browser.
     *
     * <p>
     * Requesting high accuracy may be slower, or not supported at all,
     * depending on the browser.
     * </p>
     *
     */
    public void setEnableHighAccuracy(boolean theEnableHighAccuracy) {
        getJSObject().setProperty("enableHighAccuracy", theEnableHighAccuracy);
    }

    /**
     * Allows the browser to return a position immediately with a cached
     * position. The maximum age is then the oldest acceptable cached position.
     * If no acceptable cached position is found, the browser will locate the
     * user and cache and return the position.
     *
     */
    public void setMaximumAge(int theMaximumAge) {
        getJSObject().setProperty("maximumAge", theMaximumAge);
    }

    /**
     * Sets the amount of time (in milliseconds) that the application is willing
     * to wait before getting the user's position. If a request for position
     * takes more than this amount of time, an error will result.
     *
     */
    public void setTimeout(int theTimeout) {
        getJSObject().setProperty("timeout", theTimeout);
    }

    private void initializeGeolocateControl() {
        this.setEnableHighAccuracy(false);
        this.setTimeout(-1);
        this.setMaximumAge(0);
    }

}
