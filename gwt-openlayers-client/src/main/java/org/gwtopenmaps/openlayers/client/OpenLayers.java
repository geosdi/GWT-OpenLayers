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
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Methods for interacting with the global OpenLayers object.
 *
 */
public class OpenLayers implements EntryPoint {

    /** ClientBundle for JavaScript. */
    public interface Scripts extends ClientBundle
    {
        /** Static instance. */
        Scripts INSTANCE = GWT.create(Scripts.class);

        /**
         * TextResource for effects.js.
         * @return TextResource for effects.js
         */
        @Source("js/gwt-openlayers/util.js")
        TextResource scriptUtil();
    }

    /**
     * @param proxyhost - the relative path to the proxyhost, including the
     *   parameter that takes the url to forward the request to as value.
     *
     * For example: "GwtOpenlayersProxy?resourceUrl="
     */
    public static native void setProxyHost(String proxyhost)/*-{
    $wnd.OpenLayers.ProxyHost = proxyhost;
    }-*/;

    /**
     *
     * @return the proxyhost that has been set, or null if no
     *   proxyHost has been set
     */
    public static native String getProxyHost()/*-{
    return ($wnd.OpenLayers.ProxyHost !== undefined)?$wnd.OpenLayers.ProxyHost:null;
    }-*/;

    /**
     * Sets the IMAGE_RELOAD_ATTEMPTS property on the OpenLayers Object.
     *
     * @param attempts - the number of times OpenLayers will try to load an image that is requested over HTTP after the first attempt failed
     */
    public static native void setImageReloadAttempts(int attempts)/*-{
    $wnd.OpenLayers.IMAGE_RELOAD_ATTEMPTS = attempts;
    }-*/;

    /**
     * @return the number of times OpenLayers will try to load an image that is requested over HTTP after the first attempt failed -
     *   by default this is 0 (that is, one try)
     */
    public static native int getImageReloadAttempts()/*-{
    return $wnd.OpenLayers.IMAGE_RELOAD_ATTEMPTS;
    }-*/;

    /**
     *
     * @return default 72
     */
    public static native double getDotPerInch() /*-{
    return $wnd.OpenLayers.DOTS_PER_INCH;
    }-*/;

    /**
     * @param value
     */
    public static native void setDotPerInch(double value) /*-{
    $wnd.OpenLayers.DOTS_PER_INCH = value;
    }-*/;

    public static native double getInchesPerUnitMeter() /*-{
    return $wnd.OpenLayers.INCHES_PER_UNIT['m'];
    }-*/;

    public static native double getInchesPerUnit(String units) /*-{
    return $wnd.OpenLayers.INCHES_PER_UNIT[units];
    }-*/;

    /**
     * Add a new well known graphic.
     * @param wellKnownPoints The poins of the new well known graphic
     * @param name The name of the new well known graphic
     */
    public static void addWellKnownGraphic(int[] wellKnownPoints, String name) {
        JsArrayNumber jsArray = (JsArrayNumber) JsArrayNumber.createArray();
        for (int wellKnownPoint : wellKnownPoints) {
            jsArray.push(wellKnownPoint);
        }
        addWellKnownGraphic(jsArray, name);
    }

    private static native void addWellKnownGraphic(JsArrayNumber wellKnownPoints, String name) /*-{
        $wnd.OpenLayers.Renderer.symbol[name] = wellKnownPoints;
    }-*/;

    public static class Util {

        /**
         * @author Nazzareno Sileno - CNR IMAA geoSDI Group - @email nazzareno.sileno@geosdi.org
         * */

        public static native double getScaleFromResolution(double resolution,
                String units)/*-{
        return $wnd.OpenLayers.Util.getScaleFromResolution(resolution, units);
        }-*/;

        public static native double getResolutionFromScale(double scale,
                String units)/*-{
        return $wnd.OpenLayers.Util.getResolutionFromScale(scale, units);
        }-*/;

        /**
         * Given two objects representing points with geographic coordinates, this calculates the distance between those points on the surface of an ellipsoid.
         * @param p1
         * @param p2
         * @return The distance (in km) between the two input points as measured on an ellipsoid.  Note that the input point objects must be in geographic coordinates (decimal degrees) and the return distance is in kilometers.
         */
        public static float distVincenty(LonLat p1, LonLat p2)
        {
            return distVincenty(p1.getJSObject(), p2.getJSObject());
        }

        private static native float distVincenty(JSObject p1, JSObject p2) /*-{
            return $wnd.OpenLayers.Util.distVincenty(p1, p2);
        }-*/;

        /**
         * Calculate destination point given start point lat/long (numeric degrees), bearing (numeric degrees) & distance (in m).  Adapted from Chris Veness work, see http://www.movable-type.co.uk/scripts/latlong-vincenty-direct.html
         * @param lonlat
         * @param brng The bearing (degrees).
         * @param dist The ground distance (meters).
         * @return The destination point.
         */
        public static LonLat destinationVincenty(LonLat lonlat, float brng, float dist)
        {
            return LonLat.narrowToLonLat(destinationVincenty(lonlat.getJSObject(), brng, dist));
        }

        private static native JSObject destinationVincenty(JSObject lonlat, float brng, float dist) /*-{
            return $wnd.OpenLayers.Util.destinationVincenty(lonlat, brng, dist);
        }-*/;
    }

    @Override
    public void onModuleLoad()
    {
        ScriptInjector.injectResourceScriptAsFile(Scripts.INSTANCE.scriptUtil().getText());
    }
}
