/**
 *
 */
package org.gwtopenmaps.openlayers.client.event;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventType
{

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

}
