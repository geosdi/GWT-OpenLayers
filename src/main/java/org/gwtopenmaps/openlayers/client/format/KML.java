package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.feature.Feature;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Brief explanation of Keyhole Markup Language (KML) vector format here.
 *
 * Reference to KML specification. KML 2.0 is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class KML extends VectorFormat {

	protected KML(JSObject kmlFormat){
		super(kmlFormat);
	}

	public KML(){
		this(KMLImpl.create());
	}

	public VectorFeature[] read(String kmlString) {
		JSObject kmlFeatures = KMLImpl.read(this.getJSObject(), kmlString);
		JSObject[] kmlFeatureArray = JObjectArray.narrowToJObjectArray(kmlFeatures).toArray();
		VectorFeature[] features = new VectorFeature[kmlFeatureArray.length];
		for (int i = 0; i < kmlFeatureArray.length; i++)
			features[i] = VectorFeature.narrowToVectorFeature(kmlFeatureArray[i]);

		return features;  
	}
	
	public String write(Feature features, boolean pretty) {
		return KMLImpl.write(this.getJSObject(), features.getJSObject(), pretty);
	}
}
