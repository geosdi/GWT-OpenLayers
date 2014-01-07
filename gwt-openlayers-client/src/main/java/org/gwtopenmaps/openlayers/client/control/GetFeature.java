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

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.event.BeforeFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.BeforeFeatureSelectedListener.BeforeFeatureSelectedEvent;
import org.gwtopenmaps.openlayers.client.event.BeforeFeaturesSelectedListener;
import org.gwtopenmaps.openlayers.client.event.BeforeFeaturesSelectedListener.BeforeFeaturesSelectedEvent;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.FeatureClickoutListener;
import org.gwtopenmaps.openlayers.client.event.FeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureSelectedListener.FeatureSelectedEvent;
import org.gwtopenmaps.openlayers.client.event.FeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureUnselectedListener.FeatureUnselectedEvent;
import org.gwtopenmaps.openlayers.client.event.FeaturesSelectedListener;
import org.gwtopenmaps.openlayers.client.event.FeaturesSelectedListener.FeaturesSelectedEvent;
import org.gwtopenmaps.openlayers.client.event.HoverFeatureListener;
import org.gwtopenmaps.openlayers.client.event.OutFeatureListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.filter.SpatialFilter;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * <p>GetFeature implementation that gets Vector Features use WFS</p>
 *
 * <p>Supported event types :
 * <ul>
 * <li>beforefeatureselected Triggered when click is true before a feature is
 * selected. The event object has a feature property with the feature about to
 * select</li>
 * <li>featureselected	Triggered when click is true and a feature is selected.
 * The event object has a feature property with the selected feature</li>
 * <li>beforefeaturesselected	Triggered when click is true before a set of
 * features is selected. The event object is an array of feature properties with
 * the features about to be selected. Return false after receiving this event to
 * discontinue processing of all featureselected events and the featuresselected
 * event.</li>
 * <li>featuresselected	Triggered when click is true and a set of features is
 * selected. The event object is an array of feature properties of the selected
 * features</li>
 * <li>featureunselected Triggered when click is true and a feature is
 * unselected. The event object has a feature property with the unselected
 * feature</li>
 * <li>clickout	Triggered when click is true and no feature was selected.</li>
 * <li>hoverfeature Triggered when hover is true and the mouse has stopped over
 * a feature</li>
 * <li>outfeature Triggered when hover is true and the mouse moves moved away
 * from a hover-selected feature</li>
 * </ul>
 * </p>
 *
 * @author davek<at>komacke<dot>com
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class GetFeature extends Control {

    public static GetFeature narrowToGetFeature(JSObject getFeature) {
        return (getFeature == null) ? null : new GetFeature(getFeature);
    }

    protected GetFeature(JSObject element) {
        super(element);
    }

    public GetFeature() {
        this(GetFeatureImpl.create());
    }

    public GetFeature(GetFeatureOptions options) {
        this(GetFeatureImpl.create(options.getJSObject()));
    }

    @Deprecated
    public void setSelectVectorFeature(VectorFeature feature) {
        getJSObject().setProperty("select", feature.getJSObject());
    }

    public void unselectAll() {
        GetFeatureImpl.unselectAll(getJSObject());
    }

    public void selectBox(Bounds bounds) {
        GetFeatureImpl.selectBox(getJSObject(), bounds.getJSObject());
    }

    @Deprecated
    public Bounds getBounds() {
        return Bounds.narrowToBounds(GetFeatureImpl.getBounds(getJSObject()));
    }

    public boolean isMultiple() {
        return getJSObject().getPropertyAsBoolean("multiple");
    }

    public boolean isClick() {
        return getJSObject().getPropertyAsBoolean("click");
    }

    public boolean isSingle() {
        return getJSObject().getPropertyAsBoolean("single");
    }

    public boolean isClickout() {
        return getJSObject().getPropertyAsBoolean("clickout");
    }

    public boolean isToggle() {
        return getJSObject().getPropertyAsBoolean("toggle");
    }

    public int getClickTolerance() {
        return getJSObject().getPropertyAsInt("clickTolerance");
    }

    public boolean isHover() {
        return getJSObject().getPropertyAsBoolean("hover");
    }

    public boolean isBox() {
        return getJSObject().getPropertyAsBoolean("box");
    }

    public int getMaxFeatures() {
        return getJSObject().getPropertyAsInt("maxFeatures");
    }

    public SpatialFilter getFilterType() {
        return SpatialFilter.narrowToSpatialFilter(getJSObject().getProperty(
                "filterType"));
    }

    public void addBeforeFeatureSelectedListener(
            final BeforeFeatureSelectedListener listener) {

        eventListeners.addListener(this, listener,
                EventType.BEFORE_FEATURE_SELECTED, new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                BeforeFeatureSelectedEvent event = new BeforeFeatureSelectedEvent(
                        eventObject);
                listener.onBeforeFeatureSelected(event);
            }

        });
    }

    public void addFeatureSelectedListener(
            final FeatureSelectedListener listener) {

        eventListeners.addListener(this, listener, EventType.FEATURE_SELECTED,
                new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                FeatureSelectedEvent event = new FeatureSelectedEvent(
                        eventObject);
                listener.onFeatureSelected(event);
            }

        });
    }

    public void addBeforeFeaturesSelectedListener(
            final BeforeFeaturesSelectedListener listener) {

        eventListeners.addListener(this, listener,
                EventType.BEFORE_FETURES_SELECTED, new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                BeforeFeaturesSelectedEvent event = new BeforeFeaturesSelectedEvent(
                        eventObject);
                listener.onBeforeFeaturesSelected(event);
            }

        });
    }

    public void addFeaturesSelectedListener(
            final FeaturesSelectedListener listener) {

        eventListeners.addListener(this, listener, EventType.FEATURES_SELECTED,
                new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                FeaturesSelectedEvent event = new FeaturesSelectedEvent(
                        eventObject);
                listener.onFeaturesSelected(event);
            }

        });
    }

    public void addFeatureUnselectedListener(
            final FeatureUnselectedListener listener) {

        eventListeners.addListener(this, listener, EventType.FEATURE_UNSELECTED,
                new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                FeatureUnselectedEvent event = new FeatureUnselectedEvent(
                        eventObject);
                listener.onFeatureUnselected(event);
            }

        });
    }

    public void addFeatureClickoutListener(
            final FeatureClickoutListener listener) {

        eventListeners.addListener(this, listener, EventType.CLICK_OUT,
                new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                FeatureClickoutListener.FeatureClickoutEvent event = new FeatureClickoutListener.FeatureClickoutEvent(
                        eventObject);
                listener.onFeatureClickout(event);
            }

        });
    }

    public void addHoverFeatureListener(final HoverFeatureListener listener) {

        eventListeners.addListener(this, listener, EventType.HOVER_FEATURE,
                new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                HoverFeatureListener.HoverFeatureEvent event = new HoverFeatureListener.HoverFeatureEvent(
                        eventObject);
                listener.onHoverFeature(event);
            }

        });
    }

    public void addOutFeatureListener(final OutFeatureListener listener) {

        eventListeners.addListener(this, listener, EventType.OUT_FEATURE,
                new EventHandler() {

            @Override
            public void onHandle(EventObject eventObject) {
                OutFeatureListener.OutFeatureEvent event = new OutFeatureListener.OutFeatureEvent(
                        eventObject);
                listener.onOutFeature(event);
            }

        });
    }

}
