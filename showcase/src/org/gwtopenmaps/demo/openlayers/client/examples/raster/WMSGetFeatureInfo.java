package org.gwtopenmaps.demo.openlayers.client.examples.raster;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.OpenLayers;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

public class WMSGetFeatureInfo implements ShowcaseExample {

	MapExample example;

	private WMS stateBoundaries;
	private WMS waterBodies;

	public static final String WMS_URL = "http://demo.opengeo.org/geoserver/wms";

	public WMSGetFeatureInfo (){
		example = new MapExample();

		example.getMap().setMaxExtent(new Bounds(143.834,-43.648,148.479,-39.573));

		//set a proxyHost
		OpenLayers.setProxyHost("gwtOpenLayersProxy?targetURL=");

		//Defining WMS layers and adding them to the Map
		WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setLayers("topp:tasmania_state_boundaries");
		wmsParams.setIsTransparent(true);
		wmsParams.setStyles("");

		WMSOptions wmsLayerParams = new WMSOptions();
		wmsLayerParams.setUntiled();
		wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);
		wmsLayerParams.setIsBaseLayer(true);

		stateBoundaries = new WMS(
				"State Boundaries",
				WMS_URL,
				wmsParams,
				wmsLayerParams);

		example.getMap().addLayers(new Layer[] {stateBoundaries});

		wmsParams.setLayers("topp:tasmania_water_bodies");
		wmsLayerParams.setIsBaseLayer(false);

		waterBodies =  new WMS(
				"Water Bodies",
				WMS_URL,
				wmsParams,
				wmsLayerParams);

		example.getMap().addLayers(new Layer[] {waterBodies});
		example.getMap().zoomToMaxExtent();

	}

	public MapExample getMapExample() {
		return this.example;
	}

}
