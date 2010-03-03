package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.VectorBeforeFeatureAddedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureAddedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureModifiedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureRemovedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener;
import org.gwtopenmaps.openlayers.client.event.VectorBeforeFeatureAddedListener.BeforeFeatureAddedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureAddedListener.FeatureAddedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureModifiedListener.FeatureModifiedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureRemovedListener.FeatureRemovedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureSelectedListener.FeatureSelectedEvent;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureUnselectedListener.FeatureUnselectedEvent;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * 
 */
public class Vector extends Layer {

	protected Vector(JSObject vector) {
		super(vector);
	}

	public static Vector narrowToVector(JSObject vectorLayer) {
		return (vectorLayer == null) ? null : new Vector(vectorLayer);
	}
	
	public Vector(String name) {
		this(VectorImpl.create(name));
	}

	public Vector(String name, VectorOptions options) {
		this(VectorImpl.create(name, options.getJSObject()));
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

	public boolean redraw() {
		return VectorImpl.redraw(this.getJSObject());
	}

	public void drawFeature(VectorFeature vector, Style style) {
		VectorImpl.drawFeature(this.getJSObject(), vector.getJSObject(), style.getJSObject());
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

	/**
	 * @return Array of VectorFeature objects or null if layer does not contain
	 *         any features
	 */
	public VectorFeature[] getFeatures() {
		int nr = getNumberOfFeatures();
		if (nr < 1) {
			return null;
		} else {
			VectorFeature[] vfs = new VectorFeature[nr];
			for (int i = 0; i < nr; i++) {
				VectorFeature vf = VectorFeature.narrowToVectorFeature(VectorImpl.getFeature(getJSObject(), i));
				vfs[i] = vf;
			}
			return vfs;
		}
	};

	/**
	 * Destroy all features in the vector layer
	 */
	public void destroyFeatures() {
		VectorImpl.destroyFeatures(getJSObject());
	}

	public VectorFeature getFeatureById(String id) {
		return VectorFeature.narrowToVectorFeature(VectorImpl.getFeatureById(getJSObject(), id));
	}

	// TODO add method for getting selected features
	public VectorFeature[] getSelectedFeatures() {
		return null;
	}

	public void addVectorFeatureModifiedListener(final VectorFeatureModifiedListener listener) {
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_MODIFIED, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				FeatureModifiedEvent e = new FeatureModifiedEvent(eventObject);
				listener.onFeatureModified(e);
			}
		});
	}

	public void addVectorFeatureAddedListener(final VectorFeatureAddedListener listener) {
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_ADDED, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				FeatureAddedEvent e = new FeatureAddedEvent(eventObject);
				listener.onFeatureAdded(e);
			}
		});
	}

	public void addVectorFeatureRemovedListener(final VectorFeatureRemovedListener listener) {
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_REMOVED, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				FeatureRemovedEvent e = new FeatureRemovedEvent(eventObject);
				listener.onFeatureRemoved(e);
			}
		});
	}

	public void addVectorFeatureSelectedListener(final VectorFeatureSelectedListener listener) {
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_SELECTED, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				FeatureSelectedEvent e = new FeatureSelectedEvent(eventObject);
				listener.onFeatureSelected(e);
			}
		});
	}

	public void addVectorFeatureUnselectedListener(final VectorFeatureUnselectedListener listener) {
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_UNSELECTED, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				FeatureUnselectedEvent e = new FeatureUnselectedEvent(eventObject);
				listener.onFeatureUnselected(e);
			}
		});
	}

	public void addVectorBeforeFeatureAddedListener(final VectorBeforeFeatureAddedListener listener) {
		eventListeners.addListener(this, listener, EventType.VECTOR_BEFORE_FEATURE_ADDED, new EventHandler() {
			public void onHandle(EventObject eventObject) {
				BeforeFeatureAddedEvent e = new BeforeFeatureAddedEvent(eventObject);
				listener.onBeforeFeatureAdded(e);
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

}