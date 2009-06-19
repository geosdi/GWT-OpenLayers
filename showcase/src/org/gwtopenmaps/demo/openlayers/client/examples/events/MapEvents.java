package org.gwtopenmaps.demo.openlayers.client.examples.events;

import java.util.Iterator;
import java.util.Set;

import org.gwtopenmaps.demo.openlayers.client.examples.ExampleConstants;
import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolBar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.event.EventListener;
import org.gwtopenmaps.openlayers.client.event.MapBaseLayerChangedListener;
import org.gwtopenmaps.openlayers.client.event.MapClickListener;
import org.gwtopenmaps.openlayers.client.event.MapLayerAddedListener;
import org.gwtopenmaps.openlayers.client.event.MapLayerChangedListener;
import org.gwtopenmaps.openlayers.client.event.MapMoveListener;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.TextArea;

public class MapEvents implements ShowcaseExample {

	private MapExample example;

	private WMS wmsLayer;

	private TextArea eventMessageArea;

	public MapEvents(){
		example = new MapExample();

		//Defining a WMSLayer and adding it to a Map
		WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setLayers(ExampleConstants.METACARTA_WMS_BASIC_LAYER);
		wmsParams.setStyles("");

		WMSOptions wmsLayerParams = new WMSOptions();
		wmsLayerParams.setUntiled();
		wmsLayerParams.setTransitionEffectResize();

		wmsLayer = new WMS(
				"Basic WMS",
				ExampleConstants.METACARTA_WMS_URL,
				wmsParams,
				wmsLayerParams);




		WMSParams wmsParams2 = new WMSParams();
		wmsParams2.setFormat("image/png");
		wmsParams2.setLayers("Countries,Borders,Coastline");
		wmsParams2.setStyles("");

		WMSOptions wmsLayerParams2 = new WMSOptions();
		wmsLayerParams2.setUntiled();
		wmsLayerParams2.setTransitionEffectResize();

		WMS wmsLayer2 = new WMS(
				"Demis WMS",
				"http://www2.demis.nl/wms/wms.asp?",
				wmsParams2,
				wmsLayerParams2);

		//Gewoon GoogleLayer toevoegen leid tot nulpointer excepties
		//Google googleLayer = new Google("Google Hybrid");
		//example.getMap().addLayers(new Layer[] {googleLayer});

		example.getMap().addControl(new PanZoomBar());
		//use NavToolbar instead of deprecated MouseToolbar
		example.getMap().addControl(new NavToolBar());
		example.getMap().addControl(new MousePosition());
		example.getMap().addControl(new LayerSwitcher());

		eventMessageArea = new TextArea();
		eventMessageArea.setText(" Events\n----------");
		eventMessageArea.setHeight("20em");
		//TODO this exposes that example is a DockPanel ...
		example.add(eventMessageArea, DockPanel.EAST);
/*
		example.getMap().getEvents().register("move", example.getMap(), new EventHandler(){
			public void onHandle(JSObject source, EventObject eo) {

				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n" + "event: " + eo.getType());
			}
		});
	  */


		example.getMap().addMapLayerAddedListener(new MapLayerAddedListener(){

			public void onLayerAdded(MapLayerAddedEvent eventObject) {
				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n\n" + "event: " + eventObject.getType() + "; source: " + eventObject.getSource().getClass() + eventObject.getLayer().getId());
			}

		});

		example.getMap().addMapLayerChangedListener(new MapLayerChangedListener(){

			public void onLayerChanged(MapLayerChangedEvent eventObject) {
				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n\n" + "event: " + eventObject.getType() + "; source: " + eventObject.getSource().getClass() + eventObject.getLayer().getId());
			}

		});

		example.getMap().addMapBaseLayerChangedListener(new MapBaseLayerChangedListener(){

			public void onBaseLayerChanged(MapBaseLayerChangedEvent eventObject) {
				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n\n" + "event: " + eventObject.getType() + "; source: " + eventObject.getSource().getClass() + " layer: " + eventObject.getLayer().getId());
			}

		});

		MapMoveListener moveListener1 = new MapMoveListener(){

			public void onMapMove(MapMoveEvent eventObject) {
				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n\n" + "event: " + eventObject.getType() + "; source: " + eventObject.getSource().getClass());
			}

		};

		MapMoveListener moveListener2 = new MapMoveListener(){

			public void onMapMove(MapMoveEvent eventObject) {
				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n\n" + "another event: " + eventObject.getType() + "; source: " + eventObject.getSource().getClass());
			}

		};

		MapClickListener mapClickListener = new MapClickListener(){

			public void onClick(MapClickEvent eventObject){
				LonLat lonlat = eventObject.getLonLat();
				String txt = eventMessageArea.getText();
				eventMessageArea.setText(txt + "\n\n" + "click event: " + lonlat.lon() + ", " + lonlat.lat()
					+ "; source: " + eventObject.getSource().getClass());
			}

		};

		example.getMap().addMapMoveListener(moveListener1);
		example.getMap().addMapMoveListener(moveListener2);
		example.getMap().addMapClickListener(mapClickListener);

		//Center and Zoom
		double lon = 4.0;
		double lat = 5.0;
		int zoom = 5;
		example.getMap().addLayers(new Layer[] {wmsLayer});
		example.getMap().addLayers(new Layer[] {wmsLayer2});

		example.getMap().setCenter(new LonLat(lon, lat), zoom);

		example.getMap().removeListener(moveListener2);
		Set listeners = example.getMap().getListeners();
		int counter = 1;
		for(Iterator it = listeners.iterator(); it.hasNext();){
			EventListener el = (EventListener) it.next();

			if(el instanceof MapClickListener){
				Window.alert("Map click listener: " + counter);
			}
			if(el instanceof MapBaseLayerChangedListener){
				Window.alert("Map baseLayerChanged listener." + counter);
			}
			counter++;
		}

	}

	public MapExample getMapExample() {
		return this.example;
	}


}
