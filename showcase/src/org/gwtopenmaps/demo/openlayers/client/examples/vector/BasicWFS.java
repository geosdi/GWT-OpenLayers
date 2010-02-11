package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

public class BasicWFS implements ShowcaseExample {

	private MapExample example;

	private WMS wmsLayer;

	public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";
	
	public BasicWFS(){
		example = new MapExample();
		
		//Defining a WMSLayer and adding it to a Map
		WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setLayers("basic");
		wmsParams.setStyles("");

		WMSOptions wmsLayerParams = new WMSOptions();
		wmsLayerParams.setUntiled();
		wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

		wmsLayer = new WMS(
				"Basic WMS",
				WMS_URL,
				wmsParams,
				wmsLayerParams);

		example.getMap().addLayers(new Layer[] {wmsLayer});
		
		//Defining a WFS and adding it to the map
		//Define a WFS with WFS protocol
	}

	public MapExample getMapExample() {	
		return this.example;
	}
}
