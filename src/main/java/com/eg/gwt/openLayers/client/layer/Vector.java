package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.event.EventHandler;
import com.eg.gwt.openLayers.client.event.EventType;
import com.eg.gwt.openLayers.client.event.VectorBeforeFeatureAddedListener;
import com.eg.gwt.openLayers.client.event.VectorFeatureAddedListener;
import com.eg.gwt.openLayers.client.event.VectorFeatureModifiedListener;
import com.eg.gwt.openLayers.client.event.VectorFeatureRemovedListener;
import com.eg.gwt.openLayers.client.event.VectorFeatureSelectedListener;
import com.eg.gwt.openLayers.client.event.VectorFeatureUnselectedListener;
import com.eg.gwt.openLayers.client.event.VectorBeforeFeatureAddedListener.BeforeFeatureAddedEvent;
import com.eg.gwt.openLayers.client.event.VectorFeatureAddedListener.FeatureAddedEvent;
import com.eg.gwt.openLayers.client.event.VectorFeatureModifiedListener.FeatureModifiedEvent;
import com.eg.gwt.openLayers.client.event.VectorFeatureRemovedListener.FeatureRemovedEvent;
import com.eg.gwt.openLayers.client.event.VectorFeatureSelectedListener.FeatureSelectedEvent;
import com.eg.gwt.openLayers.client.event.VectorFeatureUnselectedListener.FeatureUnselectedEvent;
import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.util.JObjectArray;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Vector extends Layer {

	protected Vector(JSObject element) {
		super(element);
	}

	public Vector(String name) {
		this(VectorImpl.create(name));
	}

	public static Vector narrowToVector(JSObject vectorLayer){
		return (vectorLayer == null)?null:new Vector(vectorLayer);
	}

	//maintain for backwards compatibility
	public Vector(String name, Options options) {
		this(VectorImpl.create(name, options.getJSObject()));
	}

	public Vector(String name, VectorParams options) {
		this(VectorImpl.create(name, options.getJSObject()));
	}

	public void addFeatures(VectorFeature[] features){
		JObjectArray a = new JObjectArray(features);
		VectorImpl.addFeatures(getJSObject(), a.getJSObject());

		/* Solution without relay (see VectorImpl):
		for(int i = 0, max = features.length; i < max; i++){
			addFeature(features[i]);
		}*/
	}

	public void addFeature(VectorFeature f){
		VectorImpl.addFeature(getJSObject(), f.getJSObject());
	}


	public int getNumberOfFeatures(){
		return VectorImpl.getNumberOfFeatures(getJSObject());
	}

	/**
	 * @return Array of VectorFeature objects or null if layer does not contain any features
	 */
	public VectorFeature[] getFeatures(){
		int nr = getNumberOfFeatures();
		if(nr < 1 ){
			return null;
		} else {
			VectorFeature[] vfs = new VectorFeature[nr];
			for(int i = 0; i < nr; i++){
				VectorFeature vf = VectorFeature.narrowToVectorFeature(
						VectorImpl.getFeature(getJSObject(), i));
				vfs[i] = vf;
			}
			return vfs;
		}
	};

	/**
	 * Destroy all features in the vector layer
	 */
	public void destroyFeatures(){
		VectorImpl.destroyFeatures(getJSObject());
	}

	public VectorFeature getFeatureById(String id){
		return VectorFeature.narrowToVectorFeature(
				VectorImpl.getFeatureById(getJSObject(), id));
	}

	//TODO add method for getting selected features
	public VectorFeature[] getSelectedFeatures(){
		return null;
	}

	public void addVectorFeatureModifiedListener(final VectorFeatureModifiedListener listener){
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_MODIFIED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Vector vector = Vector.narrowToVector(source);
				FeatureModifiedEvent e = new FeatureModifiedEvent(eventObject);
				listener.onFeatureModified(vector, e);
			}
		 });
	}

	public void addVectorFeatureAddedListener(final VectorFeatureAddedListener listener){
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_ADDED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Vector vector = Vector.narrowToVector(source);
				FeatureAddedEvent e = new FeatureAddedEvent(eventObject);
				listener.onFeatureAdded(vector, e);
			}
		 });
	}

	public void addVectorFeatureRemovedListener(final VectorFeatureRemovedListener listener){
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_REMOVED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Vector vector = Vector.narrowToVector(source);
				FeatureRemovedEvent e = new FeatureRemovedEvent(eventObject);
				listener.onFeatureRemoved(vector, e);
			}
		 });
	}

	public void addVectorFeatureSelectedListener(final VectorFeatureSelectedListener listener){
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_SELECTED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Vector vector = Vector.narrowToVector(source);
				FeatureSelectedEvent e = new FeatureSelectedEvent(eventObject);
				listener.onFeatureSelected(vector, e);
			}
		 });
	}

	public void addVectorFeatureUnselectedListener(final VectorFeatureUnselectedListener listener){
		eventListeners.addListener(this, listener, EventType.VECTOR_FEATURE_UNSELECTED, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Vector vector = Vector.narrowToVector(source);
				FeatureUnselectedEvent e = new FeatureUnselectedEvent(eventObject);
				listener.onFeatureUnselected(vector, e);
			}
		 });
	}

	public void addVectorBeforeFeatureAddedListener(final VectorBeforeFeatureAddedListener listener){
		eventListeners.addListener(this, listener, EventType.VECTOR_BEFORE_FEATURE_ADDED,  new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Vector vector = Vector.narrowToVector(source);
				BeforeFeatureAddedEvent e = new BeforeFeatureAddedEvent(eventObject);
				listener.onBeforeFeatureAdded(vector, e);

			}
		});
	}

}