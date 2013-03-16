/**
 *
 *   Copyright 2013 sourceforge.
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

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.VectorAfterFeatureModifiedListener;
import org.gwtopenmaps.openlayers.client.event.VectorAfterFeatureModifiedListener.AfterFeatureModifiedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorBeforeFeatureAddedListener;
import org.gwtopenmaps.openlayers.client.event.VectorBeforeFeatureAddedListener.BeforeFeatureAddedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorBeforeFeatureModifiedListener;
import org.gwtopenmaps.openlayers.client.event.VectorBeforeFeatureModifiedListener.BeforeFeatureModifiedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureAddedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureAddedListener.FeatureAddedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureModifiedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureModifiedListener.FeatureModifiedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureRemovedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureRemovedListener.FeatureRemovedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener.FeatureSelectedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener.FeatureUnselectedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorVertexModifiedListener;
import org.gwtopenmaps.openlayers.client.event.VectorVertexModifiedListener.VertexModifiedEvent;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.filter.Filter;
import org.gwtopenmaps.openlayers.client.protocol.Protocol;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * @author Lukas Johansson
 */
public class Vector extends Layer {

    public static Vector narrowToVector(JSObject vectorLayer) {
        return (vectorLayer == null) ? null : new Vector(vectorLayer);
    }

    private VectorOptions vectorOptions;

    protected Vector(JSObject vector) {
        super(vector);
    }

    public Vector(String name) {
        this(VectorImpl.create(name));
    }

    public Vector(String name, VectorOptions options) {
        this(VectorImpl.create(name, options.getJSObject()));
        this.vectorOptions = options;
    }

    /**
     * Get the VectorOptions.
     * @return The VectorOptions.
     */
    public VectorOptions getVectorOptions()
    {
        return this.vectorOptions;
    }

    public void addFeatures(VectorFeature[] features) {
        JObjectArray a = new JObjectArray(features);
        VectorImpl.addFeatures(getJSObject(), a.getJSObject());

        /*
         * Solution without relay (see VectorImpl): for(int i = 0, max =
         * features.length; i < max; i++){ addFeature(features[i]); }
         */
    }

    public void addFeature(VectorFeature f) {
        VectorImpl.addFeature(getJSObject(), f.getJSObject());
    }

    @Override
    public boolean redraw() {
        return VectorImpl.redraw(this.getJSObject());
    }

    public void drawFeature(VectorFeature vector) {
        VectorImpl.drawFeature(this.getJSObject(), vector.getJSObject());
    }

    public void drawFeature(VectorFeature vector, Style style) {
        VectorImpl.drawFeature(this.getJSObject(), vector.getJSObject(),
                               style.getJSObject());
    }

    public void eraseFeatures() {
        VectorImpl.eraseFeatures(this.getJSObject());
    }

    public void removeFeature(VectorFeature feature) {
        VectorImpl.removeFeature(getJSObject(), feature.getJSObject());
    }

    public int getNumberOfFeatures() {
        return VectorImpl.getNumberOfFeatures(getJSObject());
    }

    public int getNumberOfSelectedFeatures() {
        return VectorImpl.getNumberOfSelectedFeatures(getJSObject());
    }

    public OpenLayersObjectWrapper getProtocol() {
        return Protocol.narrowToOpenLayersObjectWrapper(getJSObject().getProperty(
                "protocol"));
    }

    public void setStyle(Style style) {
        VectorImpl.setStyle(getJSObject(), style.getJSObject());
    }

    public Style getStyle() {
        return Style.narrowToOpenLayersStyle(VectorImpl.getStyle(getJSObject()));
    }

    public void setStyleMap(StyleMap styleMap) {
        VectorImpl.setStyleMap(getJSObject(), styleMap.getJSObject());
    }

    public StyleMap getStyleMap() {
        return StyleMap.narrowToOpenLayersStyleMap(VectorImpl.getStyleMap(
                getJSObject()));
    }

    /**
     * @return Array of VectorFeature objects or null if layer does not contain
     * any features
     */
    public VectorFeature[] getFeatures() {
        int nr = getNumberOfFeatures();
        if (nr < 1) {
            return null;
        } else {
            VectorFeature[] vfs = new VectorFeature[nr];
            for (int i = 0; i < nr; i++) {
                VectorFeature vf = VectorFeature.narrowToVectorFeature(VectorImpl.getFeature(
                        getJSObject(), i));
                vfs[i] = vf;
            }

            return vfs;
        }
    }

    /**
     * Destroy all features in the vector layer
     */
    public void destroyFeatures() {
        VectorImpl.destroyFeatures(getJSObject());
    }

    public VectorFeature getFeatureById(String id) {
        return VectorFeature.narrowToVectorFeature(VectorImpl.getFeatureById(
                getJSObject(), id));
    }

