package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.event.BeforeFeatureHighlightedListener;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.FeatureHighlightedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureUnhighlightedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * When activated, selects features on click by default. Use
 * SelectFeatureOptions argument to select on hover.
 *
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class SelectFeature extends Control {

    protected SelectFeature(JSObject element) {
        super(element);
    }

    /**
     *
     * @param layer
     */
    public SelectFeature(Vector layer) {
        this(SelectFeatureImpl.create(layer.getJSObject()));
    }

    /**
     *
     * @param layers
     */
    public SelectFeature(Vector[] layers) {
        this(SelectFeatureImpl.create2((new JObjectArray(layers)).getJSObject()));
    }

    /**
     *
     * @param layer
     */
    public SelectFeature(Vector layer, SelectFeatureOptions options) {
        this(SelectFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
    }

    /**
     *
     * @param layers
     */
    public SelectFeature(Vector[] layers, SelectFeatureOptions options) {
        this(SelectFeatureImpl.create2((new JObjectArray(layers)).getJSObject(),
                                       options.getJSObject()));
    }

    /**
     * Select a feature when hovering over it with the mouse (mouse in) and
     * deselect it on mouse out.
     *
     * @param hover - true to select on hover
     */
    public void setHover(boolean hover) {
        SelectFeatureImpl.setHover(getJSObject(), hover);
    }

    /**
     * Add feature to the layer�s selectedFeature array, render the feature as
     * selected, and call the onSelect function.
     *
     * @param feature The feature to select
     */
    public void select(VectorFeature feature) {
        SelectFeatureImpl.select(this.getJSObject(), feature.getJSObject());
    }

    /**
     * Remove feature from the layer’s selectedFeature array, render the feature
     * as normal, and call the onUnselect function.
     *
     * @param feature The feature to unselect
     */
    public void unSelect(VectorFeature feature) {
        SelectFeatureImpl.unselect(this.getJSObject(), feature.getJSObject());
    }
    
    /**
     *
     * Select and deselect a feature by clicking on it with the mouse.
     *
     * @param toggle - true to enabling toggling feature selection
     */
    public void setToggle(boolean toggle) {
        SelectFeatureImpl.setToggle(getJSObject(), toggle);
    }

    /**
     *
     * Hold down shift or ctrl and click to select multiple features.
     *
     * @param multiple - true to enable selecting multiple features
     */
    public void setMultiple(boolean multiple) {
        SelectFeatureImpl.setMultiple(getJSObject(), multiple);
    }

    public void setMultipleKey(String keyName) {
        SelectFeatureImpl.setMultipleKey(this.getJSObject(), keyName);
    }

    public void setToggleKey(String keyName) {
        SelectFeatureImpl.setToggleKey(this.getJSObject(), keyName);
    }

    /**
     * Gets the feature associated with the eventObject generated on the
     * highlighted events
     *
     * @param eventObject The EventObject sent by the generic handler
     * @return The {@link VectorFeature} associated
     */
    private VectorFeature getFeatureFromEventObject(EventObject eventObject) {
        // The feature that generated the event is on the
        // property "feature" of the original JavaScript event
        // object
        VectorFeature vectorFeature = VectorFeature.narrowToVectorFeature(eventObject.getJSObject().getProperty(
                "feature"));

        return vectorFeature;
    }

    /**
     *
     * Unselect a feature by clicking outside it.
     *
     * This is the default way of selecting/unselecting features.
     *
     * @param clickout - true to enable unselect on click outside feature.
     */
    public void setClickOut(boolean clickout) {
        SelectFeatureImpl.setClickOut(getJSObject(), clickout);
    }

    /**
     * Adds a listener to be called when the event "beforeFeatureHighlighted"
     * occurs on a Vector Feature. <p> Note: This event is only generated if the
     * hover property of the SelectFeatureOptions of this SelectFeature is set
     * to <b>true</b>
     *
     * @param listener The listener to add
     */
    public void addBeforeFeatureHighlightedListener(
            final BeforeFeatureHighlightedListener beforeFeatureHighlightedListener) {
        eventListeners.addListener(this, beforeFeatureHighlightedListener,
                                   EventType.CONTROL_SELECT_FEATURE_BEFORE_HIGHLIGHTED,
                                   new EventHandler() {
            public void onHandle(EventObject eventObject) {

                VectorFeature vectorFeature = getFeatureFromEventObject(
                        eventObject);

                // Trigger the event
                beforeFeatureHighlightedListener.onBeforeFeatureHighlighted(
                        vectorFeature);
            }
        });
    }

    /**
     * Adds a listener to be called when the event "beforeFeatureHighlighted"
     * occurs on a Vector Feature
     *
     * @param listener The listener to add
     */
    public void addFeatureUnhighlightedListener(
            final FeatureUnhighlightedListener featureUnhighlightedListener) {
        eventListeners.addListener(this, featureUnhighlightedListener,
                                   EventType.CONTROL_SELECT_FEATURE_UNHIGHLIGHTED,
                                   new EventHandler() {
            public void onHandle(EventObject eventObject) {

                VectorFeature vectorFeature = getFeatureFromEventObject(
                        eventObject);

                // Trigger the event
                featureUnhighlightedListener.onFeatureUnhighlighted(
                        vectorFeature);
            }
        });
    }

    /**
     * Adds a listener to be called when the event "beforeFeatureHighlighted"
     * occurs on a Vector Feature
     *
     * @param listener The listener to add
     */
    public void addFeatureHighlightedListener(
            final FeatureHighlightedListener featureHighlightedListener) {
        eventListeners.addListener(this, featureHighlightedListener,
                                   EventType.CONTROL_SELECT_FEATURE_HIGHLIGHTED,
                                   new EventHandler() {
            public void onHandle(EventObject eventObject) {

                VectorFeature vectorFeature = getFeatureFromEventObject(
                        eventObject);

                // Trigger the event
                featureHighlightedListener.onFeatureHighlighted(vectorFeature);
            }
        });
    }

    /**
     * Unselect all selected features. To unselect all except for a single
     * feature.
     *
     * @param exceptFeature null or a feature that should stay selected
     */
    public void unselectAll(VectorFeature exceptFeature) {
        JSObject options = null;
        if (exceptFeature != null) {
            options = JSObject.createJSObject();
            options.setProperty("except", exceptFeature.getJSObject());
        }
        SelectFeatureImpl.unselectAll(getJSObject(), options);
    }

    /**
     *
     */
    public interface SelectFeatureListener {

        void onFeatureSelected(VectorFeature vectorFeature);
    }

    /**
     *
     */
    public interface UnselectFeatureListener {

        void onFeatureUnselected(VectorFeature vectorFeature);
    }

    /**
     *
     */
    public interface ClickFeatureListener {

        void onFeatureClicked(VectorFeature vectorFeature);
    }
}
