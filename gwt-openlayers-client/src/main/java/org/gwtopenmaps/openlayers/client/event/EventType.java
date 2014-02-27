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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.event;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventType {

    public static final String CONTROL_ACTIVATE = "activate";
    public static final String CONTROL_DEACTIVATE = "deactivate";
    public static final String CONTROL_MEASURE = "measure";
    public static final String CONTROL_MEASURE_PARTIAL = "measurepartial";
    public static final String CONTROL_GET_FEATURE_INFO = "getfeatureinfo";
    public static final String CONTROL_GET_FEATURE_INFO_BEFORE = "beforegetfeatureinfo";
    public static final String CONTROL_NO_GET_FEATURE_INFO = "nogetfeatureinfo";
    public static final String CONTROL_SELECT_FEATURE_SELECT = "onSelect"; // in OL 2.8 not really event, but name of property that refers to callback fn
    public static final String CONTROL_SELECT_FEATURE_UNSELECT = "onUnselect"; // in OL 2.8 not really event , but name of property that refers to callback fn
    public static final String CONTROL_SELECT_FEATURE_BEFORE_HIGHLIGHTED = "beforefeaturehighlighted";
    public static final String CONTROL_SELECT_FEATURE_HIGHLIGHTED = "featurehighlighted";
    public static final String CONTROL_SELECT_FEATURE_UNHIGHLIGHTED = "featureunhighlighted";
    public static final String LAYER_LOADSTART = "loadstart";
    public static final String LAYER_LOADEND = "loadend";
    public static final String LAYER_LOADCANCEL = "loadcancel";
    public static final String LAYER_VISIBILITYCHANGED = "visibilitychanged";
    public static final String MAP_BASE_LAYER_CHANGED = "changebaselayer";
    public static final String MAP_CLICK = "click";
    public static final String MAP_LAYER_ADDED = "addlayer";
    public static final String MAP_LAYER_CHANGED = "changelayer";
    public static final String MAP_LAYER_REMOVED = "removelayer";
    public static final String MAP_MOVE = "move";
    public static final String MAP_MOVEEND = "moveend";
    public static final String MAP_ZOOMEND = "zoomend";
    public static final String MAP_POPUP_OPEN = "popupopen";
    public static final String MAP_POPUP_CLOSE = "popupclose";
    public static final String MAP_MARKER_ADDED = "addmarker";
    public static final String MAP_MARKER_REMOVED = "removemarker";
    public static final String VECTOR_BEFORE_FEATURE_ADDED = "beforefeatureadded";
    public static final String VECTOR_FEATURE_ADDED = "featureadded";
    public static final String VECTOR_FEATURE_MODIFIED = "featuremodified";
    public static final String VECTOR_AFTER_FEATURE_MODIFIED = "afterfeaturemodified";
    public static final String VECTOR_BEFORE_FEATURE_MODIFIED = "beforefeaturemodified";
    public static final String VECTOR_FEATURE_REMOVED = "featureremoved";
    public static final String VECTOR_FEATURE_SELECTED = "featureselected";
    public static final String VECTOR_FEATURE_UNSELECTED = "featureunselected";
    public static final String VECTOR_FEATURE_VERTEX_MODIFIED = "vertexmodified";
    public static final String GEOLOCATE_LOCATION_UPDATE = "locationupdated";
    public static final String GEOLOCATE_LOCATION_FAILED = "locationfailed";
    public static final String GEOLOCATE_LOCATION_UNCAPABLE = "locationuncapable";
    /**
     * GET_FEATURE CONTROL *
     */
    public static final String BEFORE_FEATURE_SELECTED = "beforefeatureselected";
    public static final String FEATURE_SELECTED = "featureselected";
    public static final String BEFORE_FETURES_SELECTED = "beforefeaturesselected";
    public static final String FEATURES_SELECTED = "featuresselected";
    public static final String FEATURE_UNSELECTED = "featureunselected";
    public static final String CLICK_OUT = "clickout";
    public static final String HOVER_FEATURE = "hoverfeature";
    public static final String OUT_FEATURE = "outfeature";
    /**
     * BROWSER EVENTS
     */
    public static final String MOUSE_OVER = "mouseover";
    public static final String MOUSE_OUT = "mouseout";

}