    /**
     * Gets an array of all selected features.
     *
     * @return Array of VectorFeature objects or null if layer does not contain
     * any features
     */
    public VectorFeature[] getSelectedFeatures() {
        int nr = getNumberOfSelectedFeatures();
        if (nr < 1) {
            return null;
        } else {
            VectorFeature[] vfs = new VectorFeature[nr];
            for (int i = 0; i < nr; i++) {
                VectorFeature vf = VectorFeature.narrowToVectorFeature(VectorImpl.getSelectedFeature(
                        getJSObject(), i));
                vfs[i] = vf;
            }

            return vfs;
        }
    }

    public void addVectorFeatureModifiedListener(
            final VectorFeatureModifiedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_FEATURE_MODIFIED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                FeatureModifiedEvent e = new FeatureModifiedEvent(eventObject);
                listener.onFeatureModified(e);
            }
        });
    }

    public void addVectorFeatureAddedListener(
            final VectorFeatureAddedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_FEATURE_ADDED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                FeatureAddedEvent e = new FeatureAddedEvent(eventObject);
                listener.onFeatureAdded(e);
            }
        });
    }

    public void addVectorFeatureRemovedListener(
            final VectorFeatureRemovedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_FEATURE_REMOVED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                FeatureRemovedEvent e = new FeatureRemovedEvent(eventObject);
                listener.onFeatureRemoved(e);
            }
        });
    }

    public void addVectorFeatureSelectedListener(
            final VectorFeatureSelectedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_FEATURE_SELECTED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                FeatureSelectedEvent e = new FeatureSelectedEvent(eventObject);
                listener.onFeatureSelected(e);
            }
        });
    }

    public void addVectorFeatureUnselectedListener(
            final VectorFeatureUnselectedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_FEATURE_UNSELECTED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                FeatureUnselectedEvent e = new FeatureUnselectedEvent(
                        eventObject);
                listener.onFeatureUnselected(e);
            }
        });
    }

    public void addVectorBeforeFeatureAddedListener(
            final VectorBeforeFeatureAddedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_BEFORE_FEATURE_ADDED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                BeforeFeatureAddedEvent e = new BeforeFeatureAddedEvent(
                        eventObject);
                listener.onBeforeFeatureAdded(e);
            }
        });
    }

    /**
     * Add Listener for AfterModifiedEvent
     *
     * @param listener
     */
    public void addVectorAfterFeatureModifiedListener(
            final VectorAfterFeatureModifiedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_AFTER_FEATURE_MODIFIED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                // TODO Auto-generated method stub
                AfterFeatureModifiedEvent e = new AfterFeatureModifiedEvent(
                        eventObject);
                listener.onAfterFeatureModified(e);
            }
        });
    }

    /**
     * Add Listener for BeforeModifiedEvent
     *
     * @param listener
     */
    public void addVectorBeforeFeatureModifiedListener(
            final VectorBeforeFeatureModifiedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_BEFORE_FEATURE_MODIFIED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                // TODO Auto-generated method stub
                BeforeFeatureModifiedEvent e = new BeforeFeatureModifiedEvent(
                        eventObject);
                listener.onBeforeFeatureModified(e);
            }
        });
    }

    /**
     * Add Listener for VertexModifiedEvent
     *
     * @param listener
     */
    public void addVectorVertexModifiedListener(
            final VectorVertexModifiedListener listener) {
        eventListeners.addListener(this, listener,
                                   EventType.VECTOR_FEATURE_VERTEX_MODIFIED,
                                   new EventHandler() {
            @Override
            public void onHandle(EventObject eventObject) {
                // TODO Auto-generated method stub
                VertexModifiedEvent e = new VertexModifiedEvent(
                        eventObject);
                listener.onVertexModifiedEvent(e);
            }
        });
    }

    /**
     * Calculates the max extent which includes all of the features of this
     * vetor layer.
     *
     * @return The bounds of the max extend calculated
     */
    public Bounds getDataExtent() {
        return Bounds.narrowToBounds(VectorImpl.getDataExtentImp(getJSObject()));
    }

    /**
     * Set a filter, or unset the filter if passed filter is null.
     * @param filter The filter to set
     */
    public void setFilter(final Filter filter)
    {
        if (filter != null) getJSObject().setProperty("filter", filter.getJSObject());
        else getJSObject().unsetProperty("filter");
    }
    
    /**
     * This causes text and geometry to be rendered in the same container.
     * Can be used to fix weird overlapping of texts.
     * @see http://osgeo-org.1560.n6.nabble.com/Problems-with-labels-td4991177.html
     */
    public void setTextRootRendererToVectorRootRenderer()
    {
    	getJSObject().getProperty("renderer").setProperty("textRoot", getJSObject().getProperty("renderer").getProperty("vectorRoot"));
    }
}
