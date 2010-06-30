package org.gwtopenmaps.demo.openlayers.client.examples.raster;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolbar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

public class BasicWMS implements ShowcaseExample {

	private MapExample example;

	private WMS wmsLayer;

	public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";

	public BasicWMS(){

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

		//Adding controls to the Map
		example.getMap().addControl(new PanZoomBar());
		//use NavToolbar instead of deprecated MouseToolbar
		example.getMap().addControl(new NavToolbar());
		example.getMap().addControl(new MousePosition());
		example.getMap().addControl(new LayerSwitcher());

		//Center and Zoom
		double lon = 4.0;
		double lat = 5.0;
		int zoom = 5;
		example.getMap().setCenter(new LonLat(lon, lat), zoom);
	}

	public MapExample getMapExample(){
		return this.example;
	}


}
